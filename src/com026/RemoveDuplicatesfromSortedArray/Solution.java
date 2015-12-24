package com026.RemoveDuplicatesfromSortedArray;

public class Solution {

	public static void main(String args[]) {
		// int[] nums = {1,1,2,3,4,5,6,6,7};
		int[] nums = { 1, 1, 1, 2, 3, 4, 5, 6, 6, 7, 7 };
		System.out.println(removeDuplicates(nums));
		for (int i = 0; i < 7; i++) {
			System.out.println(nums[i]);
		}
	}

	public static int removeDuplicates(int[] nums) {
		int len = nums.length;
		if (len == 0)
			return 0;
		int newlen = 1;
		int i = 0;
		int j = i + 1;
		while (j < len) {
			if (nums[i] != nums[j]) {
				i++;
				nums[i] = nums[j];
				newlen++;
			}
			j++;
		}
		return newlen;
	}
}
