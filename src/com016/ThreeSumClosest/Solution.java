package com016.ThreeSumClosest;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] S = {-1, 2, 1, -4};
		int[] S = {1,1,-1,-1,3};
		System.out.println(threeSumClosest(S,3));
	}

	
	//Return the sum of the three integers. 
	//You may assume that each input would have exactly one solution.
	public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int len = nums.length;
		
		int start ,end; 
		int sum ;
		
		int closest = Integer.MAX_VALUE;
		int closum = 0;
		
		for(int i = 0 ; i < len-2 ; i++){
			start = i+1; end = len -1 ;
			while(start<end){ 
				sum = nums[i]+nums[start]+ nums[end];
				if(Math.abs(sum-target)<closest){
					closest  = Math.abs(sum-target);
					closum = sum;
				}			
				
				if(sum > target) end--;				
				else if(sum < target) start++;
				else{ 
	                return target;
				}				
			}
		}
		
	    return closum;
	}

}
