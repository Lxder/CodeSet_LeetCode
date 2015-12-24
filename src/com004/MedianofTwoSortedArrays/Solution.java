package com004.MedianofTwoSortedArrays;


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1,2,3,4,5};
		int[] nums2 = {6,7,8,9,10,11};
		double media = findMedianSortedArrays( nums1, nums2);
		System.out.println(media);

	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
	    int len1 = nums1.length;
	    int len2 = nums2.length;
	    if(len1+len2==0) //两个数组长度均为0的情况
	    	return 0.0;
	    int[] nums = new int[len1+len2];
	    int i = 0;
	    int j = 0;
	    int k = 0;
		while(i<len1 && j <len2){
			if(nums1[i]<nums2[j])
				nums[k++]=nums1[i++];
			else
				nums[k++]=nums2[j++];
			
		}
		while(i<len1){
			nums[k++]=nums1[i++];
		}
		while(j<len2){
			nums[k++]=nums2[j++];
		}
		
		if(nums.length%2==1)
			return nums[nums.length/2];
		else return (nums[nums.length/2-1]+nums[nums.length/2])/2.0;
	}
}
