package com.rhwayfun.algorithm.linkedlist;

/**
 * 
 * <p>Title:ListArray</p>
 * <p>Description:ʹ������ʵ�����Ա�</p>
 * @author rhwayfun
 * @date Aug 27, 2015 11:02:33 AM
 * @version 1.0
 */
public class ListArray implements List {

	//��������
	private int len = 8;
	//������Ԫ�صĸ���
	private int size;
	//����֮��Ԫ�صıȽϲ���
	private Strategy strategy;
	//����װ������Ԫ�ص�����
	private Object[] elements;
	
	public ListArray(){
		this(new DefaultStrategy());
	}
	
	public ListArray(Strategy strategy) {
		this.strategy = strategy;
		size = 0;
		elements = new Object[len];
	}

	//�ж��������Ƿ����Ԫ��e
	public boolean contains(Object e) {
		boolean isContains = false;
		for (int i = 0; i < elements.length; i++) {
			if(strategy.equal(elements[i], e)){
				isContains = true;
			}
		}
		return isContains;
	}

	//��ȡ��iλ����Ԫ��
	public Object get(int i) {
		if(i < 0 || i > size){
			System.out.println("�±�Խ�磬��ȡʧ�ܣ�");
			return null;
		}
		return elements[i];
	}

	//��ȡ����Ԫ�صĸ���
	public int getSize() {
		return size;
	}

	//�ڵ�i��λ�ò�������Ԫ��e
	public boolean insert(int i, Object e) throws OutOfBoundException {
		if(i < 0 || i > size){
			System.out.println("�±�Խ�磬����ʧ�ܣ�");
			return false;
		}else{
			//���������Ԫ�صĴ�С��������������������������������
			if(size >= elements.length){
				expandSpace();
			}
			//�Ѵӵ�iλ�õ�Ԫ�ؿ�ʼ�����һ��Ԫ�أ��������ƶ�һ��λ��
			for(int j = size - 1; j > i; j--){
				elements[j] = elements[j-1];
			}
			//�ѵ�iλ�õ�ֵ��Ϊe
			elements[i] = e;
			//������Ԫ�صĸ�ʽ����1
			size++;
			return true;
		}
	}

	//��̬��չ��������
	private void expandSpace() {
		Object[] newArray = new Object[elements.length*2];
		for (int i = 0; i < elements.length; i++) {
			newArray[i] = elements[i];
		}
		elements = newArray;
	}

	//��Ԫ��j�ĺ������Ԫ��e
	public boolean insertAfter(Object j, Object e) {
		//��λԪ��j��λ��
		int i = indexOf(j);
		try {
			if(i != -1){
				insert(i + 1, e);
				return true;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return false;
	}

	//��Ԫ��j��ǰ�����Ԫ��e
	public boolean insertBefore(Object j, Object e) {
		//��λԪ��j��λ��
		int i = indexOf(j);
		try {
			if(i != -1){
				insert(i, e);
				return true;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return false;
	}

	//�ж��������Ƿ�Ԫ��
	public boolean isEmpty() {
		return size == 0;
	}

	//�Ƴ������е�iλ�õ�Ԫ�ز�����
	public Object remove(int i) throws OutOfBoundException {
		Object e = get(i);
		if(i < 0 || i > size){
			System.out.println("�±�Խ�磬ɾ��ʧ�ܣ�");
			return null;
		}
		for (int j = i; j < size - 1; j++) {
			elements[j] = elements[j + 1];
		}
		//�������Ԫ�ظ�������1
		elements[--size] = null;
		return e;
	}

	//ɾ��Ԫ��e�����ж��Ƿ�ɾ���ɹ�
	public boolean remove(Object e) {
		boolean isRemove = false;
		//�ж��������Ƿ����Ԫ��e
		if(contains(e)){
			//��ȡ��Ԫ�ص��±�
			int i = indexOf(e);
			for (int j = i; j < size - 1; j++) {
				elements[j] = elements[j + 1];
			}
			isRemove = true;
		}
		return isRemove;
	}

	//�������е�iλ�õ�Ԫ���滻Ϊe
	public void replace(int i, Object e) throws OutOfBoundException {
		if(i < 0 || i > size){
			System.out.println("�滻ʧ��");
			return;
		}
		elements[i] = e;
	}

	//��λԪ��e��λ��
	public int indexOf(Object e) {
		for (int i = 0; i < size; i++) {
			if(strategy.equal(elements[i], e)){
				return i;
			}
		}
		return -1;
	}

}
