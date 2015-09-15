package com.rhwayfun.algorithm.linkedlist;

/**
 * 
 * <p>Title:DTNode</p>
 * <p>Description:双链表</p>
 * @author rhwayfun
 * @date Aug 27, 2015 2:47:15 PM
 * @version 1.0
 */
public class DTNode implements SNode {
	
	//数据域
	private Object data;
	//前一个节点的引用
	private DTNode pre;
	//下一个节点的引用
	private DTNode next;

	public DTNode(){
		this(null,null,null);
	}
	
	public DTNode(Object data, DTNode pre, DTNode next) {
		this.data = data;
		this.pre = pre;
		this.next = next;
	}
	
	/**
	 * @return the pre
	 */
	public DTNode getPre() {
		return pre;
	}

	/**
	 * @param pre the pre to set
	 */
	public void setPre(DTNode pre) {
		this.pre = pre;
	}

	/**
	 * @return the next
	 */
	public DTNode getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(DTNode next) {
		this.next = next;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
