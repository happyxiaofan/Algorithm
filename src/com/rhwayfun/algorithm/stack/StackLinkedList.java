package com.rhwayfun.algorithm.stack;

import com.rhwayfun.algorithm.linkedlist.STNode;

/**
 * 
 * <p>Title:StackLinkedList</p>
 * <p>Description:链表实现的栈</p>
 * @author rhwayfun
 * @date Aug 28, 2015 4:38:03 PM
 * @version 1.0
 */
public class StackLinkedList implements Stack {

	//栈中每个元素的节点
	private STNode top;
	//栈中元素的个数
	private int size;
	
	/**
	 * 在用链表实现的栈中，把链表的第一个节点当做栈的top指针
	 * <p>Description:构造方法 </p>
	 */
	public StackLinkedList(){
		top = null;
		size = 0;
	}
	
	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public Object peek() throws Exception {
		if(size < 0){
			throw new Exception("栈为空，获取失败");
		}
		return top.getData();
	}

	public void push(Object e) {
		STNode p = new STNode(e, top);
		top = p;
		size++;
	}

	public Object top() throws Exception {
		if(size < 0){
			throw new Exception("栈为空，获取失败");
		}
		Object obj = top.getData();
		top = top.getNext();
		size--;
		return obj;
	}

}
