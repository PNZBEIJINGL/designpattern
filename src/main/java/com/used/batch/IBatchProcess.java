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
 * @create-time 2018-6-1 ����2:15:30
 * @revision $Id: IBatchProcess.java,v 1.1.2.2 2018/07/21 09:01:22 liuyong Exp $
 *
 ***********************************************************************/
package com.used.batch;

import java.util.List;

import com.star.sms.model.core.ApplicationSession;

/**
 * @author LIUY
 * 
 */
public interface IBatchProcess<T> {
	
	void setSession(ApplicationSession session);
	
	void setTaskGuarded(TransactionGuarded taskGuarded);
	
	Object call(List<T> list);
}
