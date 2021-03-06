package com154.FindMinimuminRotatedSortedArrayII;

public class Solution2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] nums = { 4, 5, 6, 6,6,6,6,6,6,7,7,7,7,1,1,1,1,1,1,1,1,1,1,1,1,1, 1,1, 2, 3 };
		int[] nums = { 3,1,3,3,3};
		System.out.println(findMin(nums));
	}

	public static int findMin(int[] nums) {
		int len = nums.length;
		int start = 0;
		int end = len - 1;
		if (nums[start] < nums[end]) // 表示单调递增的情况
			return nums[start];
		int mid = 0;

		while (start + 1 < end) {
			while(start<len-1&&nums[start]==nums[start+1])
				start++;
			while(end>0&&nums[end]==nums[end-1])
				end--;
			mid = (start + end) / 2;

			if (nums[mid] > nums[start]) {
				start = mid;
			} else if (nums[mid] < nums[end]) {
				end = mid;
			}


			
		}		

		return nums[end];
	}
}
