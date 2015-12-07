package com.rhwayfun.offer;

public class MinNumberInRotatedArray {

	/*//第一种方法：因为是基本有序，所以可以采取顺序查找的方法
	public int orderSearch(int[] a){
		if(a == null || a.length <=0){
			return 0;
		}
		int min = a[0];
		int i = 0;
		for(i = 1; i < a.length; i++){
			if(min > a[i]){
				min = a[i];
			}
		}
		return min;
	}*/
	
	public int search(int[] array){
		//当数组为空或者长度为0的时候返回0
		if(array == null || array.length <=0){
			return 0;
		}
		//数组不为空且数组的长度大于0
		int low = 0;
		int high = array.length - 1;
		int mid = low;
		while(array[low] >= array[high]){
			//两个元素
			if(high - low == 1){
				return array[high];
			}
			//多于两个元素
			mid = (low + high)/2;
			//low、mid和high位置的元素都相同
			if(array[low] == array[high] && array[mid] == array[high]){
				//顺序查找
				return orderSearch(array,low,high);
			}
			//如果中间位置的值大于array[low]的值，说明最小值在a[mid]的右边
			if(array[mid] >= array[low]){
				low = mid;
			}else if(array[mid] <= array[high]){
				high = mid;
			}
		}
		return array[mid];
	}
	
	//顺序查找
	private int orderSearch(int[] array, int low, int high) {
		int result = array[low];
		for(int i = low + 1; i <= high;i++){
			if(result > array[i]){
				result = array[i];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int a = new MinNumberInRotatedArray().search(new int[]{3,4,5,1,2});
		System.out.println(a);
	}
}
