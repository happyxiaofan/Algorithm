package com.rhwayfun.offer;

public class ConstructMultipleArray {

	/**
	 * ����˼·�ǰ�ǰ�벿�����벿�ֵĽ�����浽��ͬ��������
	 * @param A
	 * @return
	 */
	public int[] multiply(int[] A) {
		int n = A.length;
		//front[i]���Ǵ�A[0]...��A[i - 1]��ֵ
		int[] front = new int[n];
		//�쳣����
		if(n <= 1) return front;
		/* back[i]���Ǵ�A[i + 1]...��A[n - 1]��ֵ
		 * back����ĵ�һλ�����һλ��ʼ������back[n - 1]=1
		 */
		int[] back = new int[n];
		front[0] = back[n - 1] = 1;
		//�ֱ����ǰ�벿�����벿�ֵ�ֵ�����ֱ𽫽��������front��back������
		for(int i = 1; i < n; i++){
			front[i] = front[i - 1] * A[i - 1];
			back[n - 1 - i] = back[n - i] * A[n - i];
		}
		//�������������ٴ���˵õ����Ľ��
		for(int i = 0; i < n; i++){
			front[i] *= back[i];
		}
		//���ص�front���鼴Ϊ����
		return front;
    }
	
	
	public static void main(String[] args) {
		int[] A ={1,2,3,4};
		int[] r = new ConstructMultipleArray().multiply(A);
		for (int i : r) {
			System.out.print(i + " ");
		}
	}
}
