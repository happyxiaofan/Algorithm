package com.rhwayfun.algorithm.search;

import com.rhwayfun.algorithm.linkedlist.DefaultStrategy;
import com.rhwayfun.algorithm.linkedlist.STLNode;
import com.rhwayfun.algorithm.linkedlist.Strategy;

/**
 * 
 * <p>Title:BinSearch</p>
 * <p>Description:�۰����</p>
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
	
	//ʹ�÷ǵݹ�ķ�ʽ����Ԫ��k
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
	
	//ʹ�õݹ�ķ�ʽ����Ԫ��k
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
	
	//ʹ�ö���������ķǵݹ鷽ʽ����Ԫ��k
	public STLNode binSearch(STLNode node,int k){
		while(node != null){
			switch(dStrategy.compare(node.getValue(), k)){
			case 0://���
				return node;
			case -1://С��k
				node = node.getrChild();
				break;
			default:
				node = node.getlChild();
			}
		}
		return null;
	}
	
	//ʹ�ö���������ĵݹ鷽ʽ����Ԫ��k
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
	
	//��ȡ��СԪ�ؽڵ�
	public STLNode min(STLNode node){
		if(node != null){
			while(node.hasLChild()){
				node = node.getlChild();
			}
			return node;
		}
		return null;
	}
	
	//��ȡ���Ԫ�ؽڵ�
	public STLNode max(STLNode node){
		if(node != null){
			while(node.hasRChild()){
				node = node.getrChild();
			}
			return node;
		}
		return null;
	}
	
	//���ǰ���ڵ�
	public STLNode getPredecessor(STLNode node){
		if(node.hasLChild()){
			return max(node.getlChild());
		}
		while(node.isLCild()){
			node = node.getPare();
		}
		return node.getPare();
	}
	
	//��ú�̽ڵ�
	public STLNode getSuccessor(STLNode node){
		if(node.hasRChild()){
			return min(node.getrChild());
		}
		while(node.isRCild()){
			node = node.getPare();
		}
		return node.getPare();
	}
	
	//������������в����µĽڵ�
	public void insert(int k){
		//����һ���ڵ�ָ��ÿ��Ѱ�Ҳ���λ��ʱ�Ľڵ�
		STLNode cur = root;
		//����һ���ڵ�ָ��ǰ�ڵ�cur�ĸ��ڵ�
		STLNode p = null;
		while(cur != null){
			p = cur;
			if(dStrategy.compare(k, cur.getValue()) < 0){
				cur = cur.getlChild();
			}else{
				cur = cur.getrChild();
			}
		}
		//ִ�е�����˵��p�Ѿ�ָ���˴�����ڵ�λ�õĸ��ڵ�
		if(p != null){
			if(dStrategy.compare(k, p.getValue()) < 0){//����k
				p.setlChild(new STLNode(k));
			}else if(dStrategy.compare(k, p.getValue()) > 0){//С��k
				p.setrChild(new STLNode(k));
			}else{//���
				p.setrChild(new STLNode(k));
			}
		}
	}
}
