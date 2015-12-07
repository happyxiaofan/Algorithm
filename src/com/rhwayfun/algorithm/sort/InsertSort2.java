package com.rhwayfun.algorithm.sort;

public class InsertSort2 {

	public void insertSort(int[] a) {
		int i,j,temp;
		for(i = 1; i < a.length; i++){
			if(a[i] < a[i-1]){
				temp = a[i];
				for(j = i - 1; j >= 0 && a[j] > temp; j--){
					a[j+1] = a[j];
				}
				a[j+1] = temp;
			}
		}
		
		for(i = 0;i < a.length; i++){
			System.out.println(a[i]);
		}
	}
	
	public static void main(String[] args) {
		new InsertSort2().insertSort(new int[]{9,1,5,8,3,7,4,6,2});
	}
}
