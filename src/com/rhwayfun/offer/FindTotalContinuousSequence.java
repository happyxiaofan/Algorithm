package com.rhwayfun.offer;

import java.util.ArrayList;

public class FindTotalContinuousSequence {

	public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> sqList = new ArrayList<ArrayList<Integer>>();
		if(sum < 3) return sqList;
		int small = 1;
		int big = 2;
		int curSum = small + big;
		//����middle������ԭ����������ڵ�ǰ�ܺ�С��sum������£�
		//small�����ӵ�sum��һ��Ĺ����п϶������sum
		int middle = (1 + sum) / 2;
		while(small < middle){
			ArrayList<Integer> sq = new ArrayList<Integer>();
			if(curSum == sum){
				for (int i = small; i <= big; i++) {
					sq.add(i);
				}
			}
			while(curSum > sum && small < middle){
				curSum -= small;
				small++;
				if(curSum == sum){
					for (int i = small; i <= big; i++) {
						sq.add(i);
					}
				}
			}
			if(sq.size() > 0) sqList.add(sq);;
			big++;
			curSum += big;
		}
		
		return sqList;
    }
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> list = new FindTotalContinuousSequence().FindContinuousSequence(15);
		for (ArrayList<Integer> arrayList : list) {
			System.out.println(arrayList);
		}
	}
}
