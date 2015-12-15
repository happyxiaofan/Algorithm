package com.rhwayfun.offer;

public class StringToInt {

	// ����һ����Ա������ʾ�������
	boolean isValid = true;

	public int StrToInt(String str) {
		// ����һ�������Ƿ��Ǹ���
		boolean isNegtive = false;
		long sum = 0;
		// ��һ���ַ����±�
		int begin = 0;
		if (str != null && !str.equals("")) {
			// �жϵ�һ���ַ��Ƿ����������߸���
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
		// ��Ҫת�����ַ��±����ʼλ��
		int index = begin;
		while (index < str.length()) {
			// ����ַ��Ǵ�0��9�Ļ�
			char curChar = str.charAt(index);
			if (curChar >= '0' && curChar <= '9') {
				sum = sum * 10 + flag * (curChar - '0');
				// ����Խ��������ֱ�ӷ�����Сֵ�������ֵ
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
