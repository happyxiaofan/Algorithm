package com.rhwayfun.algorithm.tree;

import java.util.Stack;

public class TraverseTree {

	// ǰ������ĵݹ�ʵ��
	public void preOrderTraverse(TreeNode node) {
		if (node == null)
			return;
		// �ȸ��ڵ�
		System.out.println(node.val);
		// ������
		preOrderTraverse(node.left);
		// ���Һ���
		preOrderTraverse(node.right);
	}

	// ǰ������ķǵݹ�ʵ��
	public void preOrderTraverse2(TreeNode node) {
		if (node == null) return;
		//����һ��ջ���ڱ�������Ľ��
		Stack<TreeNode> s = new Stack<TreeNode>();
		while(node != null || !s.isEmpty()){
			//����������
			while(node != null){
				System.out.print(node.val + " ");
				s.push(node);
				node = node.left;
			}
			//����������
			if(!s.isEmpty()){
				node = s.pop();
				node = node.right;
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
		TreeNode node7 = new TreeNode(15);
		TreeNode node8 = new TreeNode(24);
		TreeNode node9 = new TreeNode(30);
		TreeNode node10 = new TreeNode(28);

		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node3.left = node7;
		node7.right = node8;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;
		node5.left = node9;
		node6.right = node10;

		TraverseTree t = new TraverseTree();
		t.preOrderTraverse2(root);
	}
}
