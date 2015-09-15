package com.rhwayfun.algorithm.tree;

/**
 * 
 * <p>Title:TreeNode</p>
 * <p>Description:二叉查找树节点类</p>
 * @author rhwayfun
 * @date Aug 18, 2015 6:51:42 PM
 * @version 1.0
 */
public class TreeNode {

	public int value;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int value){
		this.value = value;
		this.left = null;
		this.right = null;
	}
}
