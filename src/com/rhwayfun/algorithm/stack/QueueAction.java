package com.rhwayfun.algorithm.stack;

public class QueueAction {

	private int size;

	//入队
	public void enqueue(int value,Queue queue){
		//判断是否rear是否在队尾
		if(!isFull(queue)){
			size = queue.getSize();
			//把value的值赋给数组
			queue.getQueueArray()[queue.getRear()] = value;
			size++;
			queue.setSize(size);
			queue.setRear(size);
			System.out.println(value + "入队成功！");
		}else{
			System.out.println("队列已满" + value + "入队失败！");
		}
	}

	private boolean isFull(Queue queue){
		if(queue.getRear()== queue.getCapacity()){
			return true;
		}
		return false;
	}
	
	public boolean isRear(int value,Queue queue) {
		int[] queueItems = queue.getQueueArray();
		if(value == queueItems[queue.getRear()])
			return true;
		return false;
	}

	public void init(Queue queue) {
		queue.setSize(0);
		queue.setFront(0);
		queue.setRear(0);
	}
}
