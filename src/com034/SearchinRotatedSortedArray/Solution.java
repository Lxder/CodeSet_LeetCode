package com034.SearchinRotatedSortedArray;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {5,7,7,8,8,10};
		int[] solu = searchRange(nums,8);
		System.out.println(solu[0]+" , "+solu[1]);
	}

	public static int[] searchRange(int[] nums, int target) {
		int len = nums.length;
		int start = 0 ;
		int end = len -1 ;
		int mid = 0 ;
		while(start <= end ){
			mid = start+(end-start)/2;
			if(nums[mid]>target)
				end = mid -1 ;
			else if(nums[mid]<target)
				start = mid+1;
			else break;
		}
		if(start> end)
			return new int[] {-1,-1};
		start = mid ; end = mid+1;
		while(start>=0 &&nums[start]==nums[mid])
			start--;
		while(end<len && nums[end]==nums[mid])
			end++;
		return new int[] {++start,--end};
		

	}
}
