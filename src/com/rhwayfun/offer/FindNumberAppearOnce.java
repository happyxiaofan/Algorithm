package com.rhwayfun.offer;

public class FindNumberAppearOnce {

	public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
		if(array == null || array.length < 2) return;
		int resultExclusiveOr = 0;
		for (int i = 0; i < array.length; i++) {
			resultExclusiveOr ^= array[i];
		}
		//找到右边第一个是1的位的位置
		int rightFirstIndexIs1 = findFirstIndexis1(resultExclusiveOr);
		//把该位是1的与不是1的数分别两部分
		for (int i = 0; i < array.length; i++) {
			if(isBit1(array[i],rightFirstIndexIs1)){
				num1[0] ^= array[i];
			}else{
				num2[0] ^= array[i];
			}
		}
	}

	//数num右数index为是否为1
	private boolean isBit1(int num, int index) {
		num = num >> index;
		return ((num & 1) == 1) ? true : false;
	}

	//找到右边第一个是1位的位置
	private int findFirstIndexis1(int resultExclusiveOr) {
		int index = 0;
		while(((resultExclusiveOr & 1) == 0) && index < 32){
			resultExclusiveOr = resultExclusiveOr >> 1;
			index++;
		}
		return index;
	}
	
	public static void main(String[] args) {
		int[] array = new int[]{2,4,3,6,3,2,5,5};
		int[] num1 = new int[]{0};
		int[] num2 = new int[]{0};
		new FindNumberAppearOnce().FindNumsAppearOnce(array, num1, num2);
		System.out.println(num1[0] + "," + num2[0]);
	}
}
