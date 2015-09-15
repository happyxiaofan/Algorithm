package com.rhwayfun.algorithm.recursion;

import java.util.Arrays;

public class IntPair {

	private int x;
	private int y;
	
	/**
	 * @Description: �ҳ�һ�����������Ԫ������СԪ��
	 * @param arr
	 * @param low
	 * @param high
	 * @return IntPair  
	 */
	public IntPair max_min(int[] arr,int low,int high){
		IntPair pair = new IntPair();
		//���low��highλ��֮���Ԫ��С��3����ֻҪ�Ƚ�һ�ξ���
		if(high - low < 2){
			if(arr[high] > arr[low]){
				pair.x = arr[high];
			}else{
				pair.y = arr[high];
			}
		}else{
			//��������֮���Ԫ�س���������ʱ����Ҫ����low��high��λ�ð������зֳ����������飬������������Ѱ�Ҹ��Ե����ֵ����Сֵ
			//Ȼ������ж��Ƿ��������е�Ԫ�س�������������ǣ�������з����飬ֱ���������Ԫ��ֻ��������ʱ�򣬽����з֣�Ҳ���������ĸ�
			//if������
			int mid = (low + high)/2;
			IntPair p1 =  max_min(arr, low, mid);
			IntPair p2 = max_min(arr, mid + 1, high);
			pair.x = p1.x > p2.x ? p1.x : p2.x;
			pair.y = p1.y < p2.y ? p1.y : p2.y;
		}
		return pair;
	}
	
	/**
	 * @Description: ʹ����ͨ��������ķ����ҳ�����Ԫ�غ���С��Ԫ��
	 * @param arr
	 * @param low
	 * @param high
	 * @return   
	 * @return IntPair  
	 * @throws
	 */
	public IntPair max_min_simple(int[] arr){
		IntPair pair = new IntPair();
		/******���ÿ⺯��******/
		/*Arrays.sort(arr);
		pair.x = arr[0];
		pair.y = arr[arr.length - 1];*/
		/*******�����ÿ⺯��****/
		pair.x = arr[0];
		pair.y = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if(pair.x < arr[i]) pair.x = arr[i];
			if(pair.y > arr[i]) pair.y = arr[i];
		}
		return pair;
	}
}



