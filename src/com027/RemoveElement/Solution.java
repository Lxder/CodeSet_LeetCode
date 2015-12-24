package com027.RemoveElement;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1,  7,1,2,3,4,5};
		int len = removeElement(nums,7);
		System.out.println("³¤¶È£º"+len);
		for (int i = 0; i < len; i++) {
			System.out.println(nums[i]);
		}
	}

	public static int removeElement(int[] nums, int val) {
		int len = nums.length;
		if(len==0 )
			return 0;
		int newlen = len;
		int i = 0 ; 
		int j = 1;
		while(j < len){
			if(nums[i]==val){
				newlen --;				
			}else{
				i++;
			}
			nums[i]=nums[j];
			j++;
		}		
		if(nums[len-1]==val)
			newlen--;
		if(newlen==1&&nums[0]==val)
			return 0;
		return newlen;
	}

}
