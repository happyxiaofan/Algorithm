package com.rhwayfun.algorithm.sort;


public class SimpleSelectionSort{
	public static void main(String[] args){
		int[] a={49,38,65,97,176,213,227,49,78,34,12,164,11,18,1};
        System.out.println("����֮ǰ��");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        //���ֲ�������
        simpleSelectionSort(a);
        System.out.println();
        System.out.println("����֮��");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
	}
	
	private static void simpleSelectionSort(int[] a){
		for(int i = 0; i < a.length; i++){
			//������Сֵ
			int min = a[i];
			//��¼��Сֵ������λ��
			int n = i;
			//��ȡ��С����ֵ��������
			for(int j = i + 1; j < a.length; j++){
				if(a[j] < min){
					min = a[j];
					n = j;
				}
			}
			//����С������iλ��
			a[n] = a[i];
			a[i] = min;
		}
	}
}