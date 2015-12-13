package com.rhwayfun.offer;

import java.util.ArrayList;

public class FindTwoNumberSum {

	public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(array == null || array.length < 1) return list;
		int low = 0;
		int high = array.length - 1;
		while(low < high){
			int curSum = array[low] + array[high];
			if(curSum == sum){
				//由于数组是递增排序的，所以第一个找到的数对肯定是乘积最小的。
				//比如，1+4=2+3，如果从第一个位置开始找的话，显然1与4的乘积是最小的
				list.add(array[low]);
				list.add(array[high]);
				break;
			}else if(curSum > sum){
				high--;
			}else{
				low++;
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		int[] array = new int[]{1,2,7,8,13,15};
		ArrayList<Integer> list = new FindTwoNumberSum().FindNumbersWithSum(array, 15);
		System.out.println(list);
	}
}
