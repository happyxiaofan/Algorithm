package com.rhwayfun.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.TreeSet;

public class Permutation {

	public ArrayList<String> permutation2(String str) {
		//ʹ��TressSet����Ϊ���������
		TreeSet<String> tree = new TreeSet<String>();
		//����һ��ջ����ÿ�����е��ַ����
		Stack<String[]> stack = new Stack<String[]>();
		//������յ����н��
		ArrayList<String> results = new ArrayList<String>();
		stack.push(new String[] { str, "" });
		do {
			//�����popStrs����str������ַ���
			String[] popStrs = stack.pop();
			//�մ�
			String oldStr = popStrs[1];
			//str
			String statckStr = popStrs[0];
			for (int i = statckStr.length() - 1; i >= 0; i--) {
				String[] strs = new String[] {
						statckStr.substring(0, i) + statckStr.substring(i + 1),
						oldStr + statckStr.substring(i, i + 1) };
				if (strs[0].length() == 0) {
					tree.add(strs[1]);
				} else {
					stack.push(strs);
				}
			}
		} while (!stack.isEmpty());
		for (String s : tree)
			results.add(s);
		return results;
	}

	public ArrayList<String> permutation(String str) {
		ArrayList<String> list = new ArrayList<String>();
		if (str == null || str.length() <= 0)
			return list;
		list = permutation(list, str.toCharArray(), 0, str.length());
		Collections.sort(list);
		return list;
	}

	private ArrayList<String> permutation(ArrayList<String> list, char[] str,
			int begin, int length) {
		if (begin == length - 1) {
			if(!list.contains(String.valueOf(str))){
				list.add(String.valueOf(str));
			}
		} else {
			for (int i = begin; i < length; i++) {
				if(i == begin || str[i] != str[begin]){
					swap(str, begin, i);
					permutation(list, str, begin + 1, length);
					swap(str, begin, i);
				}
			}
		}
		return list;
	}

	private void swap(char[] str, int begin, int i) {
		char temp = str[begin];
		str[begin] = str[i];
		str[i] = temp;
	}

	public static void main(String[] args) {
		Permutation p = new Permutation();
		String s = "abc";

		ArrayList<String> list = p.permutation2(s);
	}
}
