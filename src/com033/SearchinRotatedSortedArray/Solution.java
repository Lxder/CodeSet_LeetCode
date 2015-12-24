package com033.SearchinRotatedSortedArray;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {5,1};
		System.out.println(search(nums,5));
	}

	public static int search(int[] nums, int target) {
		int len = nums.length;
		if(len==0) return -1;

		int start = 0 ;
		int end = len-1;
		int mid;
		while(start <= end){
			mid = (start+end)/2;
			if(nums[mid]==target)
				return mid;
			if(nums[mid]>=nums[start]){
				if(target>=nums[start]&&target<=nums[mid])
					end = mid-1;
				else
					start = mid+1;
			}
			else if(nums[mid]<=nums[end]){
				if(target>=nums[mid]&&target<=nums[end])
					start = mid+1;
				else	
					end = mid-1;
			}
		}
		return -1;
	}

}
