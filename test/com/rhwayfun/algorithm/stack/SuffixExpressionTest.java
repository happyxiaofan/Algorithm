package com.rhwayfun.algorithm.stack;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SuffixExpressionTest {
	
	private SuffixExpression suffixExpression;
	private List<String> stack;
	@Before
	public void setUp() throws Exception {
		suffixExpression = new SuffixExpression();
		stack = new ArrayList<String>();
	}

	@Test
	public void testSuffixExpression() {
		String exp = "6 5 2 3 + 8 * + 3 + *";
		suffixExpression.suffixExpression(exp,stack);
		System.out.println(stack.get(0));
	}

}
