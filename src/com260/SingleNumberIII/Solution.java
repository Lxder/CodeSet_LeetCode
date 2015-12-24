package com260.SingleNumberIII;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 1, 3, 2, 5};
		int[] result = singleNumber(nums);
		System.out.println(result[0]+" "+result[1]);
	}

	public static int[] singleNumber(int[] nums) {
		int[] result = { 0, 0 };
		int len = nums.length;
		int diff = 0;
		for (int i = 0; i < len; i++) {
			diff = diff ^ nums[i];
		}
		

		diff &= -diff; //得到一个为1的位
		
		for (int num : nums) {
			if ((num & diff) == 0) // the bit is not set
				result[0] ^= num;
			else // the bit is set
				result[1] ^= num;
		}
		return result;

	}

}
