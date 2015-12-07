package com.rhwayfun.offer;

public class ReOrderOddAndEvenArray {
	
	public void reOrderArray(int[] array) {
		if(array == null || array.length == 0) return;
		
		int evenIndex = 0;
		int oddIndex = array.length - 1;
		while(evenIndex < oddIndex){
			while(evenIndex < oddIndex && (array[evenIndex] & 0x1) != 0){
				evenIndex++;
			}
			while(evenIndex < oddIndex && (array[oddIndex] & 0x1) == 0){
				oddIndex--;
			}
			//���ָ��ż����ָ������ָ������ָ���ǰ�棬�򽻻���������ֵ
			if(evenIndex < oddIndex){
				swap(array,evenIndex,oddIndex);
			}
		}
	}
	
	public void reOrderArray2(int[] array) {
		if(array == null || array.length == 0) return;
		int i,j;
		for (i  = 1; i < array.length; i++) {
			int temp = array[i];
			//���������,ǰ�������ż������λ
			if(!isEven(array[i])){
				for(j = i - 1; j >= 0 && isEven(array[j]); j--){
					array[j + 1] = array[j];
				}
				array[j + 1] = temp;
			}
		}
	}

	//�ж�һ�����Ƿ���ż��
	private boolean isEven(int i) {
		if((i & 0x1) == 0) return true;
		return false;
	}

	private void swap(int[] array, int evenIndex, int oddIndex) {
		int temp = array[evenIndex];
		array[evenIndex] = array[oddIndex];
		array[oddIndex] = temp;
	}
	
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7};
		new ReOrderOddAndEvenArray().reOrderArray2(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
}
