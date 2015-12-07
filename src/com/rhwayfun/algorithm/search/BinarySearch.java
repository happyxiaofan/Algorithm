package com.rhwayfun.algorithm.search;

public class BinarySearch {

	public int binarySearch(int[] a,int key) {
		int low = 0;
		int high = a.length - 1;
		int mid = 0;
		while(low <= high){
			mid = (low + high) / 2;
			if(a[mid] == key) return mid;
			if(a[mid] > key) high = mid - 1;
			if(a[mid] < key) low = mid + 1;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] a = {0,1,16,24,35,47,59,62,73,88,99};
		int i = new BinarySearch().binarySearch(a, 62);
		System.out.println(a[i]);
	}
}
