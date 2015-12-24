package com300.LongestIncreasingSubsequence;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	
	public static void main(String args[]){
		int[] nums = { 10, 9, 2, 4, 5, 3, 1, 7, 101, 18 };
		System.out.println("结果1："+lengthOfLIS(nums));
		
		System.out.println("结果2："+lengthOfLIS2(nums));
		
	}
	//时间复杂度O(n^2)
    public static int lengthOfLIS(int[] nums) {
    	int len = nums.length;
    	if(len==0) return 0;
    	int[] sarr = new int[len];
    	sarr[len-1] = 1;
    	for(int i = len-2 ; i>=0 ; i--){
    		sarr[i] = 1;
    		for(int j = i+1 ; j < len ; j++){
    			if(nums[i]<nums[j]){
    				sarr[i] = Math.max(sarr[i], sarr[j]+1);
    			}
    		}
    	}
    	
    	int solu = 0;
    	for(int i = 0; i < len ; i++){
    		if(sarr[i]>solu) solu = sarr[i];
    	}
    	return solu;
    }
    //{ 10, 9, 2, 4, 5, 3, 1, 7, 101, 18 };
    
    //时间复杂度O(nlog(n))
    //dp[i]表示长度为i+1的递增子数组的最后一个元素的最小值
    public static int lengthOfLIS2(int[] nums) {
		ArrayList<Integer> dp = new ArrayList<>(nums.length);
		//注：dp内的元素是有序的
		for (int num : nums) {
			//如果当前元素大于dp内最后一个元素，则直接添加到后面
			if (dp.size() == 0 || dp.get(dp.size() - 1) < num){ 
				dp.add(num);
			} else {
				//确定元素要覆盖的位置
				int i = Collections.binarySearch(dp, num);
				if(i<0){ //i<0 说明dp内没有这个元素
					i = -(i+1); //-(i+1)为插入位置
					dp.set(i, num); //后面的值比前面小，应该替换，将值覆盖
				}				
			}
			System.out.println(dp); 
		}
		return dp.size(); //注意！！dp内保存的不是最终的递增数组
    }
}