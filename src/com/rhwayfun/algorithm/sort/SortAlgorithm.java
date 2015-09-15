package com.rhwayfun.algorithm.sort;


public class SortAlgorithm{
	public static void main(String[] args){
		int[] a = {46,2,34,10,4,24,0};
		//straightInsertionSort(a);
		//System.out.println(-1/2);
	}
	
	/**
	 * 直接插入排序
	 */
	private static void straightInsertionSort(int[] a){
		for(int i = 1; i < a.length; i++){
			//如果第i个元素小于第i-1个元素，就交换位置
				int j;
				int x = a[i];
				//后移一个元素
				a[i] = a[i-1];
				//查找要插入的位置
				for(j = i-1;j >=0; j--){
					if(x < a[j]){
						a[j+1] = a[j];
					}else{
						break;
					}
				}
				//插入到正确的位置
				a[j + 1] = x;
				//打印每趟排序的结果
				print(a,i);
			}
			
	}
	/**
	 * 打印每趟排序的结果
	 */
	private static void print(int[] a,int i){
		System.out.print("第"+i+"趟：");
		for(int j = 0;j < a.length; j++){
			System.out.print(a[j]+" ");
		}
		System.out.println();
	}
}