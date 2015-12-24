package com162.FindPeakElement;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums =  {1,2,3,4};
		System.out.println(findPeakElement(nums));

	}

	public static int findPeakElement(int[] nums) {
		int len = nums.length;
		if(len==1) return 0;
		if(nums[0]>nums[1]) return 0;
		for(int i = 1 ; i < len-1 ; i++){
			if(nums[i]>nums[i-1]&&nums[i]>nums[i+1])
				return i;
		}
		return len-1;
		
	}

}
