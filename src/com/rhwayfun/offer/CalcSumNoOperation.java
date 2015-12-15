package com.rhwayfun.offer;

/**
 * 不使用操作运算符
 * 
 * @author Administrator
 *
 */
public class CalcSumNoOperation {

	public int Add(int num1, int num2) {
		int sum = 0;
		int carray = 0;
		while(num2 != 0){
			sum = num1 ^ num2;
			carray = (num1 & num2) << 1;
			
			num1 = sum;
			num2 = carray;
		}
		return num1;
	}
	
	public static void main(String[] args) {
		int a = new CalcSumNoOperation().Add(2, 9);
		System.out.println(a);
	}
}
