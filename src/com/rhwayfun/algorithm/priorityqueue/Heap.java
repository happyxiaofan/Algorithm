package com.rhwayfun.algorithm.priorityqueue;

/**
 * 
 * <p>Title:Heap</p>
 * <p>Description:�����Ѵ洢���ȶ���</p>
 * @author rhwayfun
 * @date Aug 21, 2015 10:22:52 AM
 * @version 1.0
 */
public class Heap {


	//��ǰ�ѵĴ�С
	public int size;
	//ֵ
	public int[] values;
	//�ѵ�����
	public int capacity = 13;
	
	public Heap(){
		initArray();
	}

	//��ʼ������
	private void initArray() {
		size = 0;
		values = new int[capacity];
		for (int i = 0; i < values.length; i++) {
			values[i] = 0;
		}
	}
	
}
