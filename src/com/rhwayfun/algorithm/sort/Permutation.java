package com.rhwayfun.algorithm.sort;

public class Permutation {

	//��������str��λ��i��j��ֵ
	public void swap(String[] str, int i, int j) {
		String temp = new String();
		temp = str[i];
		str[i] = str[j];
		str[j] = temp;
	}

	//����ȫ����
	public void arrange(String[] str, int st, int len) {
		if (st == len - 1) {
			for (int i = 0; i < len; i++) {
				System.out.print(str[i] + "  ");
			}
			System.out.println();
		} else {
			for (int i = st; i < len; i++) {
				swap(str, st, i);
				arrange(str, st + 1, len);
				swap(str, st, i);
			}
		}

	}
}
