package com.rhwayfun.algorithm.stack;

import com.rhwayfun.algorithm.linkedlist.STNode;

/**
 * 
 * <p>Title:StackLinkedList</p>
 * <p>Description:����ʵ�ֵ�ջ</p>
 * @author rhwayfun
 * @date Aug 28, 2015 4:38:03 PM
 * @version 1.0
 */
public class StackLinkedList implements Stack {

	//ջ��ÿ��Ԫ�صĽڵ�
	private STNode top;
	//ջ��Ԫ�صĸ���
	private int size;
	
	/**
	 * ��������ʵ�ֵ�ջ�У�������ĵ�һ���ڵ㵱��ջ��topָ��
	 * <p>Description:���췽�� </p>
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
			throw new Exception("ջΪ�գ���ȡʧ��");
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
			throw new Exception("ջΪ�գ���ȡʧ��");
		}
		Object obj = top.getData();
		top = top.getNext();
		size--;
		return obj;
	}

}
