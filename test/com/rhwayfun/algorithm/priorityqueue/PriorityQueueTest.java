package com.rhwayfun.algorithm.priorityqueue;

import org.junit.Before;
import org.junit.Test;

public class PriorityQueueTest {

	private PriorityQueue priorityQueue;
	private Heap heap;
	
	@Before
	public void setUp() throws Exception {
		heap = new Heap();
		priorityQueue = new PriorityQueue();
	}

	@Test
	public void testInsert() {
		System.out.println("********插入数据之前***********");
		for (int i = 0; i <= heap.size; i++) {
			 System.out.println(heap.values[i]);
		}
		priorityQueue.insert(13, heap);
		priorityQueue.insert(21, heap);
		priorityQueue.insert(16, heap);
		priorityQueue.insert(24, heap);
		priorityQueue.insert(31, heap);
		priorityQueue.insert(19, heap);
		priorityQueue.insert(68, heap);
		priorityQueue.insert(65, heap);
		priorityQueue.insert(26, heap);
		priorityQueue.insert(32, heap);
		
		priorityQueue.insert(14, heap);
		
		System.out.println("********插入数据之后***********");
		for (int i = 0; i <= heap.size; i++) {
			 System.out.println(heap.values[i]);
		}
	}

	@Test
	public void testDelete() {
		
		priorityQueue.insert(13, heap);
		priorityQueue.insert(14, heap);
		priorityQueue.insert(16, heap);
		priorityQueue.insert(19, heap);
		priorityQueue.insert(21, heap);
		priorityQueue.insert(19, heap);
		priorityQueue.insert(68, heap);
		priorityQueue.insert(65, heap);
		priorityQueue.insert(26, heap);
		priorityQueue.insert(32, heap);
		priorityQueue.insert(31, heap);
		
		System.out.println("********删除之前***********");
		for (int i = 0; i <= heap.size; i++) {
			 System.out.println(heap.values[i]);
		}
		
		priorityQueue.delete(heap);
		
		System.out.println("********删除之后***********");
		for (int i = 0; i < heap.size; i++) {
			 System.out.println(heap.values[i]);
		}
	}

}
