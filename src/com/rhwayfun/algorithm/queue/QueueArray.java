package com.rhwayfun.algorithm.queue;

/**
 * 
 * <p>Description:数组实现的队列</p>
 * @author rhwayfun
 * @date Aug 28, 2015 6:56:14 PM
 * @version 1.0
 */
public class QueueArray implements Queue {

	//数组容量
	private int capacity = 8;
	//数组中元素的个数
	private int size;
	//数组
	private Object[] elements;
	//队头
	private int front;
	//队尾
	private int rear;
	
	public QueueArray(){
		elements = new Object[capacity];
		size = 0;
		front = rear;
	}
	
	
	public Object dequeue() throws Exception {
		if(getSize() < 1){
			throw new Exception("出队失败");
		}
		Object obj = elements[front];
		elements[front] = null;
		front = (front+1)%capacity;
		size--;
		return obj;
	}

	public void enqueue(Object e) {
		//当rear的下一个位置是front的时候队列满
		if(getSize() == capacity - 1){
			expandSpace();
		}
		elements[rear] = e;
		rear = (rear+1)%capacity;
		size++;
	}

	private void expandSpace() {
		Object[] a = new Object[elements.length*2];
		int i = front;
		int j = 0;
		while (i!=rear){
			a[j++] = elements[i];
			i = (i+1)%capacity;
		}
		elements = a;
		capacity = elements.length;
		//重新设置队头和队尾
		front = 0;
		rear = j;
	}


	public int getSize() {
		return (rear-front+capacity)%capacity;
	}

	public boolean isEmpty() {
		return front == rear;
	}

	public Object peek() throws Exception {
		if(getSize() < 1){
			throw new Exception("取栈顶失败");
		}
		return elements[front];
	}

}
