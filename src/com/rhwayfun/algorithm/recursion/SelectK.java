package com.rhwayfun.algorithm.recursion;

import java.util.Arrays;

import com.rhwayfun.algorithm.sort.MergeSort;

/**
 * 
 * <p>Title:SelectK</p>
 * <p>Description:查找一个数组中第k小的元素</p>
 * @author rhwayfun
 * @date Aug 31, 2015 6:23:18 PM
 * @version 1.0
 */
public class SelectK {

	//使用Arrays类的排序方法，时间复杂度为O(nlogn)
	public int simpleSelectK(int[] arr,int k){
		Arrays.sort(arr);
		return arr[k-1];
	}
	
	//使用分治的思想降低程序复杂度,时间爱你复杂度为O(n)
	public int selectK(int[] arr,int n,int k){
		//当排序的元素个数小雨38的时候直接使用插入排序，得到第k小的元素
		if(n < 38){
			MergeSort.sort(arr);
			return arr[k - 1];
		}
		//把要处理的数组分成n/5组
		int[] brr = new int[n/5];
		//获取每个子数组的中项
		for (int i = 0; i < brr.length; i++) {
			brr[i] = mid(arr,5*i,5*i + 4);
		}
		//找出中项的中项
		int m = selectK(brr,brr.length,(brr.length + 1)/2);
		//把小于或者大于m的元素分别存在不同的数组中
		int[] arr1 = new int[3*n/4];
		int[] arr2 = new int[3*n/4];
		int ms = 0,r = 0, s = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] < m) {arr1[r++] = arr[i]; continue;}
			if(arr[i] > m) {arr2[s++] = arr[i];continue;}
			if(arr[i] == m){ms++;continue;}
		}
		if(k<=r){return selectK(arr1,r,k);}
		else if(k <= r + ms){return m;}
		else {return selectK(arr2,s,k-r-ms);}
	}

	private int mid(int[] arr, int start, int end) {
		if((end - start) > arr.length) return -1;
		int len = end - start;
		return arr[len / 2];
	}
}

