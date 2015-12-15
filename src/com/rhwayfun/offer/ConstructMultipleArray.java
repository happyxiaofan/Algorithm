package com.rhwayfun.offer;

public class ConstructMultipleArray {

	/**
	 * 基本思路是把前半部分与后半部分的结果保存到不同的数组中
	 * @param A
	 * @return
	 */
	public int[] multiply(int[] A) {
		int n = A.length;
		//front[i]就是从A[0]...到A[i - 1]的值
		int[] front = new int[n];
		//异常处理
		if(n <= 1) return front;
		/* back[i]就是从A[i + 1]...到A[n - 1]的值
		 * back数组的第一位从最后一位开始，所以back[n - 1]=1
		 */
		int[] back = new int[n];
		front[0] = back[n - 1] = 1;
		//分别计算前半部分与后半部分的值，并分别将结果保存在front与back数组中
		for(int i = 1; i < n; i++){
			front[i] = front[i - 1] * A[i - 1];
			back[n - 1 - i] = back[n - i] * A[n - i];
		}
		//将两个计算结果再次相乘得到最后的结果
		for(int i = 0; i < n; i++){
			front[i] *= back[i];
		}
		//返回的front数组即为所求
		return front;
    }
	
	
	public static void main(String[] args) {
		int[] A ={1,2,3,4};
		int[] r = new ConstructMultipleArray().multiply(A);
		for (int i : r) {
			System.out.print(i + " ");
		}
	}
}
