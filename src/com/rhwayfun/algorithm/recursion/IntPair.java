package com.rhwayfun.algorithm.recursion;

import java.util.Arrays;

public class IntPair {

	private int x;
	private int y;
	
	/**
	 * @Description: 找出一个数组中最大元素与最小元素
	 * @param arr
	 * @param low
	 * @param high
	 * @return IntPair  
	 */
	public IntPair max_min(int[] arr,int low,int high){
		IntPair pair = new IntPair();
		//如果low与high位置之间的元素小于3，则只要比较一次就行
		if(high - low < 2){
			if(arr[high] > arr[low]){
				pair.x = arr[high];
			}else{
				pair.y = arr[high];
			}
		}else{
			//当子数组之间的元素超过三个的时候，需要根据low和high的位置把数组切分成两个子数组，在两个子数组寻找各自的最大值和最小值
			//然后继续判断是否子数组中的元素超过三个，如果是，则继续切分数组，直到子数组的元素只有三个的时候，结束切分，也就是上面哪个
			//if的情形
			int mid = (low + high)/2;
			IntPair p1 =  max_min(arr, low, mid);
			IntPair p2 = max_min(arr, mid + 1, high);
			pair.x = p1.x > p2.x ? p1.x : p2.x;
			pair.y = p1.y < p2.y ? p1.y : p2.y;
		}
		return pair;
	}
	
	/**
	 * @Description: 使用普通数组排序的方法找出最大的元素和最小的元素
	 * @param arr
	 * @param low
	 * @param high
	 * @return   
	 * @return IntPair  
	 * @throws
	 */
	public IntPair max_min_simple(int[] arr){
		IntPair pair = new IntPair();
		/******调用库函数******/
		/*Arrays.sort(arr);
		pair.x = arr[0];
		pair.y = arr[arr.length - 1];*/
		/*******不调用库函数****/
		pair.x = arr[0];
		pair.y = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if(pair.x < arr[i]) pair.x = arr[i];
			if(pair.y > arr[i]) pair.y = arr[i];
		}
		return pair;
	}
}



