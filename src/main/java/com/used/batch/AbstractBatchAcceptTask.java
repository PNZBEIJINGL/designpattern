
package com.used.batch;

import com.star.common.exception.MsrRuntimeException;
import com.star.sms.business.core.ApplicationSessionHolder;
import com.star.sms.model.core.ApplicationSession;

import java.util.List;

//import org.springframework.transaction.TransactionDefinition;
//import org.springframework.transaction.TransactionStatus;
//import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @author LIUY
 * 
 */
public abstract class AbstractBatchAcceptTask<T> implements IBatchProcess<T> {


	//private final Log logger = LogFactory.getLog(getClass());

	private TransactionGuarded transactionGuarded;

	public void setTaskGuarded(TransactionGuarded transactionGuarded) {
		this.transactionGuarded = transactionGuarded;

	}

	public BatchResult<Object, T> call(List<T> datas) {
		//logger.info(Thread.currentThread().getName() + " start|size="+ datas.size());
		long startTime = System.currentTimeMillis();

		BatchResult<Object, T> object = null;
		if (transactionGuarded == null) {
			object = processOnebyOne(datas);
		} else {
			object = processByGuarded(datas);
		}

		long processTime = System.currentTimeMillis() - startTime;
		//logger.info(Thread.currentThread().getName() + " end|time="+ (processTime/1000.00)+" s");
		return object;
	}

	private BatchResult<Object, T> processOnebyOne(List<T> datas) {
		BatchResult<Object, T> result = new BatchResult<Object, T>();
		for (T data : datas) {
			//PlatformTransactionManager transactionManager = getTransactionManager();
			//DefaultTransactionDefinition defination = new DefaultTransactionDefinition();
			//defination.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
			//TransactionStatus status = transactionManager.getTransaction(defination);
			Object successResult = null;
			FailResult<T> failResult = null;
			try {
				successResult = call(data);
			} catch (Exception ex) {
				//pringlog(ex);
				failResult = new FailResult<T>(data);
				failResult.setException(ex);
				failResult.setExceptionMsg(ex.getMessage());
			} finally {

				if (failResult != null) {
					//transactionManager.rollback(status);
					result.addFailResult(failResult);
				} else {
					//transactionManager.commit(status);
					result.addSucessObj(successResult);
				}
			}
		}
		result.setSucess(result.getFailList().size()==0 ? true: false);
		return result;
	}

	/*
	private void pringlog(Throwable ex) {
		if ((ex instanceof MsrRuntimeException)) {
			logger.debug(Thread.currentThread().getName() + " " + ex);
		} else {
			logger.error(Thread.currentThread().getName() + " ", ex);
		}
	}
	*/

	private BatchResult<Object, T> processByGuarded(List<T> datas) {
		//PlatformTransactionManager transactionManager = getTransactionManager();
		//DefaultTransactionDefinition defination = new DefaultTransactionDefinition();
		//defination.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		//TransactionStatus status = transactionManager.getTransaction(defination);
		BatchResult<Object, T> result = new BatchResult<Object, T>();
		try {
			result = processByCall(datas);
			if (result.getFailList().size()==0) {
				result.setSucess(true);
				transactionGuarded.hold(Thread.currentThread().getName());
			} else {
				result.setSucess(false);
				transactionGuarded.setFailed();
			}
		} catch (Throwable ex) {
			//pringlog(ex);
			result.setSucess(false);
			transactionGuarded.setFailed();
			throw new RuntimeException(ex);
		} finally {
			if (transactionGuarded.isSuccess()) {
				//transactionManager.commit(status);
			} else {
				//transactionManager.rollback(status);
			}
		}
		return result;
	}

	private BatchResult<Object, T> processByCall(List<T> datas) {
		BatchResult<Object, T> result = new BatchResult<Object, T>();
		T temp = null;
		for (T data : datas) {
			temp = data;
			try {
				Object object = call(data);
				result.addSucessObj(object);
			} catch (MsrRuntimeException ex) {
				//logger.info("batch MsrRuntimeException.case:" + ex);
				FailResult<T> failResult = new FailResult<T>(temp);
				failResult.setException(ex);
				//failResult.setExceptionMsg(ex.getMessage());
				result.addFailResult(failResult);
			}
		}
		
		doAfterCall(result.getSucessList());
		
		return result;
	}


	public void doAfterCall(List<Object> sucessList) {
		// YOU CAN OVERRIDE ME
	}

	public abstract Object call(T data);
	
	
	//private PlatformTransactionManager getTransactionManager() {
		//return  null;
		//return (PlatformTransactionManager) BeanFactoryHolder.getContext().getBean("transactionManager");
	//}
	

	public void setSession(ApplicationSession session) {
		ApplicationSession currentSession = ApplicationSessionHolder.getApplicationSession();
		if (currentSession == null) {
			ApplicationSessionHolder.put(session);
		}
	}

}
