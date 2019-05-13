/***********************************************************************
*
* [�ļ�������Ϣ]
*
* stariboss-domain 1.0Դ���뿽��Ȩ�������Ĵ�ʱ������������޹�˾���У�
* �ܵ����ɵı������κι�˾����ˣ�δ����Ȩ�������Կ�����    
*
* @copyright Copyright: 2002-2015 Beijing Startimes
* Software Technology Co. Ltd.
* @creator 10001874 10001874@startimes.com.cn
* @create-time 2018-6-20 ����4:14:34
* @revision $Id: FailResult.java,v 1.1.2.2 2018/06/25 08:00:22 liuyong Exp $
*
***********************************************************************/
package com.used.batch;

import java.io.Serializable;

/**
 * @author LIUY
 *
 */
public class FailResult<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 831992586715228498L;

	
	private String exceptionMsg;
	
	private Throwable exception;
	
	private T t;
	
	public FailResult(T t){
		this.t=t;
	}
	
	public T getProcessObject(){
		return t;
	}

	/**
	 * @return the exceptionMsg
	 */
	public String getExceptionMsg() {
		return exceptionMsg;
	}

	/**
	 * @param exceptionMsg the exceptionMsg to set
	 */
	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}

	/**
	 * @return the exception
	 */
	public Throwable getException() {
		return exception;
	}

	/**
	 * @param exception the exception to set
	 */
	public void setException(Throwable exception) {
		this.exception = exception;
	}

}
