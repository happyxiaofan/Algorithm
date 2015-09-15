package com.rhwayfun.algorithm.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * <p>Title:StackTest</p>
 * <p>Description:</p>
 * @author rhwayfun
 * @date Aug 15, 2015 5:05:38 PM
 * @version 1.0
 */
public class StackTest {

	public static void main(String[] args) {
		List<Node> stack = new ArrayList<Node>();
		
		//添加Node节点
		Node node1 = new Node(1,"唐僧");
		Node node2 = new Node(2,"孙悟空");
		Node node3 = new Node(3,"八戒");
		Node node4 = new Node(4,"沙僧");
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		stack.add(node1);
		stack.add(node2);
		stack.add(node3);
		stack.add(node4);
		
//		System.out.println(stack);
		LinkedListStackImpl ms = new LinkedListStackImpl(stack);
		//得到栈顶元素
		/*Node top = ms.top(stack);
		System.out.println(top);*/
		
		//添加元素
		ms.push(5,"小白龙",stack);
		System.out.println(stack);
	}

}
