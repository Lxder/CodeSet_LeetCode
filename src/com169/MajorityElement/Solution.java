package com169.MajorityElement;

public class Solution {
	public static void main(String args[]) {
		int[] nums ={2,3,5,5,5,6};
		System.out.println(majorityElement(nums));
	}

	public static int majorityElement(int[] nums) {
		int candidate = 0 ;
		int ntimes = 0;
		int len = nums.length;
		for(int i = 0 ; i < len ; i++){
			if(ntimes==0){
				candidate = nums[i];
				ntimes=1;
			}else{
				if(nums[i]!=candidate){
					ntimes--;
				}else
					ntimes++;
			}
		}
		return candidate;
	}
}
