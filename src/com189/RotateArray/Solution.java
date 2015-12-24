package com189.RotateArray;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums3 = { -1,2};
		rotate(nums3, 3);
		for (int i = 0; i < nums3.length; i++) {
			System.out.print(nums3[i] + " ");
		}

	}

	public static void rotate(int[] nums, int k) {
		int len = nums.length;
		if(len==0||len==1)
			return;
		k = k%len;
		Reverse(nums, 0, len - k - 1);
		Reverse(nums, len - k, len - 1);
		Reverse(nums, 0, len - 1);
	}

	public static void Reverse(int[] nums, int left, int right) {
		while (left < right) {
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
			left++;
			right--;
		}
	}
}
