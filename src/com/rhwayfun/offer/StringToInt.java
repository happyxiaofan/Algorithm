package com.rhwayfun.offer;

public class StringToInt {

	// 设置一个成员变量表示发生溢出
	boolean isValid = true;

	public int StrToInt(String str) {
		// 设置一个变量是否是负数
		boolean isNegtive = false;
		long sum = 0;
		// 第一个字符的下标
		int begin = 0;
		if (str != null && !str.equals("")) {
			// 判断第一个字符是否是正数或者负数
			char firstChar = str.charAt(begin);
			if (firstChar == '+' || firstChar == '-') {
				begin = 1;
				if (firstChar == '-')
					isNegtive = true;
			}
			sum = strToIntCore(str, begin, isNegtive);
		}
		isValid = false;
		return (int) sum;
	}

	private long strToIntCore(String str, int begin, boolean isNegtive) {
		int flag = isNegtive ? -1 : 1;
		long sum = 0;
		// 需要转换的字符下标的起始位置
		int index = begin;
		while (index < str.length()) {
			// 如果字符是从0到9的话
			char curChar = str.charAt(index);
			if (curChar >= '0' && curChar <= '9') {
				sum = sum * 10 + flag * (curChar - '0');
				// 考虑越界的情况，直接返回最小值或者最大值
				if ((isNegtive && sum < Integer.MIN_VALUE) || (!isNegtive
						&& sum > Integer.MAX_VALUE)) {
					return 0;
				}
			}else{
				return 0;
			}
			index++;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		String str = "-0";
		int a = new StringToInt().StrToInt(str);
		System.out.println(a);
	}
}
