package com.rhwayfun.offer;

public class DeleteRepeatListNode {

	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public ListNode deleteDuplication(ListNode pHead) {
		if(pHead == null) return pHead;
		ListNode firstNode = new ListNode(-1);
		firstNode.next = pHead;
		ListNode preNode = firstNode;
		ListNode curNode = pHead;
		while(curNode != null && curNode.next != null){
			if(curNode.val == curNode.next.val){
				int val = curNode.val;
				while(curNode != null && curNode.val == val){
					curNode = curNode.next;
				}
				preNode.next = curNode;
			}else{
				preNode = curNode;
				curNode = curNode.next;
			}
		}
		return firstNode.next;
	}
}
