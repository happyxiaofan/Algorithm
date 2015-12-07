package com.rhwayfun.algorithm.sort;

public class ShellSort2 {

	public void shellSort(int[] a) {
		//定义一个增长序列，就是分割数组的增量
		int inc = a.length,i,j,k;
		do{
			inc = inc / 3 + 1;
			for (i = inc; i < a.length; i++) {
				if(a[i] < a[i - inc]){
					//将a[i]插入有序表中
					k = a[i];
					//记录后移
					for (j = i - inc; j >= 0 && k < a[j]; j-=inc) {
						a[j + inc] = a[j];
					}
					//把需要插入的值插入到那个位置，这里就是j+inc
					a[j + inc] = k;
				}
			}
		}while(inc > 1);//循环的终止条件是增量变为1的时候
		
		for (i = 0;i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	public static void main(String[] args) {
		new ShellSort2().shellSort(new int[]{0,9,1,5,8,3,7,4,6,2});
		
	}
}
