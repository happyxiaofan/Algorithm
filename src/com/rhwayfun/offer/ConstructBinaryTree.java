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
		//����ǰ������ҵ����ڵ��ֵ
		int rootValue = pre[startPreOrder];
		TreeNode rootNode = new TreeNode(rootValue);
		rootNode.left = null;
		rootNode.right = null;
		
		//ֻ��һ����㣬��ô�ýڵ���Ǹ��ڵ㣬ֱ�ӷ���
		if(startPreOrder == endPreOrder){
			if(startInOrder == endInOrder && pre[startPreOrder] == in[startInOrder]){
				return rootNode;
			}
		}
		
		//������������Ľ���ҵ����ڵ�
		int rootOfInOrder = startInOrder;
		while(rootOfInOrder <= endInOrder && in[rootOfInOrder] != rootValue){
			rootOfInOrder++;
		}
		
		//�쳣����
		if(rootOfInOrder == endInOrder && in[rootOfInOrder] != rootValue){
			return null;
		}
		
		//�����������ĳ���
		int leftSubTreeLen = rootOfInOrder - startInOrder;
		//�����������ĳ��ȼ���ǰ���������������������һ�������±�
		int leftIndexOfPreOrderEnd = startPreOrder + leftSubTreeLen;
		//�ؽ�������
		if(leftSubTreeLen > 0){
			rootNode.left = constructCore(pre, startPreOrder + 1, leftIndexOfPreOrderEnd, in, startInOrder, rootOfInOrder - 1);
		}
		//�ؽ�������
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
