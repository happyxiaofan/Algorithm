package com.rhwayfun.algorithm.sort;


/**
 * 
 * <p>Title:BinaryInsertionSort</p>
 * <p>Description:折半插入排序</p>
 * @author rhwayfun
 * @date Sep 7, 2015 1:53:29 PM
 * @version 1.0
 */
public class BinaryInsertionSort {
    public static void main(String[] args) {
        int[] a={49,38,65,97,176,213,227,49,78,34,12,164,11,18,1};
        System.out.println("排序之前：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        
        //二分插入排序
        sort(a);
        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }

	/**
	 * 
	 * @Description: 时间复杂度为O(n^2)
	 * @param a   
	 * @return void  
	 * @throws
	 */
    private static void sort(int[] a) {
       for(int i = 1; i < a.length; i++){
		   int tmp = a[i];
		   int low = 0;
		   int high = i - 1;
		   int mid = 0;
		   int j = 0;	
		   /*由于二分查找算法是折半查找，当low的值大于high的值时就可以
		   * 确定新比较的数需要插入的位置，即为low或者high + 1；可以发现
		   * 当low的值大于high的值后low的值始终比high的值大1
		   */
		   while(low <= high){
			   mid = (low + high)/2;
			   if(tmp <= a[mid]){
				   high  =  mid - 1;
			   }else{
				   low = mid + 1;
			   }
		   }
		   //确定新比较的数需要插入的位置后只需要从位置low处或者high+1往后移一个位置
		   for(j = i-1; j>=low; j--){
			   a[j+1] = a[j];
		   }
		   //把空出的位置的值补上
		   a[j+1] = tmp;
	   }
    }
}