package com035.SearchInsertPosition;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,3,5,6};
		System.out.println(searchInsert(nums,0));
	}

	public static int searchInsert(int[] nums, int target) {
		int len = nums.length;
		int low = 0 ; 
		int high = len-1;
		int mid;
		while(low<=high){
			mid = (low+high)/2;
			if(nums[mid]>=target)
				high = mid -1;
			else low = mid+1;				
		}
		return low;
	}

}
