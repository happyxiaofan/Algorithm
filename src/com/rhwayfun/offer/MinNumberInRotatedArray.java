package com.rhwayfun.offer;

public class MinNumberInRotatedArray {

	/*//��һ�ַ�������Ϊ�ǻ����������Կ��Բ�ȡ˳����ҵķ���
	public int orderSearch(int[] a){
		if(a == null || a.length <=0){
			return 0;
		}
		int min = a[0];
		int i = 0;
		for(i = 1; i < a.length; i++){
			if(min > a[i]){
				min = a[i];
			}
		}
		return min;
	}*/
	
	public int search(int[] array){
		//������Ϊ�ջ��߳���Ϊ0��ʱ�򷵻�0
		if(array == null || array.length <=0){
			return 0;
		}
		//���鲻Ϊ��������ĳ��ȴ���0
		int low = 0;
		int high = array.length - 1;
		int mid = low;
		while(array[low] >= array[high]){
			//����Ԫ��
			if(high - low == 1){
				return array[high];
			}
			//��������Ԫ��
			mid = (low + high)/2;
			//low��mid��highλ�õ�Ԫ�ض���ͬ
			if(array[low] == array[high] && array[mid] == array[high]){
				//˳�����
				return orderSearch(array,low,high);
			}
			//����м�λ�õ�ֵ����array[low]��ֵ��˵����Сֵ��a[mid]���ұ�
			if(array[mid] >= array[low]){
				low = mid;
			}else if(array[mid] <= array[high]){
				high = mid;
			}
		}
		return array[mid];
	}
	
	//˳�����
	private int orderSearch(int[] array, int low, int high) {
		int result = array[low];
		for(int i = low + 1; i <= high;i++){
			if(result > array[i]){
				result = array[i];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int a = new MinNumberInRotatedArray().search(new int[]{3,4,5,1,2});
		System.out.println(a);
	}
}
