package com053.MaximumSubarray;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums));
	}

	public static int maxSubArray(int[] nums) {
		int sum = Integer.MIN_VALUE;
		int maxsum = Integer.MIN_VALUE;
		int len = nums.length;
		for(int i = 0 ; i<len ; i++){
			if(sum<0){
				sum = nums[i];
			}else{
				sum = sum + nums[i];
			}
			if(sum>maxsum)
				maxsum = sum;
		}
		
		return maxsum;
	}

}
