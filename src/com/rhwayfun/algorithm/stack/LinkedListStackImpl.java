package com.rhwayfun.algorithm.stack;

import java.util.List;

/**
 * 
 * <p>Title:MyStack</p>
 * <p>Description:javaʵ�ֵ�ջ�ṹ</p>
 * @author rhwayfun
 * @date Aug 15, 2015 4:38:39 PM
 * @version 1.0
 */
public class LinkedListStackImpl {

	//����һ�����ڴ��Node��List����
	private List<Node> stack;

	public LinkedListStackImpl(List<Node> stack) {
		this.stack = stack;
	}
	
	//����һ����ջ
	public void createEmptyStack(){
		if(stack != null){
			for (Node node : stack) {
				stack.remove(node);
			}
		}
	}
	
	//���Ԫ�ء�����ջ
	public void push(int key,String nodeName,List<Node> stack){
		Node tmpNode = new Node(key,nodeName);
		//�õ�ջ��Ԫ��
		Node top = top(stack);
		top.setNext(tmpNode);
		stack.add(tmpNode);
	}

	//����ջ��Ԫ��
	public Node top(List<Node> stack) {
		if(stack.isEmpty()){
			System.out.println("��ջ����ȡʧ��...");;
		}
		Node top = stack.get(stack.size()-1);
		return top;
	}
}
