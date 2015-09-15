package com.rhwayfun.algorithm.stack;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class InfixExpressionTest {

	private InfixExpression infixExpression;
	private List<String> stack;
	
	@Before
	public void setUp() throws Exception {
		infixExpression = new InfixExpression();
		stack = new ArrayList<String>(); 
	}

	@Test
	public void testFromInfixToSuffix() {
		String infix = "a + b * c + (d * e + f) * g";
		String suffix = infixExpression.fromInfixToSuffix(infix, stack);
		System.out.println(suffix);
	}

}
