package com.rhwayfun.algorithm.linkedlist;

/**
 * 
 * <p>Title:List</p>
 * <p>Description:线性表接口</p>
 * @author rhwayfun
 * @date Aug 24, 2015 9:42:06 PM
 * @version 1.0
 */
public interface List {
	
	//获取集合中数据元素的大小
	public int getSize();
	
	//是否为空
	public boolean isEmpty();
	
	//判断是否包含一个元素
	public boolean contains(Object e);
	
	//在线性表的i位置插入元素e
	public boolean insert(int i,Object e) throws Exception;
	
	//将j插入到数据元素e之前
	public boolean insertBefore(Object j,Object e);
	
	//将j插入到数据元素e之后
	public boolean insertAfter(Object j, Object e);
	
	//删除第i位置的元素并返回
	public Object remove(int i) throws Exception;
	
	//删除第一个与元素e匹配的元素
	public boolean remove(Object e);
	
	//获取第i位置的元素
	public Object get(int i);
	
	//替换第i位置的元素为e
	public void replace(int i,Object e) throws Exception;
	
	//定位元素e的位置
	public int indexOf(Object e);
}
