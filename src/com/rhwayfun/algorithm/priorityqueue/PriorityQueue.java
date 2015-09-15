package com.rhwayfun.algorithm.priorityqueue;

/**
 * 
 * <p>Title:PriorityQueue</p>
 * <p>Description:���ȶ��е�javaʵ��</p>
 * @author rhwayfun
 * @date Aug 21, 2015 10:33:21 AM
 * @version 1.0
 */
public class PriorityQueue {
	
	//�����޶���������Ԫ��
	public void insert(int value,Heap heap){
		int i = 0;
		//�жϵ�ǰ���Ƿ�����
		if(isFull(heap)){
			System.out.println("������������ʧ�ܣ�");
		}
		/* �����ǲ���һ��Ԫ�أ�����������ʵ�ֵģ����鳤�ȹ̶���ÿ�β���һ��Ԫ��ʱ���ѶѵĴ�С����1
		 * ���ݶѵ����ʣ�����һ�������ĸ��ڵ㶼���亢�ӽڵ��ֵС����Ҫ�����ֵ���丸�ڵ��ֵ�Ƚ�
		 * ������Ԫ�ص����ж��ǴӸ��ڵ㿪ʼ���δ���������ӵ������У����Զ��ڶ�������һ���ڵ�i
		 * �丸�ڵ�Ϊ(i/2)�����ӽڵ�Ϊ2i���Һ���Ϊ2i+1
		 */
		for(i = ++heap.size; heap.values[i/2] > value; i /= 2){
			heap.values[i] = heap.values[i/2];
		}
		//ѭ������˵��value�ҵ�����Ҫ�����λ�ã�����i������ֻ��Ҫ��iλ���ϵ�ֵ��ΪҪ�����ֵ��С����
		heap.values[i] = value;
	}

	public int delete(Heap heap){
		/* ���ݶѵĶ���Ҫɾ��һ��Ԫ��ʵ���Ͼ���ɾ���ѵĸ��������Ǹ��ڵ㣬���Ը��ڵ�������µĽڵ����
		 * ˼·���Ѷѵ����һ���ڵ�ȡ����������ɾ��������Ȼ��Ӹ��ڵ�λ�ÿ�ʼ������ÿ�α�����Ҫ��������
		 * ���ӽڵ���ѡȡ��С��Ԫ�ط����丸�ڵ��λ�ã���Ϊ���նѵ����ʸ��ڵ��ֵ��ȻС�����ӽڵ��ֵ����
		 * ��������ֹ���������ӽڵ��λ��С�ڶѵĴ�С������������˵�������Ѿ��ҵ�Ҫ�Ѷ������һ��Ԫ�ط���
		 * ��λ�á�Ȼ������һ��Ԫ�ص�ֵ������λ�õ�ֵ�Ϳ����ˡ�
		 */
		int i,child = 0;
		int lastElement,minElement;
		//��Ϊ��
		if(heap.size == 0){
			System.out.println("��Ϊ�գ�ɾ��ʧ�ܣ�");
		}
		//�����Ϊ�գ����õ��ѵĸ��ڵ�����һ���ڵ�
		minElement = heap.values[1];//�ѵĸ��ڵ㣬Ҳ������С�Ľڵ�
		lastElement = heap.values[heap.size];//�ѵ����һ���ڵ�
		
		//���ѭ������Ϊ���ҵ����һ��Ԫ�ز����λ��
		for(i = 1; 2*i < heap.size; i = child){
			child = 2*i;
			//�ҵ���ǰ�ڵ����Һ��ӽڵ��н�С�Ľڵ�
			if(child != heap.size && heap.values[child + 1] < heap.values[child]){
				//�����ǰ�ڵ�����Ӵ����Һ������С�ĺ��ӽڵ�����Һ�����
				child++;
			}
			//������һ��
			if(lastElement > heap.values[child]){
				heap.values[i] = heap.values[child];
			}else{
				break;
			}
		}
		
		//ѭ��������λ�����ҵ�����i
		heap.values[i] = lastElement;
		return minElement;
	}
	private boolean isFull(Heap heap) {
		if(heap.size < heap.capacity)
			return false;
		return true;
	}
}
