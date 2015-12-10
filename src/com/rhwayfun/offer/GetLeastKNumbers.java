package com.rhwayfun.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

public class GetLeastKNumbers {
	
	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(input == null || k <= 0 || input.length == 0 || k > input.length) return list;
		for (int i = 0; i < input.length; i++) {
			list.add(input[i]);
		}
		Collections.sort(list);
		if(k >= input.length){
			return list;
		}
		while(list.size() > k){
			list.remove(k);
		}
		return list;
	}
	
	public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(input == null || k <= 0 || input.length == 0 || k > input.length) return list;
		//����һTreeSet���ϣ���ΪTreeSetĬ�Ͼ��Ǵ�С���������
		TreeSet<Integer> s = new TreeSet<Integer>();
		for (int i = 0; i < input.length; i++) {
			if(s.size() < k){
				s.add(input[i]);
			}else{
				if(input[i] < s.last()){
					s.remove(s.last());
					s.add(input[i]);
				}
			}
		}
		//ѭ��������s���Ѿ�������ǰk����С������ֻ��Ҫ��������ArrayList�м���
		Iterator<Integer> it = s.iterator();
		while(it.hasNext()){
			list.add(it.next());
		}
		return list;
	}
	
	public static void main(String[] args) {
		int[] input = new int[]{4,5,1,6,2,7,3,8};
		ArrayList<Integer> list = new GetLeastKNumbers().GetLeastNumbers_Solution2(input, 4);
		System.out.println(list);
	}
}
