package com.rhwayfun.offer;

import java.util.ArrayList;

public class PrintRecInCircle {

	public ArrayList<Integer> printMatrix(int[][] matrix) {
		if(matrix == null || matrix.length <= 0 || matrix[0].length <= 0){
			return null;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		int rows = matrix.length;
		int cols = matrix[0].length;
		// �������
		int start = 0;
		// ֻҪÿȦ���������*2С��rows��cols�ͼ���תȦ��ӡ
		while (rows > start * 2 && cols > start * 2) {
			printReInCircle(list,matrix, rows, cols, start);
			start++;
		}
		return list;
	}

	/**
	 * ��ӡÿһȦ
	 * @param list ���صļ���
	 * @param matrix ����
	 * @param rows ����
	 * @param cols ����
	 * @param start �������
	 */
	private void printReInCircle(ArrayList<Integer> list,int[][] matrix, int rows, int cols,
			int start) {
		
		// ������յ�����
		int endX = rows - start - 1;
		int endY = cols - start - 1;

		// ��ӡ�����ҵ�һ��
		for (int i = start; i <= endY; i++) {
			list.add(matrix[start][i]);
		}

		// ��ӡ���ϵ��µ�һ��
		if (start < endX) {
			for (int j = start + 1; j <= endX; j++) {
				list.add(matrix[j][endY]);
			}
		}

		// ��ӡ���������һ��
		if (start < endY && start < endX) {
			for (int k = endY - 1; k >= start; k--) {
				list.add(matrix[endX][k]);
			}
		}

		// ��ӡ���µ��ϵ�һ��
		if (start < endY && start < endX - 1) {
			for (int m = endX - 1; m >= start + 1; m--) {
				list.add(matrix[m][start]);
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = new int[1][5];
		matrix[0] = new int[]{1,2,3,4,5};
		/*matrix[1] = new int[]{5,6,7,8,15};
		matrix[2] = new int[]{9,10,11,12,19};
		matrix[3] = new int[]{13,14,15,16,23};
		matrix[4] = new int[]{17,18,19,20,21};*/
		
		PrintRecInCircle p = new PrintRecInCircle();
		ArrayList<Integer> list = p.printMatrix(matrix);
		for (Integer integer : list) {
			System.out.print(integer+" ");
		}
	}
}
