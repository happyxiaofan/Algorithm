package com.rhwayfun.algorithm.queue;

/**
 * 
 * <p>Description:����ʵ�ֵĶ���</p>
 * @author rhwayfun
 * @date Aug 28, 2015 6:56:14 PM
 * @version 1.0
 */
public class QueueArray implements Queue {

	//��������
	private int capacity = 8;
	//������Ԫ�صĸ���
	private int size;
	//����
	private Object[] elements;
	//��ͷ
	private int front;
	//��β
	private int rear;
	
	public QueueArray(){
		elements = new Object[capacity];
		size = 0;
		front = rear;
	}
	
	
	public Object dequeue() throws Exception {
		if(getSize() < 1){
			throw new Exception("����ʧ��");
		}
		Object obj = elements[front];
		elements[front] = null;
		front = (front+1)%capacity;
		size--;
		return obj;
	}

	public void enqueue(Object e) {
		//��rear����һ��λ����front��ʱ�������
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
		//�������ö�ͷ�Ͷ�β
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
			throw new Exception("ȡջ��ʧ��");
		}
		return elements[front];
	}

}
