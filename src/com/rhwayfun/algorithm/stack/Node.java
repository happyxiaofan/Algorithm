package com.rhwayfun.algorithm.stack;

public class Node {

	//指针域
	public Node next;
	//节点数据域
	public int key;
	//节点名称
	private String nodeName;
	
	public Node(){
		
	}

	public Node(int key,String nodeName){
		this.key = key;
		this.nodeName = nodeName;
	}
	/**
	 * @return the next
	 */
	public Node getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(Node next) {
		this.next = next;
	}

	/**
	 * @return the key
	 */
	public int getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(int key) {
		this.key = key;
	}

	/**
	 * @return the nodeName
	 */
	public String getNodeName() {
		return nodeName;
	}

	/**
	 * @param nodeName the nodeName to set
	 */
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public String toString(){
		if(this.next!=null)
			return "[node=" + this.nodeName + ",key=" + key + ",next=" + this.next.nodeName + "]";
		return "[node=" + this.nodeName + ",key=" + key + ",next=" + null + "]";
	}
}
