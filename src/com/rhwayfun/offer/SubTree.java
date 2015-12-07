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
	 * �ж�root2�Ƿ���root1���ӽṹ
	 * @param root1
	 * @param root2
	 * @return
	 */
	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
		boolean hasSubTree = false;
		if(root1 != null && root2 != null){
			//�жϵ�һ���ڵ㣬Ҳ���Ǹ��ڵ�
			if(root1.val == root2.val){
				hasSubTree = nodesValEqual(root1,root2);
			}
			//������������������Ѱ��
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
	 * �Ƚ����ö����������Һ��ӽ���Ƿ����
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
