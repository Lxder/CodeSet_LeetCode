package com080.RemoveDuplicatesfromSortedArrayII;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]  nums = {1,1,1,1,1,2,2,2,3,3,3,4,4,4};
		int len = removeDuplicates(nums);
		
		for(int i = 0 ; i < len  ; i++){
			System.out.println(nums[i]);
		}
		
	}

	public static int removeDuplicates(int[] nums) {
		int len = nums.length;
		int newlen = len;
		int i = 0 ;
		int j = 1;
		int k = 2;
		boolean flag = false;
		while(k<len){
			if(nums[i]==nums[j]){
				if(flag==true){
					newlen--;
					nums[j]=nums[k];
				}else{
					j++;
					nums[j] = nums[k];
					flag = true;

				}
			}else{

				flag = false;
				i = j ; j = i+1 ;
				nums[j] = nums[k];
			}
			k++;
		}
		if(flag == true && nums[len-1]==nums[j-1])
			newlen--;
		return newlen;
	}
//	
//	public static int removeDuplicates(int[] nums) {
//		int len = nums.length;
//		int newlen = len;
//		int i = 0 ;
//		int j = 1;
//		boolean flag = false;
//		while(j<len){
//			if(nums[i]==nums[j]){
//				if(flag==true){
//					newlen--;
//				}else{
//					flag = true;
//				}
//			}else{
//				flag = false;
//			}
//			i++;
//			j++;
//		}
//		return newlen;
//	}

}
