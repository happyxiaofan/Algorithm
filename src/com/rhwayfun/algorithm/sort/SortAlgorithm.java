package com.rhwayfun.algorithm.sort;


public class SortAlgorithm{
	public static void main(String[] args){
		int[] a = {46,2,34,10,4,24,0};
		//straightInsertionSort(a);
		//System.out.println(-1/2);
	}
	
	/**
	 * ֱ�Ӳ�������
	 */
	private static void straightInsertionSort(int[] a){
		for(int i = 1; i < a.length; i++){
			//�����i��Ԫ��С�ڵ�i-1��Ԫ�أ��ͽ���λ��
				int j;
				int x = a[i];
				//����һ��Ԫ��
				a[i] = a[i-1];
				//����Ҫ�����λ��
				for(j = i-1;j >=0; j--){
					if(x < a[j]){
						a[j+1] = a[j];
					}else{
						break;
					}
				}
				//���뵽��ȷ��λ��
				a[j + 1] = x;
				//��ӡÿ������Ľ��
				print(a,i);
			}
			
	}
	/**
	 * ��ӡÿ������Ľ��
	 */
	private static void print(int[] a,int i){
		System.out.print("��"+i+"�ˣ�");
		for(int j = 0;j < a.length; j++){
			System.out.print(a[j]+" ");
		}
		System.out.println();
	}
}