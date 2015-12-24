package com046.Permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
	public static void main(String args[]) {
		int[] nums = {2,1,3};
		List<List<Integer>> list = permute(nums);
		System.out.println(list);
	}


	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> solu = new ArrayList<List<Integer>>();
	    if(nums.length==0)
	        return solu;
	    dfs(0,nums,solu);
	    return solu;
	}

	public static void dfs(int i, int[] nums,List<List<Integer>>  result){
		if(i==nums.length) {  
			addlist(result,nums,nums.length);
            return;  
        }  
        for(int j=i;j<nums.length;j++) {  
        	Swap(nums,i,j);
            dfs(i+1,nums,result);  
            Swap(nums,i,j);  
        }  
	}
	
	public static void addlist(List<List<Integer>> solu , int[] nums,int len){
		List<Integer> list = new ArrayList<Integer>();		    
	    for(int i = 0 ; i < len ; i++){
	    	list.add(nums[i]);
	    }
	    solu.add(list);
	}
	public static void Swap(int[] nums, int i , int j ){
	    int temp = nums[i];
	    nums[i] = nums[j];
	    nums[j] = temp;
	}

	public static void InvertArray(int[] nums, int start , int end){
	    int temp;
	    while(start<end){
	        temp = nums[start];
	        nums[start] = nums[end];
	        nums[end] = temp;
	        start++; end--;
	    }
	}
}
