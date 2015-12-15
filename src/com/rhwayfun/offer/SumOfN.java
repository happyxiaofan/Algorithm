package com.rhwayfun.offer;

public class SumOfN {

	private int result = 0;
	
	public int Sum_Solution(int n) {
		calc(n);
		return result;
	}

	private boolean calc(int n) {
		result += n;
		return n != 0 && calc(n - 1);
	}
	
	public static void main(String[] args) {
		int res = new SumOfN().Sum_Solution(10);
		System.out.println(res);
	}
}
