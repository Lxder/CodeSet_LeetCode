package com238.ProductofArrayExceptSelf;

public class Solution {
	
	public static void main(String args[]){
		int[] nums = {1,2,3,4};
		int[] solu = productExceptSelf(nums);
		for(int i = 0 ; i < solu.length ; i++)
			System.out.println(solu[i]);
	}
	public static int[] productExceptSelf(int[] nums) {
		int len = nums.length;
		int[] arr1 = new int[len];
		int[] arr2 = new int[len];
		arr1[0] = 1;
		arr2[len-1] = 1;
		for(int i = 1 ;i < len ; i++){
			arr1[i]=arr1[i-1] * nums[i-1]; //第i个元素代表前i-1个数字的乘积
			arr2[len-1-i]=arr2[len-i] * nums[len-i];
		}
		
		int[] solu = new int[len];
		for(int i = 0 ; i < len ; i++){
			solu[i]= arr1[i]*arr2[i];
		}
		return solu;
	}
}
