/***********************************************************************
 *
 * [�ļ�������Ϣ]
 *
 * stariboss-common 1.0Դ���뿽��Ȩ�������Ĵ�ʱ������������޹�˾���У�
 * �ܵ����ɵı������κι�˾����ˣ�δ����Ȩ�������Կ�����    
 *
 * @copyright Copyright: 2002-2015 Beijing Startimes
 * Software Technology Co. Ltd.
 * @creator 10001874 10001874@startimes.com.cn
 * @create-time 2018-6-29 ����4:40:37
 * @revision $Id: GroupSpliter.java,v 1.1.2.3 2018/08/07 03:16:21 liuyong Exp $
 *
 ***********************************************************************/
package com.used.batch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LIUY
 * 
 */
public class GroupSpliter<T> {

	public Map<Integer, List<T>> splitByGroupNum(List<T> list, int groupNum) {
		Map<Integer, List<T>> resultMap = new HashMap<Integer, List<T>>();
		for (int j = 0; j < list.size(); j++) {
			int key = j % groupNum;
			if (resultMap.get(key) == null) {
				resultMap.put(key, new ArrayList<T>());
			}
			resultMap.get(key).add(list.get(j));
		}
		return resultMap;
	}

	public Map<Integer, List<T>> splitByGroupNum(Map<Object, List<T>> map,
			int groupNum) {
		Map<Integer, List<T>> resultMap = new HashMap<Integer, List<T>>();
		int number = 1;
		for (Object mapKey : map.keySet()) {
			int key = number % groupNum;
			if (resultMap.containsKey(key)) {
				int lessKey = getLessKey(resultMap);
				resultMap.get(lessKey).addAll(map.get(mapKey));
			} else {
				resultMap.put(key,map.get(mapKey));
			}

			number++;
		}
		return resultMap;
	}

	private Integer getLessKey(Map<Integer, List<T>> map) {
		Integer tempkey = null;
		for (Integer key : map.keySet()) {
			if (tempkey == null) {
				tempkey = key;
			} else if (map.get(key).size() < map.get(tempkey).size()) {
				tempkey = key;
			}
		}
		return tempkey;
	}

	public Map<Integer, List<T>> splitByGroupSize(List<T> list, int groupMaxSize) {
		Map<Integer, List<T>> resultMap = new HashMap<Integer, List<T>>();
		int key = 1;
		List<T> group = new ArrayList<T>();
		for (int j = 0; j < list.size(); j++) {
			group.add(list.get(j));
			if (group.size() == groupMaxSize) {
				resultMap.put(key, group);
				key++;
				group = new ArrayList();
			}
		}
		if (group.size() > 0) {
			resultMap.put(key, group);
		}

		return resultMap;
	}

	public Map<Integer, List<T>> splitByGroupSize(Map<Object, List<T>> map,
			int groupMaxSize) {
		Map<Integer, List<T>> resultMap = new HashMap<Integer, List<T>>();
		int key = 1;
		List<T> group = new ArrayList<T>();
		for (Object mapKey : map.keySet()) {
			group.addAll(map.get(mapKey));
			if (group.size() > groupMaxSize) {
				resultMap.put(key, group);
				key++;
				group = new ArrayList();
			}
		}
		if (group.size() > 0) {
			resultMap.put(key, group);
		}
		return resultMap;
	}
	
	public static void main(String[] args) {
		GroupSpliter<Integer> split = new GroupSpliter<Integer>();
		Map<Object,List<Integer>> dataMap = new HashMap<Object,List<Integer>>();
		dataMap.put(6, getListSizeEqual(6));
		dataMap.put(1, getListSizeEqual(1));
		dataMap.put(2, getListSizeEqual(2));
		dataMap.put(3, getListSizeEqual(3));
		dataMap.put(4, getListSizeEqual(4));
		dataMap.put(5, getListSizeEqual(5));
		Map<Integer, List<Integer>> result = split.splitByGroupNum(dataMap, 4);
		for (Object key : result.keySet()) {
			System.out.println("key:"+key+" size: "+result.get(key));
		}

	}
	
	private static List<Integer> getListSizeEqual(int i) {
		List<Integer> list = new ArrayList<Integer>();
		int addNum = i*10;
		for(int ii = 0;ii<i;ii++){
			list.add(ii+addNum);
		}
		return list;
	}
	
}
