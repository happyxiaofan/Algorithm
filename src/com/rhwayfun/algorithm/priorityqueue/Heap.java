package com.rhwayfun.algorithm.priorityqueue;

/**
 * 
 * <p>Title:Heap</p>
 * <p>Description:构建堆存储优先队列</p>
 * @author rhwayfun
 * @date Aug 21, 2015 10:22:52 AM
 * @version 1.0
 */
public class Heap {


	//当前堆的大小
	public int size;
	//值
	public int[] values;
	//堆的容量
	public int capacity = 13;
	
	public Heap(){
		initArray();
	}

	//初始化数组
	private void initArray() {
		size = 0;
		values = new int[capacity];
		for (int i = 0; i < values.length; i++) {
			values[i] = 0;
		}
	}
	
}
