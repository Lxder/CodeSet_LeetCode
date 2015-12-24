package com001.twosum;

import java.util.HashMap;


public class SolutionS2 {  

	public static void main(String[] args) {
		int[] nums = {-1,-2,-3,-4,-5};
		int[] solu = twoSum(nums,-8);
		System.out.println(" "+solu[0]+" "+solu[1]);

	}
    public static int[] twoSum(int[] numbers, int target) {  
    	int[] solu = new int[2];
    	int len = numbers.length;
    	HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();	
    	for(int i = 0 ; i < len ; i++){
    		Integer currn = map.get(numbers[i]);
    		if(currn == null){
    			map.put(numbers[i], i );
    		}
    		currn = map.get(target - numbers[i]) ; 
    		if(currn!=null&&currn!=i){ //注意 下标不能相同
    			solu[0] = currn+1;
    			solu[1] = i+1;
    			break;
    		}
    	}
    	
    	return solu;
    }  
}  



