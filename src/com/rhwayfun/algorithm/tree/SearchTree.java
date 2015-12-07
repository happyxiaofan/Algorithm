package com.rhwayfun.algorithm.tree;

/**
 * 
 * <p>Title:SearchTree</p>
 * <p>Description:二叉搜索树</p>
 * @author rhwayfun
 * @date Aug 18, 2015 8:01:50 PM
 * @version 1.0
 */
public class SearchTree {

	public TreeNode root;//根节点
	
	public void searchTree(){
		root = null;
	}
	
	//创建一个空树
	public TreeNode makeEmpty(TreeNode node){
		if(node!=null){
			makeEmpty(node.left);
			makeEmpty(node.right);
		}
		return node;
	}
	
	//把一个数插入指定的节点中，生成一颗新的二叉树
	public TreeNode insert(int value,TreeNode node){
		if(node==null){
			node = new TreeNode(value);
		}else{
			if(value <= node.val){
				node.left = insert(value,node.left);
			}else{
				node.right = insert(value,node.right);
			}
		}
		return node;
	}

	//判断二叉树中是否有某数值的节点（遍历算法）
	public boolean lookup(int value, TreeNode node) {
		if(node==null){
			return false;
		}
		if(node.val == value){
			return true;
		}else if(value < node.val){
			return lookup(value,node.left);
		}else{
			return lookup(value,node.right);
		}
	}
	
	//寻找二叉树中最大的元素节点（非递归遍历算法）
	public TreeNode findMax(TreeNode node){
		if(node!=null){
			/*while(node.left!=null){
				node = node.left;
			}*/
			while(node.right!=null){
				node = node.right;
			}
		}
		return node;
	}
	
	//寻找二叉树中元素最小的节点
	public TreeNode finMin(TreeNode node){
		//1、这是非递归算法
		/*if(node!=null){
			while(node.left!=null){
				node = node.left;
			}
		}
		return node;*/
		//2、递归算法实现
		if(node!=null){
			if(node.left!=null){
				node = finMin(node.left);
			}else{
				return node;
			}
		}
		return node;
	}
	
	//打印输出二叉树
	public void printTree(TreeNode node){
		if(node == null)
			return;
		//后序遍历，先打印左孩子和右孩子，最后才打印数值
		printTree(node.left);
		printTree(node.right);
		System.out.println(node.val + " ");
	}
	
	//构建一个二叉树
	public void buildTree(){
		root = new TreeNode(6);
		insert(2, root);
		insert(8, root);
		insert(1, root);
		insert(4, root);
		insert(3, root);
		//insert(5, root);
	}
	
	//删除二叉树的节点
	public TreeNode delete(int value,TreeNode node){
		//要找到二叉树中该节点的位置，如果能找到则进行删除操作，如果不能找到返回false
		//在执行insert方法后，这里的node节点一般就是root节点，因为root节点决定了整棵二叉树
		
		//定一个临时节点
		TreeNode tmpNode;
		
		if(node == null){
			return node;
		}else if(value < node.val){//向左子树中寻找要删除的节点
			node.left = delete(value, node.left);
		}else if(value > node.val){//向右子树中寻找要删除的节点
			node.right = delete(value, node.right);
		}else{
			//如果语句执行到这里，说明在该二叉树中找到了要删除的节点
			//判断当前节点（也就是要删除的节点是否有孩子节点）
			//1、有两个孩子节点
			if(node.left != null && node.right != null){
				//找到右子树中的最左边的叶子节点
				tmpNode = finMin(node.right);
				//把最小元素节点的值赋给当前要被删除的元素
				node.val = tmpNode.val;
				//由于是从右边寻找的最小元素的叶子节点，故当前节点一定是右节点
				//下面需要把要删除节点的直接右孩子节点的引用指向tmpNode节点
				node.right = delete(node.val, node.right);
			}else{
				//有一个或者零个孩子节点
				if(node.left == null){//只有右孩子节点，可以发现当没有孩子节点时，这个判断也可以执行，只不过重新引用的节点变成了null
					node = node.right;
				}else if(node.right == null){//只有左孩子节点
					node = node.left;
				}
			}
		}
		return node;
	}
}
