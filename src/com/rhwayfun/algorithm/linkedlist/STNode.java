package com.rhwayfun.algorithm.linkedlist;

public class STNode implements SNode {
	
	//数据域
	private Object data;
	//节点域
	private STNode next;
	
	public STNode(){
		this(null,null);
	}
	
	public STNode(Object data,STNode next){
		this.data = data;
		this.next = next;
	}

	/**
	 * @return the next
	 */
	public STNode getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(STNode next) {
		this.next = next;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	
}
