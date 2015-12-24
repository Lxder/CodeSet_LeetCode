package com075.SortColors;

public class Solution {

	public static void main(String args[]) {
		int[] nums = { 1, 2, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1 };
		sortColors(nums);

		for (int i : nums) {
			System.out.println(i);
		}
	}

	public static void sortColors(int[] nums) {
		int len = nums.length;
		int start = 0;
		int end = len - 1;
		int[] color = { 0, 1, 2 };
		int colorlen = color.length;

		for (int i = 0; i < colorlen; i++) {
			 end = len-1;
			
			while (start < end) {
				while (start < end && nums[start] == color[i])
					start++;
				while (start < end && nums[end] != color[i])
					end--;
				Swap(nums, start, end);
			}
		}

	}

	public static void Swap(int[] nums, int start, int end) {
		int temp = nums[start];
		nums[start] = nums[end];
		nums[end] = temp;
	}
}
