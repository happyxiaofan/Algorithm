package com.rhwayfun.algorithm.linkedlist;

public class STLNode {

	//父节点
	private STLNode pare;
	//左孩子节点
	private STLNode lChild;
	//右孩子节点
	private STLNode rChild;
	//数据域
	private int value;
	
	public STLNode(int value){
		this();
		this.value = value;
	}
	
	public STLNode(){
		this.lChild = null;
		this.pare = null;
		this.rChild = null;
	}
	/**
	 * @return the pare
	 */
	public STLNode getPare() {
		return pare;
	}
	/**
	 * @param pare the pare to set
	 */
	public void setPare(STLNode pare) {
		this.pare = pare;
	}
	/**
	 * @return the lChild
	 */
	public STLNode getlChild() {
		return lChild;
	}
	/**
	 * @param lChild the lChild to set
	 */
	public void setlChild(STLNode lChild) {
		this.lChild = lChild;
	}
	/**
	 * @return the rChild
	 */
	public STLNode getrChild() {
		return rChild;
	}
	/**
	 * @param rChild the rChild to set
	 */
	public void setrChild(STLNode rChild) {
		this.rChild = rChild;
	}
	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}
	
	
	public boolean hasLChild() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean hasRChild() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean isRCild() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean isLCild() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
