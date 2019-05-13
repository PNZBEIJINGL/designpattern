/***********************************************************************
 *
 * [�ļ�������Ϣ]
 *
 * stariboss-accept 1.0Դ���뿽��Ȩ�������Ĵ�ʱ������������޹�˾���У�
 * �ܵ����ɵı������κι�˾����ˣ�δ����Ȩ�������Կ�����    
 *
 * @copyright Copyright: 2002-2015 Beijing Startimes
 * Software Technology Co. Ltd.
 * @creator 10001874 10001874@startimes.com.cn
 * @create-time 2018-5-31 ����11:52:06
 * @revision $Id: TransactionGuarded.java,v 1.1.2.6 2018/11/26 07:08:55 liuyong Exp $
 *
 ***********************************************************************/
package com.used.batch;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author LIUY ���������(�����ػ���)
 */
public class TransactionGuarded {

	private final Log logger = LogFactory.getLog(getClass());

	private final int number; // �ػ����߳�����
	private AtomicInteger currentNum = new AtomicInteger(0);

	private State status;

	protected enum State {
		FAILED, WORKING, SUCESSES;
	}

	public TransactionGuarded(int number) {
		this.number = number;
		this.status = State.WORKING;
	}

	public synchronized boolean isSuccess() {
		return State.SUCESSES == status;
	}

	public synchronized void hold(String threadName)
			throws InterruptedException {
		if (!status.equals(State.WORKING)) {
			return;
		}

		int num = currentNum.incrementAndGet();
		if (num == number) {
			logger.info(threadName + " all successful, do weak up");
			status = State.SUCESSES;
			weakUpAll();
		} else {
			logger.info(threadName + " is waiting, " + num + "/" + number);
			doHold();
		}
	}

	public synchronized void setFailed() {
		if (!status.equals(State.FAILED)) {
			logger.info(Thread.currentThread().getName()
					+ " is error, do weak up");
			status = State.FAILED;
			weakUpAll();
		}
	}
	
	private void doHold() throws InterruptedException {
		try {
			this.wait(45 * 60 * 1000);
			if (status.equals(State.WORKING)) {
				logger.error(Thread.currentThread().getName()+ " weak up for holding time out");
				setFailed();
			}
		} catch (Exception e) {
			logger.error(Thread.currentThread().getName()+" Holding error:", e);
			setFailed();
		}
	}

	/**
	 * ���������߳�
	 */
	private void weakUpAll() {
		this.notifyAll();
	}

}
