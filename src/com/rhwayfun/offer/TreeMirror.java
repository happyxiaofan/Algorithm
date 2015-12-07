package com.rhwayfun.offer;

import java.util.Stack;

public class TreeMirror {
	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}

	public void Mirror(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return;

		TreeNode nodeTemp = root.left;
		root.left = root.right;
		root.right = nodeTemp;

		if (root.left != null) {
			Mirror(root.left);
		}
		if (root.right != null) {
			Mirror(root.right);
		}
	}

	public void Mirror2(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return;

		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);
		while (!s.isEmpty()) {
			TreeNode node = s.pop();
			//交换左右孩子结点
			TreeNode nodeTemp = node.left;
			node.left = node.right;
			node.right = nodeTemp;
			//遍历左子树
			if (node.left != null)
				s.push(node.left);
			//遍历右子树
			if (node.right != null)
				s.push(node.right);
		}
	}

	public void preOrderTarverse(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		while (root != null || !s.isEmpty()) {
			//遍历左子树
			while (root != null) {
				System.out.println(root.val);
				s.push(root);
				root = root.left;
			}
			// 左子树遍历结束，继续遍历右子树
			if (!s.isEmpty()) {
				root = s.pop();
				root = root.right;
			}
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(8);
		TreeNode node1 = new TreeNode(6);
		TreeNode node2 = new TreeNode(10);
		TreeNode node3 = new TreeNode(5);
		TreeNode node4 = new TreeNode(7);
		TreeNode node5 = new TreeNode(9);
		TreeNode node6 = new TreeNode(11);

		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;

		TreeMirror r = new TreeMirror();
		r.Mirror2(root);

		r.preOrderTarverse(root);
	}
}
