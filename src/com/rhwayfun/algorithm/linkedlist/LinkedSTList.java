package com.rhwayfun.algorithm.linkedlist;

public class LinkedSTList implements List {

	//单链表数据元素比较策略
	private Strategy strategy;
	//头结点
	private STNode head;
	//单链表中元素的个数
	private int size;
	
	public LinkedSTList(){
		this(new DefaultStrategy());
	}
	
	public LinkedSTList(Strategy strategy){
		this.strategy = strategy;
		head = new STNode();
		size = 0;
	}
	
	//判断链表中是否包含元素e
	public boolean contains(Object e) {
		int i = indexOf(e);
		if(i != -1){
			return true;
		}
		return false;
	}

	//获取链表中第i位置的元素
	public Object get(int i) {
		STNode p = head.getNext();
		int index = 1;
		while(i != index){
			p = p.getNext();
		}
		return p;
	}

	//获取单链表中的元素个数
	public int getSize() {
		return size;
	}

	//定位元素e在链表中的下标
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

	//在单链表的第i位置插入元素e
	public boolean insert(int i, Object e) throws Exception {
		STNode s = new STNode(e,null);
		if(i <= 0 || i >= size){
			throw new OutOfBoundException("下标越界，插入失败");
		}
		STNode p = getPre(i);
		STNode self = (STNode) get(i);
		p.setNext(s);
		s.setNext(self);
		size++;
		return true;
	}

	//获取第i位置的前一个节点
	private STNode getPre(int i) throws OutOfBoundException {
		if(i < 0 || i >= size){
			throw new OutOfBoundException("下标越界，插入失败");
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

	//获取元素e的前一个元素节点
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
	
	//在元素j的后面插入元素e
	public boolean insertAfter(Object j, Object e) {
		//判断j是否在单链表中
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

	//在元素j的前面插入元素e
	public boolean insertBefore(Object j, Object e) {
		//判断j是否在单链表中
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

	//判断单链表中是否有元素
	public boolean isEmpty() {
		return size == 0;
	}

	//删除第i位置的元素并返回
	public Object remove(int i) throws Exception {
		if(i < 0 || i >=size){
			throw new OutOfBoundException("下标越界，删除失败");
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

	//用元素e替换单链表上第i位置的元素
	public void replace(int i, Object e) throws Exception {
		if(i <= 0 || i >=size){
			throw new OutOfBoundException("下标越界，替换失败");
		}
		STNode s = (STNode) get(i);
		s.setData(e);
	}

}
