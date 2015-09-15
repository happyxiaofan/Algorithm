package com.rhwayfun.algorithm.linkedlist;

/**
 * 
 * <p>Title:Strategy</p>
 * <p>Description:线性表元素的比较接口</p>
 * @author rhwayfun
 * @date Aug 24, 2015 9:42:26 PM
 * @version 1.0
 */
public interface Strategy {

	//比较两个元素是否相等
	public boolean equal(Object e1,Object e2);
	//比较两个元素的大小
	//如果e1 > e2 返回1，如果相等返回0，如果e1 < e2返回-1
	public int compare(Object e1,Object e2);
	
}
