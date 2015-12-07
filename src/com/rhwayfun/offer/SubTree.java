package com.rhwayfun.offer;

public class SubTree {

	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}

	/**
	 * 判断root2是否是root1的子结构
	 * @param root1
	 * @param root2
	 * @return
	 */
	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
		boolean hasSubTree = false;
		if(root1 != null && root2 != null){
			//判断第一个节点，也就是根节点
			if(root1.val == root2.val){
				hasSubTree = nodesValEqual(root1,root2);
			}
			//继续从其左右子树中寻找
			if(!hasSubTree){
				hasSubTree = HasSubtree(root1.left, root2);
			}
			if(!hasSubTree){
				hasSubTree = HasSubtree(root1.right, root2);
			}
		}
		
		return hasSubTree;
	}

	/**
	 * 比较两棵二叉树的左右孩子结点是否相等
	 * @param root1
	 * @param root2
	 * @return
	 */
	private boolean nodesValEqual(TreeNode root1, TreeNode root2) {
		if(root2 == null) return true;
		if(root1 == null) return false;
		if(root1.val != root2.val) return false;
		return nodesValEqual(root1.left, root2.left) && nodesValEqual(root1.right, root2.right);
	}
}
