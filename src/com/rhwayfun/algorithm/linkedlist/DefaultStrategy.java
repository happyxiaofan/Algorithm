package com.rhwayfun.algorithm.linkedlist;

/**
 * 
 * <p>Title:DefaultStrategy</p>
 * <p>Description:规定数组比较的默认规则</p>
 * @author rhwayfun
 * @date Aug 27, 2015 11:14:55 AM
 * @version 1.0
 */
public class DefaultStrategy implements Strategy {

	public int compare(Object e1, Object e2) {
		if(e1 instanceof Integer && e2 instanceof Integer){
			Integer i1 = (Integer) e1;
			Integer i2 = (Integer) e2;
			return i1.compareTo(i2);
		}
		return e1.toString().compareTo(e2.toString());
	}

	public boolean equal(Object e1, Object e2) {
		if(e1 instanceof Integer && e2 instanceof Integer){
			Integer i1 = (Integer) e1;
			Integer i2 = (Integer) e2;
			return i1.equals(i2);
		}
		return e1.toString().equals(e2.toString());
	}

}
