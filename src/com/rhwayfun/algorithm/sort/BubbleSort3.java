package com.rhwayfun.algorithm.sort;

public class BubbleSort3 {

	public void bubbleSort(int[] a){
		int i,j;
		for(i = 0; i < a.length; i++){
			for(j = i + 1; j < a.length; j++){
				if(a[i] > a[j]){
					swap(a,i,j);
				}
			}
		}
		
		for(i = 0; i < a.length; i++){
			System.out.println(a[i]);
		}
	}
	
	public void bubbleSort2(int[] a){
		int i,j;
		for(i = 0; i < a.length; i++){
			for(j = a.length - 2; j >= i; j--){
				if(a[j] > a[j + 1]){
					swap(a,j,j+1);
				}
			}
		}
		
		for(i = 0; i < a.length; i++){
			System.out.println(a[i]);
		}
	}
	
	public void bubbleSort3(int[] a){
		int i,j;
		boolean flag = true;
		for(i = 0; i < a.length && flag; i++){
			flag = false;
			for(j = a.length - 2; j >= i; j--){
				if(a[j] > a[j + 1]){//如果不进行数据交换，说明是有序的
					swap(a,j,j+1);
					flag = true;
				}
			}
		}
		
		for(i = 0; i < a.length; i++){
			System.out.println(a[i]);
		}
	}
	
	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void main(String[] args) {
		new BubbleSort3().bubbleSort3(new int[]{9,1,5,8,3,7,4,6,2});
	}
}
