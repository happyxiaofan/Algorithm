package com.rhwayfun.algorithm.sort;

public class BubbleSort2 {

	public void sort(int[] a){
		//设置是否继续排序的标志,如果是false，那么说明已经排过序了，那么久停止排序
		boolean flag = true;
		for(int i=0;i<a.length && flag;i++){
			for(int j=a.length-2;j>=i;j--){
				if(a[j] > a[j+1]){
					swap(a,j,j+1);
					//把flag设置为fals，表示已经排好序了，下次循环就就直接跳过
					flag = false;
				}
			}
		}
		
		//打印排序之后的数组
		for(int k = 0;k<a.length;k++){
			System.out.println(a[k]);
		}
	}

	private void swap(int[] a, int j, int i) {
		int temp = a[j];
		a[j] = a[j+1];
		a[j+1] = temp;
	}
}
