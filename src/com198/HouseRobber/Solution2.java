package com198.HouseRobber;

public class Solution2 {
	public static void main(String args[]) {
		int[] nums = {9,7,1,3,2,5,6,4,8};
		//int[] nums = {226,174,214,16,218,48,153,131,128,17,157,142,88,43,37,157,43,221,191,68,206,23,225,82,54,118,111,46,80,49,245,63,25,194,72,80,143,55,209,18,55,122,65,66,177,101,63,201,172,130,103,225,142,46,86,185,62,138,212,192,125,77,223,188,99,228,90,25,193,211,84,239,119,234,85,83,123,120,131,203,219,10,82,35,120,180,249,106,37,169,225,54,103,55,166,124};
		System.out.println(rob(nums));
	}

	public static int rob(int[] nums) {
		int len = nums.length;
		if(len == 0) return 0;
		if(len == 1) return nums[0];
		
		int[] maxv = new int[len];		
		maxv[0] = nums[0];
		maxv[1] = Math.max(nums[0],nums[1]);		
		for(int i = 2 ; i < len ; i++){
			maxv[i] = Math.max(maxv[i-1], maxv[i-2]+nums[i]); 
			//如果不抢第i户，那么直接用maxv[i-1],不用在意i-1户被没被抢; 如果抢这一户，则为maxv[i-2]+nums[i]
		}		
		return maxv[len-1];
	}
	
}
