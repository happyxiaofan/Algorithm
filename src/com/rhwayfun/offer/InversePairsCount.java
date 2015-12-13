package com.rhwayfun.offer;

public class InversePairsCount {

	public int InversePairs(int[] array) {
		if (array == null || array.length <= 0)
			return 0;
		int[] copy = new int[array.length];
		for (int i = 0; i < array.length; i++)
			copy[i] = array[i];
		int count = mergeCount(array, copy, 0, array.length - 1);
		return count;
	}

	private int mergeCount(int[] array, int[] copy, int start, int end) {
		if(start == end){
			copy[start] = array[start];
			return 0;
		}
		int len = (end - start) / 2;
		int leftCount = mergeCount(copy, array, start, start + len);
		int rightCount = mergeCount(copy, array, start + len + 1, end);
		//i指向第一个子数组的最后一个下标
		int i = start +len;	
		//j指向第二个子数组的最后一个下标
		int j = end;
		int indexCopy = end;
		int count = 0;
		while(i >= start && j >= start + len + 1){
			if(array[i] > array[j]){
				copy[indexCopy--] = array[i--];
				count += j - start - len;
			}else{
				copy[indexCopy--] = array[j--];
			}
		}
		for(; i >= start; i--) 
			copy[indexCopy--] = array[i];
		for(; j >= start + len + 1; j--) 
			copy[indexCopy--] = array[j];
		return leftCount + rightCount + count;
	}
	
	
	public static void main(String[] args) {
		int[] array = new int[]{7,5,6,4};
		int count = new InversePairsCount().InversePairs(array);
		System.out.println(count);
	}
}
