package com.rhwayfun.algorithm.stack;

/**
 * 
 * <p>Title:StackArray</p>
 * <p>Description:����ʵ��ջ</p>
 * @author rhwayfun
 * @date Aug 28, 2015 4:16:04 PM
 * @version 1.0
 */
public class StackArray implements Stack {

	//ջ������
	private int LEN = 8;
	//ջ��Ԫ��
	private int size;
	//ջ��ָ��
	private int top;
	//����
	Object[] elements;
	
	public StackArray(){
		elements = new Object[LEN];
		top = -1;
		size = 0;
	}
	
	public int getSize() {
		return top+1;
	}

	public boolean isEmpty() {
		return top < 0;
	}

	public Object peek() throws Exception {
		if(top < 0){
			throw new Exception("ȡջ��Ԫ��ʧ��");
		}
		return elements[top];
	}

	public void push(Object e) {
		if(getSize() < LEN){
			elements[++top] = e;
		}else{
			expandSpace();
		}
	}

	private void expandSpace() {
		Object[] a = new Object[elements.length*2];
		for (int i = 0; i < elements.length; i++) {
			a[i] = elements[i];
		}
		elements = a;
	}

	public Object top() throws Exception {
		Object obj = elements[top];
		elements[top--] = null;
		return obj;
	}

}
