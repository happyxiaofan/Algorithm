package com.rhwayfun.algorithm.tree;

/**
 * 
 * <p>Title:SearchTree</p>
 * <p>Description:����������</p>
 * @author rhwayfun
 * @date Aug 18, 2015 8:01:50 PM
 * @version 1.0
 */
public class SearchTree {

	public TreeNode root;//���ڵ�
	
	public void searchTree(){
		root = null;
	}
	
	//����һ������
	public TreeNode makeEmpty(TreeNode node){
		if(node!=null){
			makeEmpty(node.left);
			makeEmpty(node.right);
		}
		return node;
	}
	
	//��һ��������ָ���Ľڵ��У�����һ���µĶ�����
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

	//�ж϶��������Ƿ���ĳ��ֵ�Ľڵ㣨�����㷨��
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
	
	//Ѱ�Ҷ�����������Ԫ�ؽڵ㣨�ǵݹ�����㷨��
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
	
	//Ѱ�Ҷ�������Ԫ����С�Ľڵ�
	public TreeNode finMin(TreeNode node){
		//1�����Ƿǵݹ��㷨
		/*if(node!=null){
			while(node.left!=null){
				node = node.left;
			}
		}
		return node;*/
		//2���ݹ��㷨ʵ��
		if(node!=null){
			if(node.left!=null){
				node = finMin(node.left);
			}else{
				return node;
			}
		}
		return node;
	}
	
	//��ӡ���������
	public void printTree(TreeNode node){
		if(node == null)
			return;
		//����������ȴ�ӡ���Ӻ��Һ��ӣ����Ŵ�ӡ��ֵ
		printTree(node.left);
		printTree(node.right);
		System.out.println(node.val + " ");
	}
	
	//����һ��������
	public void buildTree(){
		root = new TreeNode(6);
		insert(2, root);
		insert(8, root);
		insert(1, root);
		insert(4, root);
		insert(3, root);
		//insert(5, root);
	}
	
	//ɾ���������Ľڵ�
	public TreeNode delete(int value,TreeNode node){
		//Ҫ�ҵ��������иýڵ��λ�ã�������ҵ������ɾ����������������ҵ�����false
		//��ִ��insert�����������node�ڵ�һ�����root�ڵ㣬��Ϊroot�ڵ���������ö�����
		
		//��һ����ʱ�ڵ�
		TreeNode tmpNode;
		
		if(node == null){
			return node;
		}else if(value < node.val){//����������Ѱ��Ҫɾ���Ľڵ�
			node.left = delete(value, node.left);
		}else if(value > node.val){//����������Ѱ��Ҫɾ���Ľڵ�
			node.right = delete(value, node.right);
		}else{
			//������ִ�е����˵���ڸö��������ҵ���Ҫɾ���Ľڵ�
			//�жϵ�ǰ�ڵ㣨Ҳ����Ҫɾ���Ľڵ��Ƿ��к��ӽڵ㣩
			//1�����������ӽڵ�
			if(node.left != null && node.right != null){
				//�ҵ��������е�����ߵ�Ҷ�ӽڵ�
				tmpNode = finMin(node.right);
				//����СԪ�ؽڵ��ֵ������ǰҪ��ɾ����Ԫ��
				node.val = tmpNode.val;
				//�����Ǵ��ұ�Ѱ�ҵ���СԪ�ص�Ҷ�ӽڵ㣬�ʵ�ǰ�ڵ�һ�����ҽڵ�
				//������Ҫ��Ҫɾ���ڵ��ֱ���Һ��ӽڵ������ָ��tmpNode�ڵ�
				node.right = delete(node.val, node.right);
			}else{
				//��һ������������ӽڵ�
				if(node.left == null){//ֻ���Һ��ӽڵ㣬���Է��ֵ�û�к��ӽڵ�ʱ������ж�Ҳ����ִ�У�ֻ�����������õĽڵ�����null
					node = node.right;
				}else if(node.right == null){//ֻ�����ӽڵ�
					node = node.left;
				}
			}
		}
		return node;
	}
}
