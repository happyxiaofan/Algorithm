package com.rhwayfun.algorithm.stack;

public class QueueAction {

	private int size;

	//���
	public void enqueue(int value,Queue queue){
		//�ж��Ƿ�rear�Ƿ��ڶ�β
		if(!isFull(queue)){
			size = queue.getSize();
			//��value��ֵ��������
			queue.getQueueArray()[queue.getRear()] = value;
			size++;
			queue.setSize(size);
			queue.setRear(size);
			System.out.println(value + "��ӳɹ���");
		}else{
			System.out.println("��������" + value + "���ʧ�ܣ�");
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
