package com.rhwayfun.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述：从尾到头打印链表
 * @author Administrator
 *
 */
public class PrintLinkListFromTailToFront {

	static class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		int len = 0, i = 0;
		ListNode temp = listNode;
		while (listNode!= null) {
			++len;
			listNode = listNode.next;
		}
		Integer[] nodes = new Integer[len];
		while (temp!= null) {
			nodes[i++] = temp.val;
			temp = temp.next;
		}
		Integer[] nodes2 = new Integer[len];
		for (int j = 0; j < nodes.length; j++) {
			nodes2[len - 1 -j] = nodes[j];
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int j = 0;j<nodes.length;j++){
			list.add(j, nodes2[j]);
		}
		return list;
	}
	
	public static void main(String[] args) {
		ListNode root = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(4);
		
		root.next = node1;
		node1.next = node2;
		node2.next = node3;
		
		List<Integer> list = new PrintLinkListFromTailToFront().printListFromTailToHead(root);
		for (Integer integer : list) {
			System.out.print(integer + "\t");
		}
	}
}
