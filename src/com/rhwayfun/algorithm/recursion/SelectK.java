package com.rhwayfun.algorithm.recursion;

import java.util.Arrays;

import com.rhwayfun.algorithm.sort.MergeSort;

/**
 * 
 * <p>Title:SelectK</p>
 * <p>Description:����һ�������е�kС��Ԫ��</p>
 * @author rhwayfun
 * @date Aug 31, 2015 6:23:18 PM
 * @version 1.0
 */
public class SelectK {

	//ʹ��Arrays������򷽷���ʱ�临�Ӷ�ΪO(nlogn)
	public int simpleSelectK(int[] arr,int k){
		Arrays.sort(arr);
		return arr[k-1];
	}
	
	//ʹ�÷��ε�˼�뽵�ͳ����Ӷ�,ʱ�䰮�㸴�Ӷ�ΪO(n)
	public int selectK(int[] arr,int n,int k){
		//�������Ԫ�ظ���С��38��ʱ��ֱ��ʹ�ò������򣬵õ���kС��Ԫ��
		if(n < 38){
			MergeSort.sort(arr);
			return arr[k - 1];
		}
		//��Ҫ���������ֳ�n/5��
		int[] brr = new int[n/5];
		//��ȡÿ�������������
		for (int i = 0; i < brr.length; i++) {
			brr[i] = mid(arr,5*i,5*i + 4);
		}
		//�ҳ����������
		int m = selectK(brr,brr.length,(brr.length + 1)/2);
		//��С�ڻ��ߴ���m��Ԫ�طֱ���ڲ�ͬ��������
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

