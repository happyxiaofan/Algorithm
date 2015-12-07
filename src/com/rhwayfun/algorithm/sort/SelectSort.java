package com.rhwayfun.algorithm.sort;

public class SelectSort {

	public void selectSort(int[] a){
		int i,j,min;
		for (i = 0; i < a.length; i++) {
			//�����һ��λ�õ�ֵ����Сֵ
			min = i;
			for(j = i + 1; j < a.length; j++){
				if(a[min] > a[j]){
					min = j;
				}
			}
			//���min������i��˵���ҵ���Сֵ���±�
			if(min != i){
				swap(a,i,min);
			}
		}
		
		for(i = 0; i < a.length; i++){
			System.out.println(a[i]);
		}
	}

	private void swap(int[] a, int i, int min) {
		int temp = a[i];
		a[i] = a[min];
		a[min] = temp;
	}
	
	public static void main(String[] args) {
		new SelectSort().selectSort(new int[]{9,1,5,8,3,7,4,6,2});
	}
}
