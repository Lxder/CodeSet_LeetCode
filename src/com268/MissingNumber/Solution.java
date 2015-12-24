package com268.MissingNumber;

public class Solution {
	
	public static void main(String args[]){
		int[] nums = {};
		System.out.println(missingNumber(nums));
	}
	
	public static int missingNumber(int[] nums) {
		int len = nums.length;
		int sum = 0 ;
		for(int i = 0 ; i < len ; i++){
			sum +=nums[i];
		}
		System.out.println(sum);
		
		return (1+len)*len/2 - sum;
				
	}
}
