package com.rhwayfun.algorithm.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * <p>Title:SuffixExpression</p>
 * <p>Description:ʹ��ջʵ�ֺ�׺���ʽ </p>
 * @author rhwayfun
 * @date Aug 17, 2015 8:53:37 AM
 * @version 1.0
 */
public class SuffixExpression {

	public void suffixExpression(String exp,List<String> stack) {
//		char[] singleChars = exp.toCharArray();
		String[] singleStrs = exp.split(" ");
		double tmpSum = 0;
		for (String singleStr : singleStrs) {
			while (singleStr != "+" || singleStr != "-" || singleStr != "*" || singleStr != "/") {
				stack.add(singleStr);
				break;
			}
			// �ж�ȡ���������
			if(singleStr.equals("+")){
				// ȡ��������ǰ����Ԫ�ؽ�����������
				tmpSum = Double.parseDouble(stack.get(stack.size()-2))
						+ Double.parseDouble(stack.get(stack.size()-3));
				// ������ɺ��ջ���Ѿ�����������Ƴ�ջ��
				stack.remove(stack.size()-1);//�Ƴ�+��size=5
				stack.remove(stack.size()-1);
				stack.remove(stack.size()-1);
				// �Ѽ���������ջ��
				stack.add(String.valueOf(tmpSum));
			}else if(singleStr.equals("-")){
				// ȡ��������ǰ����Ԫ�ؽ�����������
				tmpSum = Double.parseDouble(stack.get(stack.size()-2))
						- Double.parseDouble(stack.get(stack.size()-3));
				// ������ɺ��ջ���Ѿ�����������Ƴ�ջ��
				stack.remove(stack.size()-1);//�Ƴ�+��size=5
				stack.remove(stack.size()-1);
				stack.remove(stack.size()-1);
				// �Ѽ���������ջ��
				stack.add(String.valueOf(tmpSum));
			}else if(singleStr.equals("*")){
				// ȡ��������ǰ����Ԫ�ؽ�����������
				tmpSum = Double.parseDouble(stack.get(stack.size()-2))
						* Double.parseDouble(stack.get(stack.size()-3));
				// ������ɺ��ջ���Ѿ�����������Ƴ�ջ��
				stack.remove(stack.size()-1);//�Ƴ�+��size=5
				stack.remove(stack.size()-1);
				stack.remove(stack.size()-1);
				// �Ѽ���������ջ��
				stack.add(String.valueOf(tmpSum));
			}else if(singleStr.equals("/")){
				// ȡ��������ǰ����Ԫ�ؽ�����������
				tmpSum = Double.parseDouble(stack.get(stack.size()-2))
						/ Double.parseDouble(stack.get(stack.size()-3));
				// ������ɺ��ջ���Ѿ�����������Ƴ�ջ��
				stack.remove(stack.size()-1);//�Ƴ�+��size=5
				stack.remove(stack.size()-1);
				stack.remove(stack.size()-1);
				// �Ѽ���������ջ��
				stack.add(String.valueOf(tmpSum));
			}
			/*switch (singleStr) {
			case "+":
				// ȡ��������ǰ����Ԫ�ؽ�����������
				tmpSum = Double.parseDouble(stack.get(0))
						+ Double.parseDouble(stack.get(1));
				// ������ɺ��ջ���Ѿ�����������Ƴ�ջ��
				stack.remove(0);
				stack.remove(1);
				// �Ѽ���������ջ��
				stack.add(String.valueOf(tmpSum));
				break;
			case "-":
				// ȡ��������ǰ����Ԫ�ؽ�����������
				tmpSum = Double.parseDouble(stack.get(0))
						- Double.parseDouble(stack.get(1));
				// ������ɺ��ջ���Ѿ�����������Ƴ�ջ��
				stack.remove(0);
				stack.remove(1);
				// �Ѽ���������ջ��
				stack.add(String.valueOf(tmpSum));
				break;
			case "*":
				// ȡ��������ǰ����Ԫ�ؽ�����������
				tmpSum = Double.parseDouble(stack.get(0))
						* Double.parseDouble(stack.get(1));
				// ������ɺ��ջ���Ѿ�����������Ƴ�ջ��
				stack.remove(0);
				stack.remove(1);
				// �Ѽ���������ջ��
				stack.add(String.valueOf(tmpSum));
				break;
			case "/":
				// ȡ��������ǰ����Ԫ�ؽ�����������
				tmpSum = Double.parseDouble(stack.get(0))
						/ Double.parseDouble(stack.get(1));
				// ������ɺ��ջ���Ѿ�����������Ƴ�ջ��
				stack.remove(0);
				stack.remove(1);
				// �Ѽ���������ջ��
				stack.add(String.valueOf(tmpSum));
				break;
			}*/
		}
	}
}
