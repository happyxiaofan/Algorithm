package com.rhwayfun.offer;

public class FindFirstCommonListNode {

	static class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		// 得到两个链表的长度
		int pListLengthOf1 = 0;
		int pListLengthOf2 = 0;
		
		ListNode temp = pHead1;
		while (temp != null) {
			pListLengthOf1++;
			temp = temp.next;
		}
		temp = pHead2;
		while (temp != null) {
			pListLengthOf2++;
			temp = temp.next;
		}

		// 计算两个链表相差的结点个数
		int pListNodeDif = pListLengthOf1 - pListLengthOf2;
		ListNode pListNodeLong = pHead1;
		ListNode pListNodeShort = pHead2;
		if (pListNodeDif < 0) {
			pListNodeLong = pHead2;
			pListNodeShort = pHead1;
			pListNodeDif = pListLengthOf2 - pListLengthOf1;
		}
		
		// 让较长的那个链表先走几步
		for (int i = 0; i < pListNodeDif; i++) 
			pListNodeLong = pListNodeLong.next;
		// 开始寻找
		while (pListNodeLong != null && pListNodeShort != null
				&& pListNodeLong.val != pListNodeShort.val) {
			pListNodeLong = pListNodeLong.next;
			pListNodeShort = pListNodeShort.next;
		}
		
		//得到两个链表的第一个公共结点
		ListNode pFirstCommonListNode = pListNodeLong;
		return pFirstCommonListNode;
	}
	
	public static void main(String[] args) {
		ListNode pHead1 = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(6);
		ListNode node4 = new ListNode(7);
		pHead1.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		ListNode pHead2 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		pHead2.next = node5;
		node5.next = node6;
		node6.next = node7;
		
		ListNode node = new FindFirstCommonListNode().FindFirstCommonNode(pHead1, pHead2);
		System.out.println(node.val);
	}
}
