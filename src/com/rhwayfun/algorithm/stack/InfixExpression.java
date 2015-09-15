package com.rhwayfun.algorithm.stack;

import java.util.List;

/**
 * 
 * <p>Title:InfixExpression</p>
 * <p>Description:使用栈实现中缀到后缀的转换</p>
 * @author rhwayfun
 * @date Aug 17, 2015 10:20:55 AM
 * @version 1.0
 */
public class InfixExpression {

	public String fromInfixToSuffix(String infix, List<String> stack) {
		StringBuilder suffix = new StringBuilder();
		char[] singleChars = infix.toCharArray();
		for (char singleChar : singleChars) {
			if (singleChar != ' ') {
				if (singleChar != Operator.ADDITION
						&& singleChar != Operator.SUBTRACTION
						&& singleChar != Operator.MULTIPLICATION
						&& singleChar != Operator.DIVISION
						&& singleChar != Operator.LEFTBRACKET
						&& singleChar != Operator.RIGHTBRACKET) {
					suffix.append(singleChar + " ");
				} else {
					// 这里表明当前读到的字符为运算符
					switch (singleChar) {
					case Operator.ADDITION:
						// 在把加法运算符放入栈中之前，需要判断栈中是否有相同优先级的运算符
						// 当且仅当栈中不存在相同优先级的运算符的时候才把运算符键入栈中
						//判断栈中是否有更高优先级或者相同优先级的运算符
						if(stack.isEmpty()){
							stack.add(String.valueOf(Operator.ADDITION));
						}else{
							//栈中有括号运算符
							if(stack.contains(String.valueOf(Operator.LEFTBRACKET)) && !stack.contains(String.valueOf(Operator.RIGHTBRACKET))){
								if (stack.get(stack.size()-1).equals(String.valueOf(Operator.MULTIPLICATION)) || stack.get(stack.size()-1).equals(String.valueOf(Operator.DIVISION))) {
									suffix.append(stack.get(stack.size()-1) + " ");
									stack.remove(stack.size()-1);
									stack.add(String.valueOf(Operator.ADDITION));
								}else{
									stack.add(String.valueOf(Operator.ADDITION));
								}
							}else{
								//栈中没有括号运算符
								// 如果存在相同优先级的运算符就把则把当前与栈中相同优先级的运算符放入输出中
								if (stack.get(stack.size()-1).equals(String.valueOf(Operator.MULTIPLICATION)) || stack.get(stack.size()-1).equals(String.valueOf(Operator.DIVISION))){
									suffix.append(stack.get(stack.size()-1) + " ");
									stack.remove(stack.size()-1);
									stack.add(String.valueOf(Operator.ADDITION));
									//与前一个运算进行比较优先级大小
									if(stack.get(stack.size()-2).equals(String.valueOf(Operator.ADDITION)) || stack.get(stack.size()-2).equals(String.valueOf(Operator.SUBTRACTION))){
										suffix.append(stack.get(stack.size()-2) + " ");
										stack.remove(stack.size()-2);
									}
								}else{
									if(stack.get(stack.size()-1).equals(String.valueOf(Operator.ADDITION)) || stack.get(stack.size()-1).equals(String.valueOf(Operator.SUBTRACTION))){
										suffix.append(stack.get(stack.size()-1) + " ");
										stack.remove(stack.size()-1);
									}
								}
							}
						}
						break;
					case Operator.SUBTRACTION:
						if(stack.isEmpty()){
							stack.add(String.valueOf(Operator.SUBTRACTION));
						}else{
							//栈中有括号运算符
							if(stack.contains(String.valueOf(Operator.LEFTBRACKET)) && !stack.contains(String.valueOf(Operator.RIGHTBRACKET))){
								if (stack.get(stack.size()-1).equals(String.valueOf(Operator.MULTIPLICATION)) || stack.get(stack.size()-1).equals(String.valueOf(Operator.DIVISION))) {
									suffix.append(stack.get(stack.size()-1) + " ");
									stack.remove(stack.size()-1);
									stack.add(String.valueOf(Operator.SUBTRACTION));
								}else{
									stack.add(String.valueOf(Operator.SUBTRACTION));
								}
							}else{
								//栈中没有括号运算符
								// 如果存在相同优先级的运算符就把则把当前与栈中相同优先级的运算符放入输出中
								if (stack.get(stack.size()-1).equals(String.valueOf(Operator.MULTIPLICATION)) || stack.get(stack.size()-1).equals(String.valueOf(Operator.DIVISION))){
									suffix.append(stack.get(stack.size()-1) + " ");
									stack.remove(stack.size()-1);
									stack.add(String.valueOf(Operator.SUBTRACTION));
									//与前一个运算进行比较优先级大小
									if(stack.get(stack.size()-2).equals(String.valueOf(Operator.ADDITION)) || stack.get(stack.size()-2).equals(String.valueOf(Operator.SUBTRACTION))){
										suffix.append(stack.get(stack.size()-2) + " ");
										stack.remove(stack.size()-2);
									}
								}else{
									if(stack.get(stack.size()-1).equals(String.valueOf(Operator.ADDITION)) || stack.get(stack.size()-1).equals(String.valueOf(Operator.SUBTRACTION))){
										suffix.append(stack.get(stack.size()-1) + " ");
										stack.remove(stack.size()-1);
									}
								}
							}
						}
						break;
					case Operator.MULTIPLICATION:
						if(stack.contains(String.valueOf(Operator.LEFTBRACKET)) && !stack.contains(String.valueOf(Operator.RIGHTBRACKET))){
							stack.add(String.valueOf(Operator.MULTIPLICATION));
						}else{
							if(stack.get(stack.size()-1).equals(String.valueOf(Operator.MULTIPLICATION)) || stack.get(stack.size()-1).equals(String.valueOf(Operator.DIVISION))){
								suffix.append(stack.get(stack.size()-1) + " ");
								stack.remove(stack.size()-1);
							}else{
								stack.add(String.valueOf(Operator.MULTIPLICATION));
							}
						}
						break;
					case Operator.DIVISION:
						if(stack.contains(String.valueOf(Operator.LEFTBRACKET)) && !stack.contains(String.valueOf(Operator.RIGHTBRACKET))){
							stack.add(String.valueOf(Operator.DIVISION));
						}else{
							if(stack.get(stack.size()-1).equals(String.valueOf(Operator.MULTIPLICATION)) || stack.get(stack.size()-1).equals(String.valueOf(Operator.DIVISION))){
								suffix.append(stack.get(stack.size()-1) + " ");
								stack.remove(stack.size()-1);
							}else{
								stack.add(String.valueOf(Operator.DIVISION));
							}
						}
						break;
					case Operator.LEFTBRACKET:
						//左括号具有最高优先级
						stack.add(String.valueOf(Operator.LEFTBRACKET));
						break;
					case Operator.RIGHTBRACKET:
						//把左括号后面的所有运算符都弹出，并添加到output中
						int leftBraket = stack.indexOf(String.valueOf(Operator.LEFTBRACKET));
						for(int i = stack.size()-1; i > leftBraket; i--){
							suffix.append(stack.get(i) + " ");
							stack.remove(i);
						}
						//移除左括号
						stack.remove(leftBraket);
					}
				}
			}
		}
		//执行到这里说明所有的输入都被读入
		//现在只需要把栈中剩下的运算符都添加到输出中就行
		for (int i = stack.size()-1;i>=0;i--) {
			if(stack.size() == 1){
				suffix.append(stack.get(i));
			}else{
				suffix.append(stack.get(i) +  " ");
			}
			//把栈中的运算符都移除，栈将成为一个空栈
			stack.remove(i);
		}
		return suffix.toString();
	}
}
