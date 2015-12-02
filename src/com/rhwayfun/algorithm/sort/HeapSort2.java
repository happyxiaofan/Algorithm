package com.rhwayfun.algorithm.sort;

public class HeapSort2 {

	public void heapSort(int[] a){
		for(int i = a.length/2-1; i >= 0; i--){
			//����һ������
			heapAdjust(a,i,a.length - 1);
		}
		for (int i = a.length - 1; i > 0; i--) {
			//���Ѷ�Ԫ���뵱ǰδ����������һ����¼����
			swap(a,0,i);
			//������a���±��0��i-1�����������µ���Ϊ����
			heapAdjust(a, 0, i - 1);
		}
		
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	private void heapAdjust(int[] a, int s, int m) {
		int temp = 0,j=0;
		//�ѶѶ�Ԫ�ر�������ʱ������
		temp = a[s];
		//����s������0��������Ҫ+1�����⣬�����ǰ���������s����ô��������2*s+1(+1����Ϊs������0)
		for(j = 2*s+1; j <= m; j = 2*j+1){
			//�ҳ����Һ��ӽϴ�Ľ����±�
			if(j < m && a[j] < a[j+1]){
				++j;
			}
			if(temp >= a[j]){
				break;
			}
			//�ѽϴ�ĺ��ӽ��ĸ�����ǰ���
			a[s] = a[j];
			//�Ѹ����ӽ����±긳��s
			s = j;
		}
		//��ԭ��s�±�λ�õ�ֵ�����µ��±�Ϊs��ֵ������������˵�ǰ���������ӽ��ֵ�Ľ���
		a[s] = temp;
	}
	
	public static void main(String[] args) {
		new HeapSort2().heapSort(new int[]{90,70,80,60,10,40,50,30,20});
	}
}
