package com219.ContainsDuplicateII;

import java.util.HashMap;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i = 0 ; i < len ; i++){
			Integer temp = map.get(nums[i]);
			if(temp!=null&&(i-temp<=k))
				return true;
			map.put(nums[i], i);
		}
		return false;
    }

}
