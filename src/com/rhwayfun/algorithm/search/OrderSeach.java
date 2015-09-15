package com.rhwayfun.algorithm.search;

import com.rhwayfun.algorithm.linkedlist.DefaultStrategy;
import com.rhwayfun.algorithm.linkedlist.Strategy;

public class OrderSeach {

	private Strategy deStrategy;
	
	public OrderSeach(){
		this.deStrategy = new DefaultStrategy();
	}
	
	public boolean seach(int[] arr,int value){
		for (int i : arr) {
			if(deStrategy.equal(i, value)){
				return true;
			}
		}
		return false;
	}
}
