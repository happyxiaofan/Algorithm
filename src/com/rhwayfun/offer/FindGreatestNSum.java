package com.rhwayfun.offer;

public class FindGreatestNSum {

	public int FindGreatestSumOfSubArray(int[] array) {
		if(array == null || array.length == 0) return 0;
		int curNSum = 0;
		int greatestSum = 0x80000000;
		for (int i = 0; i < array.length; i++) {
			if(curNSum <= 0){
				curNSum = array[i];
			}else{
				curNSum += array[i];
			}
			if(curNSum > greatestSum) greatestSum = curNSum;
		}
		return greatestSum;
	}
	
	public static void main(String[] args) {
		int[] array = new int[]{1,-2,3,10,-4,7,2,-5};
		int a = new FindGreatestNSum().FindGreatestSumOfSubArray(array);
		System.out.println(a);
		
	}
}
