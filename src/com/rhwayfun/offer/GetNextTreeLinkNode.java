package com.rhwayfun.offer;

public class GetNextTreeLinkNode {

	public class TreeLinkNode {
		int val;
		TreeLinkNode left = null;
		TreeLinkNode right = null;
		TreeLinkNode next = null;

		TreeLinkNode(int val) {
			this.val = val;
		}
	}

	public TreeLinkNode GetNext(TreeLinkNode pNode) {
		TreeLinkNode curNode = null;
		//��һ�����ж��Ƿ����Һ���
		if(pNode.right != null){
			curNode = pNode.right;
			while(curNode.left != null) curNode = curNode.left;
			return curNode;
		}
		//�ڶ������ж��Ƿ����丸�ڵ������
		if(pNode.next == null) return null;
		if(pNode == pNode.next.left){
			return pNode.next;
		}
		//���������������丸�ڵ㣬ֱ�����ڵ����丸�ڵ�ĸ��ڵ������
		curNode = pNode.next;
		while(curNode.next != null){
			if(curNode == curNode.next.left){
				return curNode.next;
			}
			//���������Ҹ��ڵ�
			curNode = curNode.next;
		}
		return null;
	}
	
}
