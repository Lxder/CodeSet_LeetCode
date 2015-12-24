package com136.SingleNumber;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,2,3,3,4,4,5,5};
		System.out.println(singleNumber(nums));
	}

	public static int singleNumber(int[] nums) {
		HashMap<Integer,Integer> map = new HashMap();
		int len = nums.length;
		for(int i = 0 ; i < len ; i++){
			if(map.get(nums[i])!=null)
				map.remove(nums[i]);
			else 
				map.put(nums[i], 1);
		}
		Set set = map.keySet();
		Iterator itr = set.iterator();
		return (int)itr.next();
	}

}
