package com045.JumpGameII;

public class Solution {

	public static void main(String args[]){
		int[] nums = {5,9,3,2,1,0,2,3,3,1,0,0};
		
		System.out.println(jump(nums));
	}
	
	public static int jump(int[] A) {
	    int maxReach = A[0];
	    int edge = 0;
	    int minstep = 0;
	    
	    for(int i = 1; i < A.length; i++) {
	        if (i > edge) {
	            minstep += 1;
	            edge = maxReach;
	            if(edge > A.length - 1)
	                return minstep;
	        }
	        
	        //下面3行可以去掉
	        maxReach = Math.max(maxReach, A[i] + i);
	        if (maxReach == i && maxReach!=A.length-1){
	        	return -1;
	        }
	            
	    }
	    
	    return minstep;
	} 
	
////////////////////方法
	public static int jump1(int[] nums) {
		int step = 0;
		for (int l = 0, r = 0; r < nums.length - 1; step++) {
			int rNew = 0;
			for (int i = l; i <= r; i++)
				rNew = Math.max(rNew, i + nums[i]);
			l = r + 1;
			r = rNew;
		}
		return step;
	}
	
	
//////////////////方法2： 采用递归/////////////////////超时！！！！///////////
	static int maxlen = Integer.MAX_VALUE;
	public static int jump2(int[] nums) {		
		helper(nums,0,0);
		return maxlen;
	}
	
	
	public static  void helper(int[] nums , int start ,int len ){
		if(len+1>maxlen) return;
		if(start >= nums.length-1) {
			System.out.println("len = "+len+"-----over-----");
			if(len<maxlen) maxlen = len;
			return;
		}
		
		int end =Math.min(start + nums[start],nums.length-1);		
		for(int i = end ;i>start ; i--){
			//System.out.println("当前位置："+i);			
			helper(nums,i,len+1);
		}
	}
}
