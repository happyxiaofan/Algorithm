package com.rhwayfun.algorithm.sort;


public class QuickSort2{
    public static void main(String[] args) {
        int[] a={49,38,65,97,176,213,227,49,78,34,12,164,11,18,1};
        System.out.println("排序之前：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        //二分插入排序
        quickSort(a);
        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
	
	private static void quickSort(int[] a){
		if(a.length > 0){
			quickSort(a, 0, a.length-1);
		}
	}
	
	private static void quickSort(int[] a, int low, int high){
		//只有low的值小于high的值才结束递归
		if(low < high){
			//获取基准变量的位置
			int mid = getMid(a, low, high);
			//递归直到完成排序
			quickSort(a, 0, mid-1);
			quickSort(a, mid+1, high);
		}		
	}
	
	private static int getMid(int[] a, int low, int high){
		//把基准变量设为临时变量，方便其他元素的比较
		int tmp = a[low];
		while(low < high){
			//找比基准变量大的元素的位置
			while(low < high && a[high] >= tmp){
				high--;
			}
			a[low] = a[high];
			//找比基准变量小的元素的位置
			while(low < high && a[low] <= tmp){
				low++;
			}
			a[high] = a[low];
		}
		a[low] = tmp;
		return low;
	}
}