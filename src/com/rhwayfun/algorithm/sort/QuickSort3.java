package com.rhwayfun.algorithm.sort;

public class QuickSort3 {

	private static final int MAX_LENGTH_SORT = 50;

	public void quickSort(int[] a){
		qSort2(a,0,a.length - 1);
		//打印输出
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	private void qSort(int[] a, int low, int high) {
		int pivot = 0;
		if(low < high && (high - low) > MAX_LENGTH_SORT){
			//将数组a一分为二
			pivot = partition3(a,low,high);
			//对第一部分进行递归排序
			qSort(a,low,pivot);
			//对第二部分进行递归排序
			qSort(a,pivot + 1,high);
		}else{
			//小数组的时候使用直接插入排序
			insertSort(a);
		}
	}
	
	private void qSort2(int[] a, int low, int high) {
		int pivot = 0;
		if(low < high && (high - low) > MAX_LENGTH_SORT){
			while(low < high){
				//将数组a一分为二
				pivot = partition3(a,low,high);
				//对第一部分进行递归排序
				qSort2(a,low,pivot);
				//对第二部分进行尾递归,这里之所以可以将pivot+1赋给low，是因为一次递归结束
				//之后，low的值就没有用处了。下一次递归调用的执行的就是qSort(a,pivot + 1,high)
				low = pivot +1;
			}
		}else{
			//小数组的时候使用直接插入排序
			insertSort(a);
		}
	}

	private int partition(int[] a, int low, int high) {
		//用第一个元素作为枢轴记录
		int pivotkey = a[low];
		while(low < high){
			//将比枢轴记录小的交换到低端
			while(low < high && a[high] >= pivotkey){
				high--;
			}
			swap(a,low,high);
			//将比枢轴记录大的交换到高端
			while(low < high && a[low] <= pivotkey){
				low++;
			}
			swap(a,low,high);
		}
		//返回枢轴所在的位置
		return low;
	}
	
	private int partition2(int[] a, int low, int high) {
		//用第一个元素作为枢轴记录
		int pivotkey = 0;
		//计算数组中间的下标
		int m = low + (high - low)/2;
		if(a[low] > a[high]){
			swap(a, low, high);
		}
		if(a[m] > a[high]){
			swap(a, m, high);
		}
		if(a[low] > a[m]){
			swap(a, low, m);
		}
		pivotkey = a[low];
		while(low < high){
			//将比枢轴记录小的交换到低端
			while(low < high && a[high] >= pivotkey){
				high--;
			}
			swap(a,low,high);
			//将比枢轴记录大的交换到高端
			while(low < high && a[low] <= pivotkey){
				low++;
			}
			swap(a,low,high);
		}
		//返回枢轴所在的位置
		return low;
	}
	
	private int partition3(int[] a, int low, int high) {
		//用第一个元素作为枢轴记录
		int pivotkey = 0;
		//计算数组中间的下标
		int m = low + (high - low)/2;
		if(a[low] > a[high]){
			swap(a, low, high);
		}
		if(a[m] > a[high]){
			swap(a, m, high);
		}
		if(a[low] > a[m]){
			swap(a, low, m);
		}
		pivotkey = a[low];
		//把枢轴元素备份到一个临时变量中
		int temp = pivotkey;
		while(low < high){
			//将比枢轴记录小的交换到低端
			while(low < high && a[high] >= pivotkey){
				high--;
			}
			//采用替换而不是交换的方式操作
			a[low] = a[high];
			//将比枢轴记录大的交换到高端
			while(low < high && a[low] <= pivotkey){
				low++;
			}
			//采用替换而不是交换的方式操作
			a[high] = a[low];
		}
		//将枢轴的值替换回给a[low]
		a[low] = temp;
		//返回枢轴所在的位置
		return low;
	}
	

	private void swap(int[] a, int low, int high) {
		int temp = a[low];
		a[low] = a[high];
		a[high] = temp;
	}
	
	private void insertSort(int[] a){
		for (int i = 1; i < a.length; i++) {
			if(a[i - 1] > a[i]){
				int j = 0;
				//更小的那个数
				int k = a[i];
				//找到插入k的合适位置
				for (j = i - 1; j >= 0 && a[j] > k; j--) {
					a[j + 1] = a[j];
				}
				a[j+1] = k;
			}
		}
		
		//打印输出
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	public static void main(String[] args) {
		new QuickSort3().quickSort(new int[]{50,10,90,30,70,40,80,60,20});
	}
}
