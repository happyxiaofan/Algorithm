package com.rhwayfun.algorithm.sort;

/**
 * 归并排序
 * @author Administrator
 *
 */
public class MergeSort2 {

	public void mergeSort(int[] a){
		mSort(a,a,0,a.length - 1);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	private void mSort(int[] b, int[] a, int i, int j) {
		int m = 0;
		int[] c = new int[a.length];
		if(i == j){//递归终止条件
			a[i] = b[i];
		}else {
			m = (i + j)/2;
			//将数组a分为a[i...m]并进行排序
			mSort(b,c,i,m);
			//数组a[m+1...j]部分进行排序
			mSort(b, c, m + 1, j);
			//将a[i...m]部分和a[m+1...j]部分的排序结果归并到a
			merge(c,a,i,m,j);
		}
	}

	private void merge(int[] b, int[] a, int i, int m, int t) {
		int j = 0,k = 0,l = 0;
		for(j = m+1,k = i;i <= m && j<=t;k++){
			//将b中记录由小到大归并到a中
			if(b[i] < b[j]){
				a[k] = b[i++];
			}else {
				a[k] = b[j++];
			}
		}
		//将剩余b[i...m]复制到a中
		if(i<=m){
			for(l=0;l<=m-i;l++){
				a[k+l]=b[i+l];
			}
		}
		//将剩余b[m+1...t]复制到数组a中
		if(j<=t){
			for(l=0;l<=t-j;l++){
				a[k+l]=b[j+l];
			}
		}
	}
	
	public static void main(String[] args) {
		new MergeSort2().mergeSort(new int[]{50,10,90,30,70,40,80,60,20});
	}
}
