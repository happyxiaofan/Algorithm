package com.rhwayfun.algorithm.stack;

import java.util.List;

/**
 * 
 * <p>Title:InfixExpression</p>
 * <p>Description:ʹ��ջʵ����׺����׺��ת��</p>
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
					// ���������ǰ�������ַ�Ϊ�����
					switch (singleChar) {
					case Operator.ADDITION:
						// �ڰѼӷ����������ջ��֮ǰ����Ҫ�ж�ջ���Ƿ�����ͬ���ȼ��������
						// ���ҽ���ջ�в�������ͬ���ȼ����������ʱ��Ű����������ջ��
						//�ж�ջ���Ƿ��и������ȼ�������ͬ���ȼ��������
						if(stack.isEmpty()){
							stack.add(String.valueOf(Operator.ADDITION));
						}else{
							//ջ�������������
							if(stack.contains(String.valueOf(Operator.LEFTBRACKET)) && !stack.contains(String.valueOf(Operator.RIGHTBRACKET))){
								if (stack.get(stack.size()-1).equals(String.valueOf(Operator.MULTIPLICATION)) || stack.get(stack.size()-1).equals(String.valueOf(Operator.DIVISION))) {
									suffix.append(stack.get(stack.size()-1) + " ");
									stack.remove(stack.size()-1);
									stack.add(String.valueOf(Operator.ADDITION));
								}else{
									stack.add(String.valueOf(Operator.ADDITION));
								}
							}else{
								//ջ��û�����������
								// ���������ͬ���ȼ���������Ͱ���ѵ�ǰ��ջ����ͬ���ȼ�����������������
								if (stack.get(stack.size()-1).equals(String.valueOf(Operator.MULTIPLICATION)) || stack.get(stack.size()-1).equals(String.valueOf(Operator.DIVISION))){
									suffix.append(stack.get(stack.size()-1) + " ");
									stack.remove(stack.size()-1);
									stack.add(String.valueOf(Operator.ADDITION));
									//��ǰһ��������бȽ����ȼ���С
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
							//ջ�������������
							if(stack.contains(String.valueOf(Operator.LEFTBRACKET)) && !stack.contains(String.valueOf(Operator.RIGHTBRACKET))){
								if (stack.get(stack.size()-1).equals(String.valueOf(Operator.MULTIPLICATION)) || stack.get(stack.size()-1).equals(String.valueOf(Operator.DIVISION))) {
									suffix.append(stack.get(stack.size()-1) + " ");
									stack.remove(stack.size()-1);
									stack.add(String.valueOf(Operator.SUBTRACTION));
								}else{
									stack.add(String.valueOf(Operator.SUBTRACTION));
								}
							}else{
								//ջ��û�����������
								// ���������ͬ���ȼ���������Ͱ���ѵ�ǰ��ջ����ͬ���ȼ�����������������
								if (stack.get(stack.size()-1).equals(String.valueOf(Operator.MULTIPLICATION)) || stack.get(stack.size()-1).equals(String.valueOf(Operator.DIVISION))){
									suffix.append(stack.get(stack.size()-1) + " ");
									stack.remove(stack.size()-1);
									stack.add(String.valueOf(Operator.SUBTRACTION));
									//��ǰһ��������бȽ����ȼ���С
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
						//�����ž���������ȼ�
						stack.add(String.valueOf(Operator.LEFTBRACKET));
						break;
					case Operator.RIGHTBRACKET:
						//�������ź�������������������������ӵ�output��
						int leftBraket = stack.indexOf(String.valueOf(Operator.LEFTBRACKET));
						for(int i = stack.size()-1; i > leftBraket; i--){
							suffix.append(stack.get(i) + " ");
							stack.remove(i);
						}
						//�Ƴ�������
						stack.remove(leftBraket);
					}
				}
			}
		}
		//ִ�е�����˵�����е����붼������
		//����ֻ��Ҫ��ջ��ʣ�µ����������ӵ�����о���
		for (int i = stack.size()-1;i>=0;i--) {
			if(stack.size() == 1){
				suffix.append(stack.get(i));
			}else{
				suffix.append(stack.get(i) +  " ");
			}
			//��ջ�е���������Ƴ���ջ����Ϊһ����ջ
			stack.remove(i);
		}
		return suffix.toString();
	}
}
