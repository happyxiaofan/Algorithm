package com.rhwayfun.offer;

import java.util.Stack;

public class CreateQueueWithStacks {

	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        //������ӵ�Ԫ���ȷ���stack1��
    	stack1.push(node);
    }
    
    public int pop() {
    	//����Ҫ����ջ��Ԫ�ص�ʱ���Ȱ�stack1�е�Ԫ��ȫ��������stack2��
    	//��������stack1��û��Ԫ�ص�ʱ��ֱ�Ӵ�stack2�е���ջ��Ԫ�ؼ���
    	if(stack2.size() <= 0){
    		while(stack1.size() > 0){
    			stack2.push(stack1.pop());
    		}
    	}
    	
    	//�쳣����
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
