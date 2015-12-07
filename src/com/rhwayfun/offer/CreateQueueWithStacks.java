package com.rhwayfun.offer;

import java.util.Stack;

public class CreateQueueWithStacks {

	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        //首先入队的元素先放入stack1中
    	stack1.push(node);
    }
    
    public int pop() {
    	//当需要弹出栈顶元素的时候，先把stack1中的元素全部弹出到stack2中
    	//这样，当stack1中没有元素的时候，直接从stack2中弹出栈顶元素即可
    	if(stack2.size() <= 0){
    		while(stack1.size() > 0){
    			stack2.push(stack1.pop());
    		}
    	}
    	
    	//异常处理
    	if(stack2.size() == 0){
    		try {
				throw new Exception("empty queue");
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}
    	
		return stack2.pop();
    }
    
    public static void main(String[] args) {
		CreateQueueWithStacks cq = new CreateQueueWithStacks();
		cq.push(1);
		cq.push(2);
		cq.push(3);
		
		System.out.println(cq.pop());
		System.out.println(cq.pop());
		System.out.println(cq.pop());
		
		cq.push(4);
		System.out.println(cq.pop());
	}
}
