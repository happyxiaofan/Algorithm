package com.rhwayfun.offer;

import java.util.Stack;

public class FindKthTreeNode {

	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	//���÷ǵݹ���������ķ�ʽ�õ���k��Ľڵ�
	TreeNode KthNode(TreeNode pRoot, int k) {
		if(pRoot== null) return pRoot;
		//����һ������ָ���k��Ľڵ�
		int p = 0;
		//����һ��ջ���ڱ��������˳��
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode curNode = pRoot;
		while(curNode != null || !s.isEmpty()){
			while(curNode != null){
				s.add(curNode);
				curNode = curNode.left;
			}
			if(!s.isEmpty()){
				curNode = s.pop();
				p++;
				if(p == k) return curNode;
				curNode = curNode.right;
			}
		}
		return null;
	}
}
