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
		
		//���Node�ڵ�
		Node node1 = new Node(1,"��ɮ");
		Node node2 = new Node(2,"�����");
		Node node3 = new Node(3,"�˽�");
		Node node4 = new Node(4,"ɳɮ");
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		stack.add(node1);
		stack.add(node2);
		stack.add(node3);
		stack.add(node4);
		
//		System.out.println(stack);
		LinkedListStackImpl ms = new LinkedListStackImpl(stack);
		//�õ�ջ��Ԫ��
		/*Node top = ms.top(stack);
		System.out.println(top);*/
		
		//���Ԫ��
		ms.push(5,"С����",stack);
		System.out.println(stack);
	}

}
