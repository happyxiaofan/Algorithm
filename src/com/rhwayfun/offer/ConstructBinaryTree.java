package com.rhwayfun.offer;

public class ConstructBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		return constructCore(pre,0,pre.length - 1,in,0,in.length - 1);
	}

	private TreeNode constructCore(int[] pre,int startPreOrder, int endPreOrder, int[] in,int startInOrder, int endInOrder) {
		//根据前序遍历找到根节点的值
		int rootValue = pre[startPreOrder];
		TreeNode rootNode = new TreeNode(rootValue);
		rootNode.left = null;
		rootNode.right = null;
		
		//只有一个结点，那么该节点就是根节点，直接返回
		if(startPreOrder == endPreOrder){
			if(startInOrder == endInOrder && pre[startPreOrder] == in[startInOrder]){
				return rootNode;
			}
		}
		
		//根据中序遍历的结果找到根节点
		int rootOfInOrder = startInOrder;
		while(rootOfInOrder <= endInOrder && in[rootOfInOrder] != rootValue){
			rootOfInOrder++;
		}
		
		//异常处理
		if(rootOfInOrder == endInOrder && in[rootOfInOrder] != rootValue){
			return null;
		}
		
		//计算左子树的长度
		int leftSubTreeLen = rootOfInOrder - startInOrder;
		//根据左子树的长度计算前序遍历结果中左子树的最后一个结点的下标
		int leftIndexOfPreOrderEnd = startPreOrder + leftSubTreeLen;
		//重建左子树
		if(leftSubTreeLen > 0){
			rootNode.left = constructCore(pre, startPreOrder + 1, leftIndexOfPreOrderEnd, in, startInOrder, rootOfInOrder - 1);
		}
		//重建右子树
		if(leftSubTreeLen < endPreOrder - startPreOrder){
			rootNode.right = constructCore(pre, leftIndexOfPreOrderEnd + 1, endPreOrder, in, rootOfInOrder + 1, endInOrder);
		}
		return rootNode;
	}
	
	public static void main(String[] args) {
		int[] pre = {1,2,4,7,3,5,6,8};
		int[] in = {4,7,2,1,5,3,8,6};
		TreeNode root = new ConstructBinaryTree().reConstructBinaryTree(pre, in);
		System.out.println(root);
	}
}
