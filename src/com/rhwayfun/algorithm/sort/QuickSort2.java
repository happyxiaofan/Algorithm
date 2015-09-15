package com.rhwayfun.algorithm.sort;


public class QuickSort2{
    public static void main(String[] args) {
        int[] a={49,38,65,97,176,213,227,49,78,34,12,164,11,18,1};
        System.out.println("����֮ǰ��");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        //���ֲ�������
        quickSort(a);
        System.out.println();
        System.out.println("����֮��");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
	
	private static void quickSort(int[] a){
		if(a.length > 0){
			quickSort(a, 0, a.length-1);
		}
	}
	
	private static void quickSort(int[] a, int low, int high){
		//ֻ��low��ֵС��high��ֵ�Ž����ݹ�
		if(low < high){
			//��ȡ��׼������λ��
			int mid = getMid(a, low, high);
			//�ݹ�ֱ���������
			quickSort(a, 0, mid-1);
			quickSort(a, mid+1, high);
		}		
	}
	
	private static int getMid(int[] a, int low, int high){
		//�ѻ�׼������Ϊ��ʱ��������������Ԫ�صıȽ�
		int tmp = a[low];
		while(low < high){
			//�ұȻ�׼�������Ԫ�ص�λ��
			while(low < high && a[high] >= tmp){
				high--;
			}
			a[low] = a[high];
			//�ұȻ�׼����С��Ԫ�ص�λ��
			while(low < high && a[low] <= tmp){
				low++;
			}
			a[high] = a[low];
		}
		a[low] = tmp;
		return low;
	}
}