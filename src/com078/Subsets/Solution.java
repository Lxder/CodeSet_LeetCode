package com078.Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4,2,3};
		
		List<List<Integer>> solu = subsets(nums);
		System.out.println(solu);
	}

	public static List<List<Integer>> subsets(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		getSubset(nums,0,nums.length,list,new ArrayList<Integer>());
		return list;
	}
	
	public static void getSubset(int[] nums,int start , int len ,List<List<Integer>> list, List<Integer> curr){
		list.add(curr);
		for(int i = start ; i < len ; i++){
			List<Integer> temp = new ArrayList<Integer>(curr);			
			temp.add(nums[i]);
			getSubset(nums,i+1,len,list,temp);
		}
	}

}
