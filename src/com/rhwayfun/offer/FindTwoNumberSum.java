package com.rhwayfun.offer;

import java.util.ArrayList;

public class FindTwoNumberSum {

	public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(array == null || array.length < 1) return list;
		int low = 0;
		int high = array.length - 1;
		while(low < high){
			int curSum = array[low] + array[high];
			if(curSum == sum){
				//���������ǵ�������ģ����Ե�һ���ҵ������Կ϶��ǳ˻���С�ġ�
				//���磬1+4=2+3������ӵ�һ��λ�ÿ�ʼ�ҵĻ�����Ȼ1��4�ĳ˻�����С��
				list.add(array[low]);
				list.add(array[high]);
				break;
			}else if(curSum > sum){
				high--;
			}else{
				low++;
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		int[] array = new int[]{1,2,7,8,13,15};
		ArrayList<Integer> list = new FindTwoNumberSum().FindNumbersWithSum(array, 15);
		System.out.println(list);
	}
}
