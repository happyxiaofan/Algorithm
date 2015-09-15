package com.rhwayfun.algorithm.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * <p>Title:SuffixExpression</p>
 * <p>Description:使用栈实现后缀表达式 </p>
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
			// 判断取到的运算符
			if(singleStr.equals("+")){
				// 取出集合中前两个元素进行算数运算
				tmpSum = Double.parseDouble(stack.get(stack.size()-2))
						+ Double.parseDouble(stack.get(stack.size()-3));
				// 计算完成后把栈中已经运算过的数移除栈中
				stack.remove(stack.size()-1);//移除+，size=5
				stack.remove(stack.size()-1);
				stack.remove(stack.size()-1);
				// 把计算结果放入栈中
				stack.add(String.valueOf(tmpSum));
			}else if(singleStr.equals("-")){
				// 取出集合中前两个元素进行算数运算
				tmpSum = Double.parseDouble(stack.get(stack.size()-2))
						- Double.parseDouble(stack.get(stack.size()-3));
				// 计算完成后把栈中已经运算过的数移除栈中
				stack.remove(stack.size()-1);//移除+，size=5
				stack.remove(stack.size()-1);
				stack.remove(stack.size()-1);
				// 把计算结果放入栈中
				stack.add(String.valueOf(tmpSum));
			}else if(singleStr.equals("*")){
				// 取出集合中前两个元素进行算数运算
				tmpSum = Double.parseDouble(stack.get(stack.size()-2))
						* Double.parseDouble(stack.get(stack.size()-3));
				// 计算完成后把栈中已经运算过的数移除栈中
				stack.remove(stack.size()-1);//移除+，size=5
				stack.remove(stack.size()-1);
				stack.remove(stack.size()-1);
				// 把计算结果放入栈中
				stack.add(String.valueOf(tmpSum));
			}else if(singleStr.equals("/")){
				// 取出集合中前两个元素进行算数运算
				tmpSum = Double.parseDouble(stack.get(stack.size()-2))
						/ Double.parseDouble(stack.get(stack.size()-3));
				// 计算完成后把栈中已经运算过的数移除栈中
				stack.remove(stack.size()-1);//移除+，size=5
				stack.remove(stack.size()-1);
				stack.remove(stack.size()-1);
				// 把计算结果放入栈中
				stack.add(String.valueOf(tmpSum));
			}
			/*switch (singleStr) {
			case "+":
				// 取出集合中前两个元素进行算数运算
				tmpSum = Double.parseDouble(stack.get(0))
						+ Double.parseDouble(stack.get(1));
				// 计算完成后把栈中已经运算过的数移除栈中
				stack.remove(0);
				stack.remove(1);
				// 把计算结果放入栈中
				stack.add(String.valueOf(tmpSum));
				break;
			case "-":
				// 取出集合中前两个元素进行算数运算
				tmpSum = Double.parseDouble(stack.get(0))
						- Double.parseDouble(stack.get(1));
				// 计算完成后把栈中已经运算过的数移除栈中
				stack.remove(0);
				stack.remove(1);
				// 把计算结果放入栈中
				stack.add(String.valueOf(tmpSum));
				break;
			case "*":
				// 取出集合中前两个元素进行算数运算
				tmpSum = Double.parseDouble(stack.get(0))
						* Double.parseDouble(stack.get(1));
				// 计算完成后把栈中已经运算过的数移除栈中
				stack.remove(0);
				stack.remove(1);
				// 把计算结果放入栈中
				stack.add(String.valueOf(tmpSum));
				break;
			case "/":
				// 取出集合中前两个元素进行算数运算
				tmpSum = Double.parseDouble(stack.get(0))
						/ Double.parseDouble(stack.get(1));
				// 计算完成后把栈中已经运算过的数移除栈中
				stack.remove(0);
				stack.remove(1);
				// 把计算结果放入栈中
				stack.add(String.valueOf(tmpSum));
				break;
			}*/
		}
	}
}
