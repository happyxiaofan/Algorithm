package com.rhwayfun.algorithm.tree;

import org.junit.Before;
import org.junit.Test;

public class SearchTreeTest {

	private SearchTree s;
	@Before
	public void setUp() throws Exception {
		s = new SearchTree();
		//s.searchTree();
	}

	@Test
	public void testSearchTree() {
	}

	@Test
	public void testInsert() {
	}

	@Test
	public void testLookup() {
	}

	@Test
	public void testBuildTree() {
		
		System.out.println("********ɾ��2�ڵ�֮ǰ�ĺ������********");
		
		s.makeEmpty(s.root);
		s.buildTree();
		s.printTree(s.root);
		
		//T.printTree(T.root);
		//TreeNode f = s.findMax(s.root);
		//System.out.println(f.value);;
		
		//ɾ��ֵΪ2�Ľڵ�
		s.delete(2,s.root);
		System.out.println("********ɾ��2�ڵ�֮��ĺ������********");
		s.printTree(s.root);
	}

}
