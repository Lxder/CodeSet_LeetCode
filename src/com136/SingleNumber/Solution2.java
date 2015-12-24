package com136.SingleNumber;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Solution2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,2,3,3,4,4,5,5};
		System.out.println(singleNumber(nums));
	}

	public static int singleNumber(int[] nums) {
		int len = nums.length;
		int solu = 0;
		for(int i = 0 ; i < len ; i++){
			solu = solu^nums[i];
		}
		return solu;
	}

}
