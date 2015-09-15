package com.rhwayfun.algorithm.queue;

/**
 * 
 * <p>Title:Queue</p>
 * <p>Description:队列接口</p>
 * @author rhwayfun
 * @date Aug 28, 2015 4:49:18 PM
 * @version 1.0
 */
public interface Queue {

	//返回队列元素的个数
	public int getSize();
	//判断队列是否为空
	public boolean isEmpty();
	//入队
	public void enqueue(Object e);
	//出队
	public Object dequeue() throws Exception;
	//取队头
	public Object peek() throws Exception;
	
}
