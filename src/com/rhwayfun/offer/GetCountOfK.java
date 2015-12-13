package com.rhwayfun.offer;

public class GetCountOfK {

	public int GetNumberOfK(int[] array, int k) {
		if (array == null || array.length <= 0)
			return 0;
		int count = 0;
		int firstIndexOfK = getFirstK(array, k, 0, array.length - 1);
		int lastIndexOfK = getLastK(array, k, 0, array.length - 1);
		if (firstIndexOfK >= 0 && lastIndexOfK >= 0)
			count = lastIndexOfK - firstIndexOfK + 1;
		return count;
	}

	private int getLastK(int[] array, int k, int start, int end) {
		if (start > end) return -1;
		int middleIndex = (start + end) / 2;
		int middleData = array[middleIndex];
		if (middleData == k) {
			if ((middleIndex < array.length - 1 && array[middleIndex + 1] != k)
					|| middleIndex == array.length - 1) {
				return middleIndex;
			} else {
				start = middleIndex + 1;
			}
		} else if (middleData > k) {
			end = middleIndex - 1;
		} else {
			start = middleIndex + 1;
		}
		return getLastK(array, k, start, end);
	}

	private int getFirstK(int[] array, int k, int start, int end) {
		if (start > end) return -1;
		int middleIndex = (start + end) / 2;
		int middleData = array[middleIndex];
		if (middleData == k) {
			if ((middleIndex > 0 && array[middleIndex - 1] != k)
					|| middleIndex == 0) {
				return middleIndex;
			} else {
				end = middleIndex - 1;
			}
		} else if (middleData > k) {
			end = middleIndex - 1;
		} else {
			start = middleIndex + 1;
		}
		return getFirstK(array, k, start, end);
	}
	
	public static void main(String[] args) {
		int[] array = new int[]{1,2,3,3,3,3,4,5};
		int count = new GetCountOfK().GetNumberOfK(array, 3);
		System.out.println(count);
	}
}
