package com.rhwayfun.algorithm.stack;

/**
 * 
 * <p>Title:Queue</p>
 * <p>Description:队列的数组实现</p>
 * @author rhwayfun
 * @date Aug 17, 2015 2:21:40 PM
 * @version 1.0
 */
public class Queue {

	//队列容量
	private int capacity;
	//队列数组
	private int[] queueArray;
	//队列长度
	private int size;
	//队列头
	private int front;
	//队列尾
	private int rear;
	
	public Queue(int capacity){
		setCapacity(capacity);
		queueArray = new int[capacity];
	}
	
	/**
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}
	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	/**
	 * @return the queueArray
	 */
	public int[] getQueueArray() {
		return queueArray;
	}
	/**
	 * @param queueArray the queueArray to set
	 */
	public void setQueueArray(int[] queueArray) {
		this.queueArray = queueArray;
	}
	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}
	/**
	 * @return the front
	 */
	public int getFront() {
		return front;
	}
	/**
	 * @param front the front to set
	 */
	public void setFront(int front) {
		this.front = front;
	}
	/**
	 * @return the rear
	 */
	public int getRear() {
		return rear;
	}
	/**
	 * @param rear the rear to set
	 */
	public void setRear(int rear) {
		this.rear = rear;
	}
	
	
}
