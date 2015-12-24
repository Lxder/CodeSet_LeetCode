package com236.SlidingWindowMaximum;


public class Solution {

	public static void main(String args[]){
		//int[]  nums = {1,3,-1,-3,5,3,6,7};
		int[] nums = {1,-1};
		int[] solu = maxSlidingWindow(nums,1);
		for(int i  = 0 ; i < solu.length ; i++){
			System.out.println(solu[i]);
		}
	}
	
	//时间复杂度不满足
	public static int[] maxSlidingWindow(int[] nums, int k) {
		if(nums==null||k==0) return new int[0];
        int[] solu = new int[nums.length-k+1];
        int currmax = Integer.MIN_VALUE;
        for(int i = 0 ;i < k ; i++){
        	if(nums[i]>currmax)
        		currmax = nums[i];
        }
        solu[0] = currmax;
        int rear = 1;
        int front = k;
        while(front< nums.length){
        	if(nums[front]>currmax) {
        		currmax = nums[front];
        		solu[rear] = currmax;
        	}
        	else if(nums[rear-1]==currmax){
        		currmax= Integer.MIN_VALUE;
        		for(int i = rear ;i <= front ; i++){
                	if(nums[i]>currmax)
                		currmax = nums[i];
                }
        		solu[rear]=currmax;
        	}else {
        		solu[rear] = currmax;
        	}
        	
        	rear++;
        	front++;
        
        }
        
        return solu;
    }
}
