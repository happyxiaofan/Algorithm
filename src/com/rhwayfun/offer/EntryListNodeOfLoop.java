package com.rhwayfun.offer;

import java.util.HashSet;
import java.util.Set;

public class EntryListNodeOfLoop {

	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public ListNode EntryNodeOfLoop(ListNode pHead) {
		Set<ListNode> set = new HashSet<ListNode>();
		while(pHead!= null && set.add(pHead)){
			pHead = pHead.next;
		}
		return pHead;
	}
}
