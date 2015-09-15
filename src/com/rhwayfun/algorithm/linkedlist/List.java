package com.rhwayfun.algorithm.linkedlist;

/**
 * 
 * <p>Title:List</p>
 * <p>Description:���Ա�ӿ�</p>
 * @author rhwayfun
 * @date Aug 24, 2015 9:42:06 PM
 * @version 1.0
 */
public interface List {
	
	//��ȡ����������Ԫ�صĴ�С
	public int getSize();
	
	//�Ƿ�Ϊ��
	public boolean isEmpty();
	
	//�ж��Ƿ����һ��Ԫ��
	public boolean contains(Object e);
	
	//�����Ա��iλ�ò���Ԫ��e
	public boolean insert(int i,Object e) throws Exception;
	
	//��j���뵽����Ԫ��e֮ǰ
	public boolean insertBefore(Object j,Object e);
	
	//��j���뵽����Ԫ��e֮��
	public boolean insertAfter(Object j, Object e);
	
	//ɾ����iλ�õ�Ԫ�ز�����
	public Object remove(int i) throws Exception;
	
	//ɾ����һ����Ԫ��eƥ���Ԫ��
	public boolean remove(Object e);
	
	//��ȡ��iλ�õ�Ԫ��
	public Object get(int i);
	
	//�滻��iλ�õ�Ԫ��Ϊe
	public void replace(int i,Object e) throws Exception;
	
	//��λԪ��e��λ��
	public int indexOf(Object e);
}
