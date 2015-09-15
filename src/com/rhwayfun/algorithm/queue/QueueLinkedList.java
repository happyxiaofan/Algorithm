package com.rhwayfun.algorithm.queue;

import com.rhwayfun.algorithm.linkedlist.STNode;

/**
 * 
 * <p>Title:QueueLinkedList</p>
 * <p>Description:链表实现的栈</p>
 * @author rhwayfun
 * @date Aug 28, 2015 7:10:46 PM
 * @version 1.0
 */
public class QueueLinkedList implements Queue {

	//链表的元素个数
	private int size;
	//队头
	private STNode front;
	//队尾
	private STNode rear;
	
	public QueueLinkedList(){
		size = 0;
		front = new STNode();
		rear = front;
	}
	
	public Object dequeue() throws Exception {
		if(getSize() < 1){
			throw new Exception("出队失败");
		}
		STNode p = front.getNext();
		front.setNext(p.getNext());
		size--;
		return p.getData();
	}

	public void enqueue(Object e) {
		STNode p = new STNode(e, null);
		rear.setNext(p);
		rear = p;
		size++;
	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public Object peek() throws Exception {
		if(getSize() < 1){
			throw new Exception("取栈顶元素失败");
		}
		return front.getNext().getData();
	}

}
