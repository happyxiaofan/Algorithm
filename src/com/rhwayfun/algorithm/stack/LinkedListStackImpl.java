package com.rhwayfun.algorithm.stack;

import java.util.List;

/**
 * 
 * <p>Title:MyStack</p>
 * <p>Description:java实现的栈结构</p>
 * @author rhwayfun
 * @date Aug 15, 2015 4:38:39 PM
 * @version 1.0
 */
public class LinkedListStackImpl {

	//创建一个用于存放Node的List对象
	private List<Node> stack;

	public LinkedListStackImpl(List<Node> stack) {
		this.stack = stack;
	}
	
	//创建一个空栈
	public void createEmptyStack(){
		if(stack != null){
			for (Node node : stack) {
				stack.remove(node);
			}
		}
	}
	
	//添加元素——进栈
	public void push(int key,String nodeName,List<Node> stack){
		Node tmpNode = new Node(key,nodeName);
		//得到栈顶元素
		Node top = top(stack);
		top.setNext(tmpNode);
		stack.add(tmpNode);
	}

	//返回栈顶元素
	public Node top(List<Node> stack) {
		if(stack.isEmpty()){
			System.out.println("空栈！获取失败...");;
		}
		Node top = stack.get(stack.size()-1);
		return top;
	}
}
