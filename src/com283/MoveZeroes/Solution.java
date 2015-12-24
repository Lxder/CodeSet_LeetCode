package com283.MoveZeroes;

public class Solution {
	public static void main(String args[]){
		int[] nums = {2,0, 1,0,0,0, 0, 3, 12};
		moveZeroes(nums);
		for(int i : nums){
			System.out.println(i);
		}
	}

	public static void moveZeroes(int[] nums) {
		int len = nums.length;
		
		
		int curr = 0;
		
		for(int i = 0 ; i< len ; i++){
			if(nums[i]!=0)
				nums[curr++]=nums[i];
		}
		for(int i = curr ; i < len ; i++){
			nums[i]=0;
		}
	}
}
