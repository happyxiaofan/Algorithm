package com.rhwayfun.algorithm.sort;


public class SimpleSelectionSort{
	public static void main(String[] args){
		int[] a={49,38,65,97,176,213,227,49,78,34,12,164,11,18,1};
        System.out.println("排序之前：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        //二分插入排序
        simpleSelectionSort(a);
        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
	}
	
	private static void simpleSelectionSort(int[] a){
		for(int i = 0; i < a.length; i++){
			//保存最小值
			int min = a[i];
			//记录最小值的索引位置
			int n = i;
			//获取最小数的值及其索引
			for(int j = i + 1; j < a.length; j++){
				if(a[j] < min){
					min = a[j];
					n = j;
				}
			}
			//把最小数赋给i位置
			a[n] = a[i];
			a[i] = min;
		}
	}
}