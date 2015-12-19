package com.rhwayfun.offer;

import java.util.ArrayList;

public class MedianNum {

	ArrayList<Integer> list = new ArrayList<Integer>();

	public void Insert(Integer num) {
		int index = 0;
		int size = list.size();
		while (index < size) {
			if (num <= list.get(index))
				break;
			index++;
		}
		list.add(index, num);
	}

	public Double GetMedian() {
		int size = list.size();
		if ((size & 1) == 0)
			return (double) ((list.get(size / 2) + list.get(size / 2 - 1)) / 2.0);
		return (double)list.get(size / 2) * 1.0;
	}
	
	public static void main(String[] args) {
		MedianNum s = new MedianNum();
		s.Insert(1);
		s.Insert(5);
		s.Insert(0);
		s.Insert(4);
		s.Insert(3);
		s.Insert(2);
		
		Double d = s.GetMedian();
		System.out.println(d.doubleValue());
	}
}
