package com.rhwayfun.algorithm.queue;

/**
 * 
 * <p>Title:Queue</p>
 * <p>Description:���нӿ�</p>
 * @author rhwayfun
 * @date Aug 28, 2015 4:49:18 PM
 * @version 1.0
 */
public interface Queue {

	//���ض���Ԫ�صĸ���
	public int getSize();
	//�ж϶����Ƿ�Ϊ��
	public boolean isEmpty();
	//���
	public void enqueue(Object e);
	//����
	public Object dequeue() throws Exception;
	//ȡ��ͷ
	public Object peek() throws Exception;
	
}
