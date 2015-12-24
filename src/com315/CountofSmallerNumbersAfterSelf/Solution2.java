package com315.CountofSmallerNumbersAfterSelf;

import java.util.ArrayList;
import java.util.List;

//暴力解决，超时！！！
public class Solution2 {
	
	public static void main(String args[]){
		int[] nums = {5,2,6,1};
		System.out.println(countSmaller(nums));
	}
    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> solu = new ArrayList<Integer>();
    	int len = nums.length;
    	if(len == 0 ) return solu;
    	int[] dp = new int[len];
    	dp[len-1] = 0;
    	
    	for(int i = len-2 ; i >= 0 ; i--){
    		int num = 0;
    		for(int j = i+1 ; j < len ; j++){
    			if(nums[j]<nums[i]) num++;
    		}
    		dp[i] = num;
    	}
        for(int i = 0 ; i < len ; i++){
        	solu.add(dp[i]);
        }
        return solu;
    }
}