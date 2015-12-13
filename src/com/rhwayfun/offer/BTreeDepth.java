package com.rhwayfun.offer;

public class BTreeDepth {

	static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;
	    }

	}
	
	public int TreeDepth(TreeNode root) {
		if(root == null) return 0;
		int leftSubTree = TreeDepth(root.left);
		int rightSubTree = TreeDepth(root.right);
		return leftSubTree > rightSubTree ? leftSubTree + 1 : rightSubTree + 1;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(5);
		TreeNode node5 = new TreeNode(6);
		TreeNode node6 = new TreeNode(7);
		
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.right = node5;
		node4.left = node6;
		
		int d = new BTreeDepth().TreeDepth(root);
		System.out.println(d);
	}
}
