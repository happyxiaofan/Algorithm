package com.rhwayfun.algorithm.sort;

public class BubbleSort2 {

	public void sort(int[] a){
		//�����Ƿ��������ı�־,�����false����ô˵���Ѿ��Ź����ˣ���ô��ֹͣ����
		boolean flag = true;
		for(int i=0;i<a.length && flag;i++){
			for(int j=a.length-2;j>=i;j--){
				if(a[j] > a[j+1]){
					swap(a,j,j+1);
					//��flag����Ϊfals����ʾ�Ѿ��ź����ˣ��´�ѭ���;�ֱ������
					flag = false;
				}
			}
		}
		
		//��ӡ����֮�������
		for(int k = 0;k<a.length;k++){
			System.out.println(a[k]);
		}
	}

	private void swap(int[] a, int j, int i) {
		int temp = a[j];
		a[j] = a[j+1];
		a[j+1] = temp;
	}
}
