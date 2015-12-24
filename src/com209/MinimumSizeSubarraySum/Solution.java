package com209.MinimumSizeSubarraySum;


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {2,3,1,2,4,3};
		System.out.println(minSubArrayLen(120331635,nums));
	}

	public static int minSubArrayLen(int s, int[] nums) {
		int len = nums.length;
		int[][] sum = new int[len][len];
		for(int i = 0 ; i < len ;i++){
			sum[i][i] = nums[i];
		}
		for(int i =1 ; i < len ; i++){
			for(int j = 0 ; j+i < len ; j++){
				sum[j][j+i]= sum[j][j+i-1]+nums[i+j];
				if(sum[j][j+i]>=s)					
					return i+1;
			}
		}
		
		return 0;
	}

}
