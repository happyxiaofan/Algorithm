package com.rhwayfun.algorithm.sort;

public class QuickSort3 {

	private static final int MAX_LENGTH_SORT = 50;

	public void quickSort(int[] a){
		qSort2(a,0,a.length - 1);
		//��ӡ���
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	private void qSort(int[] a, int low, int high) {
		int pivot = 0;
		if(low < high && (high - low) > MAX_LENGTH_SORT){
			//������aһ��Ϊ��
			pivot = partition3(a,low,high);
			//�Ե�һ���ֽ��еݹ�����
			qSort(a,low,pivot);
			//�Եڶ����ֽ��еݹ�����
			qSort(a,pivot + 1,high);
		}else{
			//С�����ʱ��ʹ��ֱ�Ӳ�������
			insertSort(a);
		}
	}
	
	private void qSort2(int[] a, int low, int high) {
		int pivot = 0;
		if(low < high && (high - low) > MAX_LENGTH_SORT){
			while(low < high){
				//������aһ��Ϊ��
				pivot = partition3(a,low,high);
				//�Ե�һ���ֽ��еݹ�����
				qSort2(a,low,pivot);
				//�Եڶ����ֽ���β�ݹ�,����֮���Կ��Խ�pivot+1����low������Ϊһ�εݹ����
				//֮��low��ֵ��û���ô��ˡ���һ�εݹ���õ�ִ�еľ���qSort(a,pivot + 1,high)
				low = pivot +1;
			}
		}else{
			//С�����ʱ��ʹ��ֱ�Ӳ�������
			insertSort(a);
		}
	}

	private int partition(int[] a, int low, int high) {
		//�õ�һ��Ԫ����Ϊ�����¼
		int pivotkey = a[low];
		while(low < high){
			//���������¼С�Ľ������Ͷ�
			while(low < high && a[high] >= pivotkey){
				high--;
			}
			swap(a,low,high);
			//���������¼��Ľ������߶�
			while(low < high && a[low] <= pivotkey){
				low++;
			}
			swap(a,low,high);
		}
		//�����������ڵ�λ��
		return low;
	}
	
	private int partition2(int[] a, int low, int high) {
		//�õ�һ��Ԫ����Ϊ�����¼
		int pivotkey = 0;
		//���������м���±�
		int m = low + (high - low)/2;
		if(a[low] > a[high]){
			swap(a, low, high);
		}
		if(a[m] > a[high]){
			swap(a, m, high);
		}
		if(a[low] > a[m]){
			swap(a, low, m);
		}
		pivotkey = a[low];
		while(low < high){
			//���������¼С�Ľ������Ͷ�
			while(low < high && a[high] >= pivotkey){
				high--;
			}
			swap(a,low,high);
			//���������¼��Ľ������߶�
			while(low < high && a[low] <= pivotkey){
				low++;
			}
			swap(a,low,high);
		}
		//�����������ڵ�λ��
		return low;
	}
	
	private int partition3(int[] a, int low, int high) {
		//�õ�һ��Ԫ����Ϊ�����¼
		int pivotkey = 0;
		//���������м���±�
		int m = low + (high - low)/2;
		if(a[low] > a[high]){
			swap(a, low, high);
		}
		if(a[m] > a[high]){
			swap(a, m, high);
		}
		if(a[low] > a[m]){
			swap(a, low, m);
		}
		pivotkey = a[low];
		//������Ԫ�ر��ݵ�һ����ʱ������
		int temp = pivotkey;
		while(low < high){
			//���������¼С�Ľ������Ͷ�
			while(low < high && a[high] >= pivotkey){
				high--;
			}
			//�����滻�����ǽ����ķ�ʽ����
			a[low] = a[high];
			//���������¼��Ľ������߶�
			while(low < high && a[low] <= pivotkey){
				low++;
			}
			//�����滻�����ǽ����ķ�ʽ����
			a[high] = a[low];
		}
		//�������ֵ�滻�ظ�a[low]
		a[low] = temp;
		//�����������ڵ�λ��
		return low;
	}
	

	private void swap(int[] a, int low, int high) {
		int temp = a[low];
		a[low] = a[high];
		a[high] = temp;
	}
	
	private void insertSort(int[] a){
		for (int i = 1; i < a.length; i++) {
			if(a[i - 1] > a[i]){
				int j = 0;
				//��С���Ǹ���
				int k = a[i];
				//�ҵ�����k�ĺ���λ��
				for (j = i - 1; j >= 0 && a[j] > k; j--) {
					a[j + 1] = a[j];
				}
				a[j+1] = k;
			}
		}
		
		//��ӡ���
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	public static void main(String[] args) {
		new QuickSort3().quickSort(new int[]{50,10,90,30,70,40,80,60,20});
	}
}
