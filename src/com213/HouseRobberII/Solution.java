package com213.HouseRobberII;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,1,1};
		System.out.println("和:"+rob(nums));
	}

	//想法 假设nums 从0到k
	//那么求n到K-1 和 1到k这两者的的最大值 求法同原来的HouseRobber不相邻的情况
	public static int rob(int[] nums) {
		int len = nums.length;
		if(len==0) return 0;
		if(len==1) return nums[0];
		if(len==2) return Math.max(nums[0], nums[1]);
				
		return Math.max(helper(nums,0,len-1),helper(nums,1,0));
	}
	
	public static int helper(int[] nums, int start , int end){
		int len = nums.length ; 
		int[] maxv = new int[len];
		
		maxv[0] = nums[start]; //只有第一个元素情况下的最大值
		maxv[1] = Math.max(nums[start],nums[start+1]); //只有前两个元素情况下的最大值
		
		for(int i = (start+2+len)%len, n = 2 ;i != end; n++){
			maxv[n] = Math.max(maxv[n-1], maxv[n-2]+nums[i]);
			i = (i+1)%(len);
		}
				
		return maxv[len-2];
	}

}
