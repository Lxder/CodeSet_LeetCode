package com287.FindtheDuplicateNumber;

public class Solution {
	public static void main(String args[]){
		int[] nums = {1,3,4,7,2,6,5,4};
		System.out.println(findDuplicate(nums));
	}
	
	//不满足题意  题目要求时间复杂度小于O(n*n)
    public static int findDuplicate(int[] nums) {
    	int len = nums.length;
    	for(int i = 0 ; i < len ; i++){
    		int curr = nums[i];
    		for(int j = i+1 ; j < len ; j++){
    			if(curr == nums[j]){
    				
    				return curr;
    			} 
    		}
    	}
    	return 0;
        
    }
}