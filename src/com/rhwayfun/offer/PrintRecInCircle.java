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
		// 起点坐标
		int start = 0;
		// 只要每圈的起点坐标*2小于rows和cols就继续转圈打印
		while (rows > start * 2 && cols > start * 2) {
			printReInCircle(list,matrix, rows, cols, start);
			start++;
		}
		return list;
	}

	/**
	 * 打印每一圈
	 * @param list 返回的集合
	 * @param matrix 矩阵
	 * @param rows 行数
	 * @param cols 列数
	 * @param start 起点坐标
	 */
	private void printReInCircle(ArrayList<Integer> list,int[][] matrix, int rows, int cols,
			int start) {
		
		// 矩阵的终点坐标
		int endX = rows - start - 1;
		int endY = cols - start - 1;

		// 打印从左到右的一行
		for (int i = start; i <= endY; i++) {
			list.add(matrix[start][i]);
		}

		// 打印从上到下的一列
		if (start < endX) {
			for (int j = start + 1; j <= endX; j++) {
				list.add(matrix[j][endY]);
			}
		}

		// 打印从右向左的一行
		if (start < endY && start < endX) {
			for (int k = endY - 1; k >= start; k--) {
				list.add(matrix[endX][k]);
			}
		}

		// 打印从下到上的一列
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
