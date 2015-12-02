package com.rhwayfun.algorithm.sort;

/**
 * �鲢����
 * @author Administrator
 *
 */
public class MergeSort2 {

	public void mergeSort(int[] a){
		mSort(a,a,0,a.length - 1);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	private void mSort(int[] b, int[] a, int i, int j) {
		int m = 0;
		int[] c = new int[a.length];
		if(i == j){//�ݹ���ֹ����
			a[i] = b[i];
		}else {
			m = (i + j)/2;
			//������a��Ϊa[i...m]����������
			mSort(b,c,i,m);
			//����a[m+1...j]���ֽ�������
			mSort(b, c, m + 1, j);
			//��a[i...m]���ֺ�a[m+1...j]���ֵ��������鲢��a
			merge(c,a,i,m,j);
		}
	}

	private void merge(int[] b, int[] a, int i, int m, int t) {
		int j = 0,k = 0,l = 0;
		for(j = m+1,k = i;i <= m && j<=t;k++){
			//��b�м�¼��С����鲢��a��
			if(b[i] < b[j]){
				a[k] = b[i++];
			}else {
				a[k] = b[j++];
			}
		}
		//��ʣ��b[i...m]���Ƶ�a��
		if(i<=m){
			for(l=0;l<=m-i;l++){
				a[k+l]=b[i+l];
			}
		}
		//��ʣ��b[m+1...t]���Ƶ�����a��
		if(j<=t){
			for(l=0;l<=t-j;l++){
				a[k+l]=b[j+l];
			}
		}
	}
	
	public static void main(String[] args) {
		new MergeSort2().mergeSort(new int[]{50,10,90,30,70,40,80,60,20});
	}
}
