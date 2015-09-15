package com.rhwayfun.algorithm.search;

import com.rhwayfun.algorithm.linkedlist.DefaultStrategy;
import com.rhwayfun.algorithm.linkedlist.STLNode;
import com.rhwayfun.algorithm.linkedlist.Strategy;

/**
 * 
 * <p>Title:BinSearch</p>
 * <p>Description:折半查找</p>
 * @author rhwayfun
 * @date Sep 2, 2015 4:04:11 PM
 * @version 1.0
 */
public class BinSearch {

	private Strategy dStrategy;
	private STLNode root;
	
	public BinSearch(){
		this.dStrategy = new DefaultStrategy();
	}
	
	//使用非递归的方式查找元素k
	public int binSearch(int[] arr,int k){
		int low = 0;
		int high = arr.length - 1;
		int mid = (low + high)/2;
		while(low <= high){
			if(dStrategy.equal(arr[mid], k)){
				return mid;
			}else if(dStrategy.compare(arr[mid], k) > 0){
				high = mid - 1;
			}else if(dStrategy.compare(arr[mid], k) < 0){
				low = mid + 1;
			}
		}
		return -1;
	}
	
	//使用递归的方式查找元素k
	public int binSeachWithRecursion(int[] arr,int low,int high,int k){
		int mid = (low + high)/2;
		if(dStrategy.equal(arr[mid], k)){
			return mid;
		}else if(dStrategy.compare(arr[mid], k) > 0){
			binSeachWithRecursion(arr, low, mid - 1, k);
		}else if(dStrategy.compare(arr[mid], k) < 0){
			binSeachWithRecursion(arr, mid + 1, high, k);
		}
		return -1;
	}
	
	//使用二叉查找树的非递归方式查找元素k
	public STLNode binSearch(STLNode node,int k){
		while(node != null){
			switch(dStrategy.compare(node.getValue(), k)){
			case 0://相等
				return node;
			case -1://小于k
				node = node.getrChild();
				break;
			default:
				node = node.getlChild();
			}
		}
		return null;
	}
	
	//使用二叉查找树的递归方式查找元素k
	public STLNode binSearchRe(STLNode node ,int k){
		while(node != null){
			switch(dStrategy.compare(node.getValue(), k)){
			case 0:
				return node;
			case -1:
				binSearchRe(node.getrChild(), k);
			default:
				binSearchRe(node.getlChild(), k);
			}
		}
		return null;
	}
	
	//获取最小元素节点
	public STLNode min(STLNode node){
		if(node != null){
			while(node.hasLChild()){
				node = node.getlChild();
			}
			return node;
		}
		return null;
	}
	
	//获取最大元素节点
	public STLNode max(STLNode node){
		if(node != null){
			while(node.hasRChild()){
				node = node.getrChild();
			}
			return node;
		}
		return null;
	}
	
	//获得前驱节点
	public STLNode getPredecessor(STLNode node){
		if(node.hasLChild()){
			return max(node.getlChild());
		}
		while(node.isLCild()){
			node = node.getPare();
		}
		return node.getPare();
	}
	
	//获得后继节点
	public STLNode getSuccessor(STLNode node){
		if(node.hasRChild()){
			return min(node.getrChild());
		}
		while(node.isRCild()){
			node = node.getPare();
		}
		return node.getPare();
	}
	
	//往二叉查找树中插入新的节点
	public void insert(int k){
		//创建一个节点指向每次寻找插入位置时的节点
		STLNode cur = root;
		//创建一个节点指向当前节点cur的父节点
		STLNode p = null;
		while(cur != null){
			p = cur;
			if(dStrategy.compare(k, cur.getValue()) < 0){
				cur = cur.getlChild();
			}else{
				cur = cur.getrChild();
			}
		}
		//执行到这里说明p已经指向了待插入节点位置的父节点
		if(p != null){
			if(dStrategy.compare(k, p.getValue()) < 0){//大于k
				p.setlChild(new STLNode(k));
			}else if(dStrategy.compare(k, p.getValue()) > 0){//小于k
				p.setrChild(new STLNode(k));
			}else{//相等
				p.setrChild(new STLNode(k));
			}
		}
	}
}
