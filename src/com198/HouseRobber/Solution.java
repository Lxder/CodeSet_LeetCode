package com198.HouseRobber;

public class Solution {
	public static void main(String args[]) {
		//int[] nums = {9,7,1,3,2,5,6,4,8};
		int[] nums = {226,174,214,16,218,48,153,131,128,17,157,142,88,43,37,157,43,221,191,68,206,23,225,82,54,118,111,46,80,49,245,63,25,194,72,80,143,55,209,18,55,122,65,66,177,101,63,201,172,130,103,225,142,46,86,185,62,138,212,192,125,77,223,188,99,228,90,25,193,211,84,239,119,234,85,83,123,120,131,203,219,10,82,35,120,180,249,106,37,169,225,54,103,55,166,124};
		System.out.println(rob(nums));
	}

	public static int rob(int[] nums) {
		if(nums.length==0) return 0;
		System.out.println(nums.length);
		return getMaxMoney(nums,0);
	}
	public static int getMaxMoney(int[] nums , int start){
		int len = nums.length;
		if(start == len-1)
			return nums[len-1];
		if(start == len-2)
			return Math.max(nums[len-1],nums[len-2]);	
		int sum1 = nums[start]; 
		if(start+2<len) sum1 = nums[start] + getMaxMoney(nums,start+2);
		int sum2 = nums[start+1]; 
		if(start+3<len) sum2 = nums[start+1] + getMaxMoney(nums , start+3);
		return Math.max(sum1, sum2);
	}
}
