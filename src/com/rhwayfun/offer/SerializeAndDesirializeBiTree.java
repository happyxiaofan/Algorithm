package com.rhwayfun.offer;

public class SerializeAndDesirializeBiTree {

	static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;
		public TreeNode(int val) {
			this.val = val;
		}
	}

	String Serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		if (root == null) {
			sb.append("#,");
			return sb.toString();
		}
		sb.append(root.val + ",");
		sb.append(Serialize(root.left));
		sb.append(Serialize(root.right));
		return sb.toString();
	}

	
	int p = -1;
	TreeNode Deserialize(String str) {
		p++;
		if (p >= str.length())
			return null;
		TreeNode node = null;
		String[] strArray = str.split(",");
		if (!strArray[p].equals("#")) {
			node = new TreeNode(Integer.valueOf(strArray[p]));
			node.left = Deserialize(str);
			node.right = Deserialize(str);
		}
		return node;
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
		node2.left = node3;
		node2.right = node4;
		node3.right = node5;
		node4.left = node6;
		
		SerializeAndDesirializeBiTree serializeAndDesirializeBiTree = new SerializeAndDesirializeBiTree();
		String s = serializeAndDesirializeBiTree.Serialize(root);
		System.out.println(s);

		String str = "1,2,#,#,3,4,#,6,#,#,5,7,#,#,#,";
		TreeNode node = serializeAndDesirializeBiTree.Deserialize(str);
		System.out.println(node.val);
	}
}
