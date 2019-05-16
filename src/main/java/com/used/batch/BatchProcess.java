package com.used.batch;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.star.common.exception.MsrRuntimeException;
import com.star.sms.business.core.ApplicationSessionHolder;
import com.star.sms.model.core.ApplicationSession;

public class BatchProcess<T> {

	private final Log logger = LogFactory.getLog(getClass());
	private ApplicationSession session;
	private int threadNum = Runtime.getRuntime().availableProcessors();
	private int batchSize = 10;
	private IBatchProcess<T> batchProcess;

	/*
	public void setBatchTask(IBatchProcess<T> batchProcess) {
		this.session = ApplicationSessionHolder.getApplicationSession();
		this.batchProcess = batchProcess;
	}

	public void setTaskThreadNum(Integer threadNum) {
		if (threadNum!=null&&threadNum < Runtime.getRuntime().availableProcessors()) {
			this.threadNum = threadNum;
		}
	}

	public void setBatchSize(Integer batchSize) {
		if(batchSize!=null){
			this.batchSize = batchSize;			
		}
	}

	public BatchResult processInconsistency(Map<Object, List<T>> map) {
		GroupSpliter<T> utils = new GroupSpliter<T>();
		Map<Integer, List<T>> batchMap = utils.splitByGroupSize(map, batchSize);
		return process(batchMap, null);
	}

	public BatchResult processConsistency(Map<Object, List<T>> map) {
		GroupSpliter<T> utils = new GroupSpliter<T>();
		Map<Integer, List<T>> batchMap = utils.splitByGroupNum(map, threadNum);
		TransactionGuarded guarded = new TransactionGuarded(batchMap.keySet().size());
		return process(batchMap, guarded);
	}
	

	public BatchResult processInconsistency(List<T> list) {
		GroupSpliter<T> utils = new GroupSpliter<T>();
		Map<Integer, List<T>> batchMap = utils.splitByGroupSize(list, batchSize);
		return process(batchMap, null);
	}


	public BatchResult processConsistency(List<T> list) {
		GroupSpliter<T> utils = new GroupSpliter<T>();
		Map<Integer, List<T>> batchMap = utils.splitByGroupNum(list, threadNum);
		TransactionGuarded guarded = new TransactionGuarded(batchMap.keySet().size());
		return process(batchMap, guarded);
	}

	private BatchResult<Object, T> process(Map<Integer, List<T>> batchMap,
			TransactionGuarded guarded) {

		logger.info(Thread.currentThread().getName() +" start thread pool to process,thread num="+threadNum);
		long startTime = System.currentTimeMillis();
		ExecutorService executor = Executors.newFixedThreadPool(threadNum);
		try {
			List<Future<BatchResult<Object, T>>> futures = new ArrayList<Future<BatchResult<Object, T>>>();
			for (Integer key : batchMap.keySet()) {
				List<T> list = batchMap.get(key);
				Callable<BatchResult<Object, T>> task = createTask(list, guarded);
				futures.add(executor.submit(task));
			}
			return getResult(futures);
		}catch(Exception e){
			if (e instanceof TimeoutException) {
				logger.error(Thread.currentThread().getName()+ " Process.failure:time.out ", e);
			} else {
				logger.error(Thread.currentThread().getName()+ " Process failure:unknow.error ", e);
			}
			if (guarded != null) {
				guarded.setFailed();
			}
			throw MsrRuntimeException.newError("Batch.Process.failure");
		} finally {
			executor.shutdown();
			long processTime = System.currentTimeMillis() - startTime;
			logger.info(Thread.currentThread().getName() +" end thread pool|cost time="+ (processTime/1000.00)+" s");
		}
	}

	private Callable<BatchResult<Object, T>> createTask(final List<T> list,
			final TransactionGuarded taskGuarded) {

		Callable<BatchResult<Object, T>> task = new Callable<BatchResult<Object, T>>() {

			public BatchResult<Object, T> call() throws Exception {
				batchProcess.setTaskGuarded(taskGuarded);
				batchProcess.setSession(session);
				Object result =  batchProcess.call(list);
				if(result instanceof BatchResult){
					return (BatchResult<Object, T>)result;
				}else{
					throw new Exception("task result processed is not extends BatchResult class");
				}
			}
		};
		return task;
	}

	private BatchResult<Object, T> getResult(
			List<Future<BatchResult<Object, T>>> futures)
			throws InterruptedException, ExecutionException, TimeoutException {
		List<BatchResult<Object, T>> resultList = new ArrayList<BatchResult<Object, T>>();
		for (Future<BatchResult<Object, T>> future : futures) {
			resultList.add(future.get(30, TimeUnit.MINUTES));
		}
		
		BatchResult<Object, T> resultMerged = new BatchResult<Object, T>();
		boolean allSucess=true;
		for (BatchResult<Object, T> batchResult : resultList) {
			resultMerged.addSucessList(batchResult.getSucessList());
			resultMerged.addFailList(batchResult.getFailList());
			if(!batchResult.isSucess()){
				allSucess = false;
			}
		}
		resultMerged.setSucess(allSucess);
		return resultMerged;
	}


	*/
}
