package com.rhwayfun.offer;

public class JudgeSymmetricalOfTree {

	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}

	boolean isSymmetrical(TreeNode pRoot) {
		if (pRoot == null) return true;
		return isSymmetricalCore(pRoot.left, pRoot.right);
	}

	private boolean isSymmetricalCore(TreeNode left, TreeNode right) {
		if (left == null && right == null) return true;
		if (left == null || right == null) return false;
		if (left.val == right.val)
			return isSymmetricalCore(left.right, right.left)
					&& isSymmetricalCore(left.left, right.right);
		return false;
	}
}
