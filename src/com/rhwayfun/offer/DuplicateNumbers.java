package com.rhwayfun.offer;

import java.util.HashMap;
import java.util.Map;

public class DuplicateNumbers {

	// Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
		//异常处理
    	if(numbers == null || numbers.length <= 1 || length <= 1) return false;
    	//创建一个HashMap保存每个数字出现的次数
    	Map<Integer,Integer> counter = new HashMap<Integer, Integer>();
    	for(int i = 0; i < length; i++){
    		if(counter.containsKey(numbers[i])){
    			duplication[0] = numbers[i];
    			return true;
    		}else{
    			counter.put(numbers[i], new Integer(1));
    		}
    	}
    	return false;
    }
    
    public static void main(String[] args) {
		int [] numbers = {-1,4,1,0,2,5,3};
		boolean f = new DuplicateNumbers().duplicate(numbers, 7, new int[1]);
		System.out.println(f);
	}
}
