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
		
		System.out.println("********删除2节点之前的后序遍历********");
		
		s.makeEmpty(s.root);
		s.buildTree();
		s.printTree(s.root);
		
		//T.printTree(T.root);
		//TreeNode f = s.findMax(s.root);
		//System.out.println(f.value);;
		
		//删除值为2的节点
		s.delete(2,s.root);
		System.out.println("********删除2节点之后的后序遍历********");
		s.printTree(s.root);
	}

}
