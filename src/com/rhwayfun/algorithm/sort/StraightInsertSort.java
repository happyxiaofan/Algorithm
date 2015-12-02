package com.rhwayfun.algorithm.sort;

public class StraightInsertSort {

	public void insertSort(int[] a){
		for (int i = 1; i < a.length; i++) {
			if(a[i - 1] > a[i]){
				int j = 0;
				//��С���Ǹ���
				int k = a[i];
				//�ҵ�����k�ĺ���λ��
				for (j = i - 1; j >= 0 && a[j] > k; j--) {
					a[j + 1] = a[j];
				}
				a[j+1] = k;
			}
		}
		
		//��ӡ���
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	public static void main(String[] args) {
		new StraightInsertSort().insertSort(new int[]{50,10,90,30,70,40,80,60,20});
	}
}
