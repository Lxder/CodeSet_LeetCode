package com034.SearchinRotatedSortedArray;

public class Solution2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {5};
		int solul = searchl(nums,8);
		int solur = searchr(nums,8);
		
		System.out.println(solul+" "+solur);
	}

	public static int[] searchRange(int[] nums, int target) {

		int sl = searchl(nums,target);
		int sr = searchr(nums,target);
		return new int[] {sl,sr};
	}
	
	public static int searchl(int[] nums, int target){
		int len = nums.length;
		int start = 0 ;
		int end = len -1 ;
		int mid = 0 ;
		while(start <= end ){
			mid = (end+start)/2;
			if(nums[mid]<target)
				start = mid+1; //mid元素小于target，可以令start=mid+1
			else
				end = mid-1 ;
		}
		
		if(len==0||start>=len||nums[start]!=target) return -1;
		return start;
		
	}
	
	public static int searchr(int[] nums, int target){
		int len = nums.length;
		int start = 0 ;
		int end = len -1 ;
		int mid = 0 ;
		while(start <= end ){
			mid = (end+start)/2;
			if(nums[mid]>target)
				end = mid-1 ;
			else 
				start = mid+1;
		}
		if(len==0||end<0||nums[end]!=target) return -1;
		return end;
		
	}
}
