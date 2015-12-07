package com.rhwayfun.algorithm.sort;

public class ShellSort2 {

	public void shellSort(int[] a) {
		//����һ���������У����Ƿָ����������
		int inc = a.length,i,j,k;
		do{
			inc = inc / 3 + 1;
			for (i = inc; i < a.length; i++) {
				if(a[i] < a[i - inc]){
					//��a[i]�����������
					k = a[i];
					//��¼����
					for (j = i - inc; j >= 0 && k < a[j]; j-=inc) {
						a[j + inc] = a[j];
					}
					//����Ҫ�����ֵ���뵽�Ǹ�λ�ã��������j+inc
					a[j + inc] = k;
				}
			}
		}while(inc > 1);//ѭ������ֹ������������Ϊ1��ʱ��
		
		for (i = 0;i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	public static void main(String[] args) {
		new ShellSort2().shellSort(new int[]{0,9,1,5,8,3,7,4,6,2});
		
	}
}
