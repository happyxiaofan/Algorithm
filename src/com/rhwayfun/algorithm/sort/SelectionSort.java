package com.rhwayfun.algorithm.sort;

/*
 * ѡ���������˼·��
 * �ѵ�һ��Ԫ�����κͺ��������Ԫ�ؽ��бȽϡ�
 * ��һ�ν����󣬾ͻ�����Сֵ��������ǰ�档
 * ��������
 * ѡ�������ʱ�临�Ӷ���O(n^2)
 */
public class SelectionSort {
	public static void sort(int[] data) {
		for (int x = 0; x < data.length - 1; x++) {
			for (int y = x + 1; y < data.length; y++) {
				if (data[y] < data[x]) {
					SortTest.swap(data, x, y);
				}
			}
		}
	}
}
