package com.rhwayfun.algorithm.sort;

public class HeapSort2 {

	public void heapSort(int[] a){
		for(int i = a.length/2-1; i >= 0; i--){
			//建立一个最大堆
			heapAdjust(a,i,a.length - 1);
		}
		for (int i = a.length - 1; i > 0; i--) {
			//将堆顶元素与当前未经排序的最后一个记录交换
			swap(a,0,i);
			//将数组a中下标从0到i-1的子序列重新调整为最大堆
			heapAdjust(a, 0, i - 1);
		}
		
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	private void heapAdjust(int[] a, int s, int m) {
		int temp = 0,j=0;
		//把堆顶元素保存在临时变量中
		temp = a[s];
		//由于s可能是0，所以需要+1。此外，如果当前结点的序号是s，那么其左孩子是2*s+1(+1是因为s可能是0)
		for(j = 2*s+1; j <= m; j = 2*j+1){
			//找出左右孩子较大的结点的下标
			if(j < m && a[j] < a[j+1]){
				++j;
			}
			if(temp >= a[j]){
				break;
			}
			//把较大的孩子结点的赋给当前结点
			a[s] = a[j];
			//把更大孩子结点的下标赋给s
			s = j;
		}
		//把原来s下标位置的值赋给新的下标为s的值，这样就完成了当前结点与更大孩子结点值的交换
		a[s] = temp;
	}
	
	public static void main(String[] args) {
		new HeapSort2().heapSort(new int[]{90,70,80,60,10,40,50,30,20});
	}
}
