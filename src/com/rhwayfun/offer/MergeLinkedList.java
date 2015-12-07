package com.rhwayfun.offer;

public class MergeLinkedList {
	
	public static class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public ListNode Merge(ListNode list1, ListNode list2) {
		if(list1 == null) return list2;
		if(list2 == null) return list1;
		
		ListNode mergeListHead = null;
		if(list1.val < list2.val){
			mergeListHead = list1;
			mergeListHead.next = Merge(list1.next, list2);
		}else{
			mergeListHead = list2;
			mergeListHead.next = Merge(list1, list2.next);
		}
		
		return mergeListHead;
	}
	
	public ListNode Merge2(ListNode list1, ListNode list2) {
		if(list1 == null) return list2;
		if(list2 == null) return list1;
		
		ListNode mergeList = null;
		ListNode curNode = null;
		
		//初始化第一个节点
		if(list1.val < list2.val){
			curNode = list1;
			list1 = list1.next;
			curNode.next = null;
			mergeList = curNode;
		}else{
			curNode = list2;
			list2 = list2.next;
			curNode.next = null;
			mergeList = curNode;
		}
		
		while(list1 != null && list2 != null){
			if(list1.val < list2.val){
				curNode = list1;
				list1 = list1.next;
				curNode.next = null;
				mergeList.next = curNode;
				mergeList = mergeList.next;
			}else{
				curNode = list2;
				list2 = list2.next;
				curNode.next = null;
				mergeList.next = curNode;
				mergeList = mergeList.next;
			}
		}
		
		//处理剩余的结点
		while(list1 != null){
			curNode = list1;
			list1 = list1.next;
			curNode.next = null;
			mergeList.next = curNode;
			mergeList = mergeList.next;
		}
		while(list2 != null){
			curNode = list2;
			list2 = list2.next;
			curNode.next = null;
			mergeList.next = curNode;
			mergeList = mergeList.next;
		}
		
		return mergeList;
	}
	
	public static void main(String[] args) {
		ListNode root1 = new ListNode(1);
		ListNode node1 = new ListNode(3);
		ListNode node2 = new ListNode(5);
		root1.next = node1;
		node1.next = node2;
		
		ListNode root2 = new ListNode(2);
		ListNode node3 = new ListNode(4);
		ListNode node4 = new ListNode(6);
		root2.next = node3;
		node3.next = node4;
		
		MergeLinkedList p = new MergeLinkedList();
		ListNode root3 = p.Merge(root1, root2);
		while(root3 != null){
			System.out.println(root3.val);
			root3 = root3.next;
		}
	}
}
