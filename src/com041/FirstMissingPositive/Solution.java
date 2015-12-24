package com041.FirstMissingPositive;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,3};
		System.out.println(firstMissingPositive(nums));

	}

	public static int firstMissingPositive(int[] nums) {		
		int len = nums.length;
		if(len==0) return 1;
		int i = 0;	
		int temp;
		int before;
		while(i< len){
			if(nums[i] != i+1&&nums[i]>0){ //把太大的直接忽略
				if(nums[i]>len){i++;continue;}
				temp = nums[nums[i]-1];
				before = nums[i];
				nums[nums[i]-1] = nums[i];
				nums[i] = temp;				
				if(before == temp) i++;
			}else
				i++;		
		}
		
		for(i = 0 ; i < len ; i++){
			if(nums[i]!=i+1) break;
		}
		return i+1;				
	}

}
