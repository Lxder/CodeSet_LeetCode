package com179.LargestNumber;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,0};
		System.out.println(largestNumber(nums));
		
	}
	
	
	public static String largestNumber(int[] nums) {
		int len = nums.length;
		int temp;
		for(int i = 0 ; i < len ; i++){
			for(int j = i+1 ; j < len ; j++){
				String s1 = String.valueOf(nums[i]);
				String s2 = String.valueOf(nums[j]);
				String ss1 = s1+s2;
				String ss2 = s2+s1;

				if((ss1).compareTo(ss2)<0){
					temp = nums[i] ;
					nums[i] = nums[j];
					nums[j] = temp;
				}
						
			}
		}
		StringBuffer sb = new StringBuffer();
		for(int i = 0 ; i < len ; i++){
			sb.append(nums[i]);
		}
		//判断是不是只有0的情况
		String solu = sb.toString();
		boolean flag = false;
		for(int i = 0 ; i < solu.length() ; i++){
			if(solu.charAt(i)!='0'){
				flag = true;
				break;
			}
		}
		if(flag==false) return "0";
		
		return solu;
    }


}
