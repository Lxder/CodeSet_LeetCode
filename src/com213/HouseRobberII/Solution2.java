package com213.HouseRobberII;

public class Solution2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,1};
		System.out.println("��:"+rob(nums));
	}

	//�뷨 ����nums ��0��k
	//��ô��n��K-1 �� 1��k�����ߵĵ����ֵ ��ͬԭ����HouseRobber�����ڵ����
	public static int rob(int[] nums) {
		int len = nums.length;
		if(len==0) return 0;
		if(len==1) return nums[0];				
		return Math.max(helper(nums,0,len-1),helper(nums,1,0));
	}
	
	public static int helper(int[] nums, int start , int end){
		int p = 0, q = 0;
	    for (int i = start; i != end; /* do nothing */) {
	        int tmp = p;
	        p = Math.max(p, q + nums[i]);
	        q = tmp;
	        i = (i + 1) % nums.length;
	    }
	    return p;
	}
	
	
	

}
