package com153.FindMinimuminRotatedSortedArray;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4,5,6,7,1,2,3};
		System.out.println(findMin(nums));
	}
	
	public static  int findMin(int[] nums) {
		int len = nums.length;
		int start = 0 ; 
		int end = len-1 ;
		if(nums[start]<=nums[end]) //表示单调递增的情况
			return nums[start];
		int mid ;
		
		while(start+1<end){
			mid= (start+end)/2;
			
			if(nums[mid]>nums[start]){ //若中间的元素大于start元素，令start=min，意思就是start一直往大的数字走
				start = mid;
			}
			else if(nums[mid]<nums[end]){ //若中间的元素小于start元素，令end=min，意思就是end一直往小的数字走
				end = mid;
			}
		}
		//要求的最小元素的位置就在start的下一个，（也就是end） 因为数组是旋转的，所以最大的下一个就是最小的
		return nums[end];
    }

}
