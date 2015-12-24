package com001.twosum;

import java.util.Hashtable;


public class Solution2 {

	public static void main(String[] args) {
		int[] nums = {-1,-2,-3,-4,-5};
		int[] solu = twoSum(nums,-8);
		System.out.println(" "+solu[0]+" "+solu[1]);

	}
	
	public static int[] twoSum(int[] nums, int target) {
        int[] solu = new int[2];
        
        Hashtable<Integer, Integer> nums_table = new Hashtable<Integer,Integer>();
        int len = nums.length;
        for(int i = 0 ; i < len ; i++){
        	Integer n = nums_table.get(nums[i]);
        	if(n==null){
        		nums_table.put(nums[i], i);
        	}
        	n = nums_table.get(target-nums[i]); //获取index
        	if(n!=null&&n<i){
        		solu[0]= n+1 ; //小的index
        		solu[1]= i+1;
        		break;
        	}
        }
        
        return solu;
    }

}
