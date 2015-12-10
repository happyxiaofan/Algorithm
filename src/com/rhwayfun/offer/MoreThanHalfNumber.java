package com.rhwayfun.offer;

public class MoreThanHalfNumber {

	/**
	 * 思路分析：由于有一个数字的次数超过一半，所以那个数字
	 * 肯定是最后一次吧times变量设为1对应的数字
	 * @param array
	 * @return
	 */
	public int MoreThanHalfNum_Solution(int[] array) {
		if(array == null || array.length == 0) return 0;
		int times = 1;
		int result = array[0];
		for (int i = 1; i < array.length; i++) {
			if(times == 0){
				result = array[i];
				times = 1;
			}else if(array[i] == result){
				//遇到相同的数字次数就增加1
				times++;
			}else{
				//没有遇到相同的就把次数减小1
				times--;
			}
		}
		if(!checkMoreThanHalfNum(array,result)) return 0;
		return result;
	}

	/**
	 * 检查该数字是否出现的次数超过一半
	 * @param array
	 * @param result
	 * @return
	 */
	private boolean checkMoreThanHalfNum(int[] array, int result) {
		int times = 0;
		for (int i = 0; i < array.length; i++) {
			if(array[i] == result){
				times++;
			}
		}
		
		boolean isMoreThanHalf = true;
		if(times * 2 <= array.length){
			isMoreThanHalf = false;
		}
		return isMoreThanHalf;
	}
	
	public static void main(String[] args) {
		int[] array = new int[]{1,2,3,2,2,2,5,4,2};
		int a = new MoreThanHalfNumber().MoreThanHalfNum_Solution(null);
		System.out.println(a);
	}
}
