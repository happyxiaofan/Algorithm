package com.rhwayfun.algorithm.stack;

/**
 * 
 * <p>Title:Stack</p>
 * <p>Description:栈接口</p>
 * @author rhwayfun
 * @date Aug 28, 2015 4:11:46 PM
 * @version 1.0
 */
public interface Stack {

	//是否为空栈
	public boolean isEmpty();
	//获取栈的元素个数
	public int getSize();
	//进栈
	public void push(Object e);
	//出栈并返回
	public Object top() throws Exception;
	//取栈顶元素
	public Object peek() throws Exception;
}
