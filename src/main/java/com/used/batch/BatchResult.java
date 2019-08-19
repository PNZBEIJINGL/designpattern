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
* @create-time 2018-6-20 ����3:23:08
* @revision $Id: BatchResult.java,v 1.1.2.3 2018/07/18 01:50:20 liuyong Exp $
*
***********************************************************************/
package com.used.batch;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LIUY
 *
 */
public class BatchResult<T,V> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1596454648943134282L;
	
	private boolean isSucess;
	
	private List<T> sucessList = new ArrayList<T>();
	
	private List<FailResult<V>> failList = new ArrayList<FailResult<V>>();


	/**
	 * @return the isSucess
	 */
	public boolean isSucess() {
		return isSucess;
	}

	/**
	 * @param isSucess the isSucess to set
	 */
	public void setSucess(boolean isSucess) {
		this.isSucess = isSucess;
	}
	
	public void addSucessObj(T obj) {
		sucessList.add(obj);
	}
	
	public void addFailResult(FailResult<V> obj) {
		failList.add(obj);
	}
	
	public void addSucessList(List<T> objList) {
		sucessList.addAll(objList);
	}
	
	public void addFailList(List<FailResult<V>> objList) {
		failList.addAll(objList);
	}
	
	public List<T> getSucessList() {
		return sucessList;
	}

	public List<FailResult<V>> getFailList() {
		return failList;
	}

}
