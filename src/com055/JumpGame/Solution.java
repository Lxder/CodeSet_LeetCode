package com055.JumpGame;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,5,0,0};
		System.out.println(canJump(nums));
	}

	//不能通过，特殊情况的时候超时！！！！！！！！！！！！！！！！！！！！！
	public static boolean canJump(int[] nums) {
		if(nums ==null) return false;
		if(nums.length==1) return true;
		
		int end = nums.length; //最后的位置helper
		
		
		return helper(nums,0,end-1);
		
	}
	
	public static boolean helper(int[] nums,int start, int sum ){
		
		if(nums[start]>=sum) return true;
		else{
			int temp = nums[start];
			for(int i = temp ; i>0 ; i--){
				if(true==helper(nums,start+i,sum-i))
					return true;
			}
			return false;
		}
		
	}

}
