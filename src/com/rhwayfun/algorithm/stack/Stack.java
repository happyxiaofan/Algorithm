package com.rhwayfun.algorithm.stack;

/**
 * 
 * <p>Title:Stack</p>
 * <p>Description:ջ�ӿ�</p>
 * @author rhwayfun
 * @date Aug 28, 2015 4:11:46 PM
 * @version 1.0
 */
public interface Stack {

	//�Ƿ�Ϊ��ջ
	public boolean isEmpty();
	//��ȡջ��Ԫ�ظ���
	public int getSize();
	//��ջ
	public void push(Object e);
	//��ջ������
	public Object top() throws Exception;
	//ȡջ��Ԫ��
	public Object peek() throws Exception;
}
