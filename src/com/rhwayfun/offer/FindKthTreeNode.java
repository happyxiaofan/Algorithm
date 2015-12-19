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

	//采用非递归中序遍历的方式得到第k大的节点
	TreeNode KthNode(TreeNode pRoot, int k) {
		if(pRoot== null) return pRoot;
		//创建一个变量指向第k大的节点
		int p = 0;
		//创建一个栈用于保存遍历的顺序
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
