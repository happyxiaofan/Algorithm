package com.rhwayfun.algorithm.linkedlist;

public class LinkedSTList implements List {

	//����������Ԫ�رȽϲ���
	private Strategy strategy;
	//ͷ���
	private STNode head;
	//��������Ԫ�صĸ���
	private int size;
	
	public LinkedSTList(){
		this(new DefaultStrategy());
	}
	
	public LinkedSTList(Strategy strategy){
		this.strategy = strategy;
		head = new STNode();
		size = 0;
	}
	
	//�ж��������Ƿ����Ԫ��e
	public boolean contains(Object e) {
		int i = indexOf(e);
		if(i != -1){
			return true;
		}
		return false;
	}

	//��ȡ�����е�iλ�õ�Ԫ��
	public Object get(int i) {
		STNode p = head.getNext();
		int index = 1;
		while(i != index){
			p = p.getNext();
		}
		return p;
	}

	//��ȡ�������е�Ԫ�ظ���
	public int getSize() {
		return size;
	}

	//��λԪ��e�������е��±�
	public int indexOf(Object e) {
		STNode p = head.getNext();
		int index = 0;
		while(p != null){
			if(strategy.equal(p.getData(), e)){
				return index;
			}else{
				index++;
				p = p.getNext();
			}
		}
		return -1;
	}

	//�ڵ�����ĵ�iλ�ò���Ԫ��e
	public boolean insert(int i, Object e) throws Exception {
		STNode s = new STNode(e,null);
		if(i <= 0 || i >= size){
			throw new OutOfBoundException("�±�Խ�磬����ʧ��");
		}
		STNode p = getPre(i);
		STNode self = (STNode) get(i);
		p.setNext(s);
		s.setNext(self);
		size++;
		return true;
	}

	//��ȡ��iλ�õ�ǰһ���ڵ�
	private STNode getPre(int i) throws OutOfBoundException {
		if(i < 0 || i >= size){
			throw new OutOfBoundException("�±�Խ�磬����ʧ��");
		}
		/*if(i == 0){
			return head;
		}else{
			STNode p = head.getNext();
			int index = 1;
			while(i != index){
				p = p.getNext();
				index++;
			}
			return p;
		}*/
		STNode p = head;
		for(;i > 0; i--){
			p = p.getNext();
		}
		return p;
	}

	//��ȡԪ��e��ǰһ��Ԫ�ؽڵ�
	private STNode getPre(Object e) {
		STNode p = head;
		while(p != null){
			if(strategy.equal(p.getNext().getData(), e)){
				return p;
			}else{
				p = p.getNext();
			}
		}
		return null;
	}
	
	//��Ԫ��j�ĺ������Ԫ��e
	public boolean insertAfter(Object j, Object e) {
		//�ж�j�Ƿ��ڵ�������
		if(contains(j)){
			STNode s = new STNode(e,null);
			int i = indexOf(j);
			STNode self = (STNode) get(i);
			self.setNext(s);
			s.setNext(self.getNext());
			size++;
			return true;
		}
		return false;
	}

	//��Ԫ��j��ǰ�����Ԫ��e
	public boolean insertBefore(Object j, Object e) {
		//�ж�j�Ƿ��ڵ�������
		if(contains(j)){
			STNode s = new STNode(e,null);
			STNode p = (STNode) getPre(j);
			p.setNext(s);
			s.setNext(p.getNext());
			size++;
			return true;
		}
		return false;
	}

	//�жϵ��������Ƿ���Ԫ��
	public boolean isEmpty() {
		return size == 0;
	}

	//ɾ����iλ�õ�Ԫ�ز�����
	public Object remove(int i) throws Exception {
		if(i < 0 || i >=size){
			throw new OutOfBoundException("�±�Խ�磬ɾ��ʧ��");
		}
		/*STNode s = (STNode) get(i);
		if(i == 0){
			head = head.getNext();
			size--;
		}else if(i == size-1){
			STNode p = getPre(i);
			p.setNext(p.getNext().getNext());
			size--;
		}else{
			STNode q = getPre(i);
			q.setNext(s.getNext());
			size--;
		}*/
		STNode p = getPre(i);
		Object obj = p.getNext().getData();
		p.setNext(p.getNext().getNext());
		size--;
		return obj;
	}

	public boolean remove(Object e) {
		if(contains(e)){
			STNode s = getPre(e);
			s.setNext(s.getNext().getNext());
			size--;
			return true;
		}
		return false;
	}

	//��Ԫ��e�滻�������ϵ�iλ�õ�Ԫ��
	public void replace(int i, Object e) throws Exception {
		if(i <= 0 || i >=size){
			throw new OutOfBoundException("�±�Խ�磬�滻ʧ��");
		}
		STNode s = (STNode) get(i);
		s.setData(e);
	}

}
