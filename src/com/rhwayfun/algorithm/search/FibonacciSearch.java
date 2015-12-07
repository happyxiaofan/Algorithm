package com.rhwayfun.algorithm.search;

public class FibonacciSearch {

	public int fibonacciSearch(int[] a,int key){
		int low = 0,high = a.length - 1,mid = 0,k = 0,i =0;
		//��������ĳ��ȵ�ֵ��쳲��������е�λ��
		while(a.length > F(k) - 1){
			k++;
		}
		//����������ֵ��ȫ
		int[] newArray = new int[F(k) - 1];
		System.arraycopy(a, 0, newArray, 0, a.length);
		for(i = a.length; i < F(k) - 1; i++)
			newArray[i] = a[a.length - 1];
		a = newArray;
		//���ҹ���
		while(low <= high){
			mid = low + F(k-1) - 1;
			if(key < a[mid]){
				high = mid - 1;
				k = k - 1;
			}else if(key > a[mid]){
				low = mid + 1;
				k = k - 2;
			}else{
				if(mid < a.length){
					return mid;
				}else{
					//˵���ǲ�ȫ֮�����ֵ
					return a.length - 1;
				}
			}
		}
		return 0;
	}

	private int F(int n) {
		if(n == 0){
			return 0;
		}else if(n == 1){
			return 1;
		}
		int one = 1;
		int two = 0;
		int sum = 0;
		for (int i = 2; i <= n; i++) {
			sum = one + two;
			two = one;
			one = sum;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int[] a = {0,1,16,24,35,47,59,62,73,88,99};
		int i = new FibonacciSearch().fibonacciSearch(a, 59);
		System.out.println(a[i]);
	}
}
