package com.rhwayfun.offer;


public class ReverseLinkedList {
	
	public static class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	
	public ListNode ReverseList(ListNode head) {
		//��ת֮�������ͷ���
		ListNode reverseListHead = null;
		//��ǰ�����Ľ��
		ListNode curNode = head;
		//�������Ľ���ǰһ����㣬�ýڵ�������õ�ǰ��������ָ����ǰһ�����
		ListNode preNode = null;
		while(curNode != null){
			//��ǰ����������һ�����
			ListNode nextNode = curNode.next;
			if(nextNode == null) reverseListHead = curNode;
			
			curNode.next = preNode;
			preNode = curNode;
			curNode = nextNode;
		}
		return reverseListHead;
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
		
		ListNode pHead = new ReverseLinkedList().ReverseList(head);
		while(pHead != null){
			System.out.println(pHead.val);
			pHead = pHead.next;
		}
	}
}
