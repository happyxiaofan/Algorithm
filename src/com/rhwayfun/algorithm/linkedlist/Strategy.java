package com.rhwayfun.algorithm.linkedlist;

/**
 * 
 * <p>Title:Strategy</p>
 * <p>Description:���Ա�Ԫ�صıȽϽӿ�</p>
 * @author rhwayfun
 * @date Aug 24, 2015 9:42:26 PM
 * @version 1.0
 */
public interface Strategy {

	//�Ƚ�����Ԫ���Ƿ����
	public boolean equal(Object e1,Object e2);
	//�Ƚ�����Ԫ�صĴ�С
	//���e1 > e2 ����1�������ȷ���0�����e1 < e2����-1
	public int compare(Object e1,Object e2);
	
}
