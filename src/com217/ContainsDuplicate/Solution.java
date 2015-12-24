package com217.ContainsDuplicate;

import java.util.HashMap;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,1,4,5};
		System.out.println(containsDuplicate(nums));

	}

	public static boolean containsDuplicate(int[] nums) {
		int len = nums.length;
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i = 0 ; i < len ; i++){
			if(map.get(nums[i])==null)
				map.put(nums[i], 1);
			else return true;
		}
		return false;
	}
}
