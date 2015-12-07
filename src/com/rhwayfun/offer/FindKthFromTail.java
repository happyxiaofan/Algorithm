package com.rhwayfun.offer;

public class FindKthFromTail {

	public static class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	
	public ListNode FindKthToTail(ListNode head,int k) {
		if(head == null || k <= 0) return null;
		int nodesNum = 1;
		ListNode node = head;
		while(node.next != null){
			nodesNum++;
			node = node.next;
		}
		int i = 1;
		node = head;
		while(k <= nodesNum && i != nodesNum - k + 1){
			i++;
			node = node.next;
		}
		if(k <= nodesNum)
			return node;
		return null;
    }
	
	public ListNode FindKthToTail2(ListNode head,int k) {
		if(head == null || k <= 0) return null;
		ListNode pre = head;
		ListNode behind = null;
		for (int i = 0; i < k - 1; i++) {
			if(pre.next != null){
				pre = pre.next;
			}else {
				return null;
			}
		}
		
		behind = head;
		while(pre.next != null){
			pre = pre.next;
			behind = behind.next;
		}
		return behind;
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(4);
		ListNode node4 = new ListNode(5);
		
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		ListNode d = new FindKthFromTail().FindKthToTail(head, 6);
		System.out.println(d);
	}
}
