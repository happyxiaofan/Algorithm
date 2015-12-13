package com.rhwayfun.offer;

public class IsBiTreeBalanced {

	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;
	 
	    public TreeNode(int val) {
	        this.val = val;
	 
	    }
	 
	}
	
	public boolean IsBalanced_Solution(TreeNode root) {
		if(root == null) return true;
		int leftLen = TreeDepth(root.left);
		int rightLen = TreeDepth(root.right);
		int lenDif = leftLen - rightLen;
		if(lenDif < -1 || lenDif > 1) return false;
		return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
	}

	private int TreeDepth(TreeNode root) {
		if(root == null) return 0;
		int leftLen = TreeDepth(root.left);
		int rightLen = TreeDepth(root.right);
		return leftLen > rightLen ? leftLen + 1 : rightLen + 1;
	}
	
	public static void main(String[] args) {
		
	}
}
