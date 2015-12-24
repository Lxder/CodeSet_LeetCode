package com128.LongestConsecutiveSequence;

import java.util.HashMap;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0} ;
		System.out.println(longestConsecutive(nums));
		
	}

	public static int longestConsecutive(int[] nums) {
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		int len = nums.length;
		for(int i = 0 ; i < len ; i++){
			map.put(nums[i], 1);
		}


		int j = 0;
		int templen = 0;
		int maxlen = 0;
		for(int i = 0 ; i < len ; i++){
			if(map.get(nums[i])!=0){ //获取中心数字
				j = 1;
				templen = 1 ; 
				while(map.get(nums[i]+j)!=null){
					map.put(nums[i]+j, 0);
					templen++; j++;
				}
				j = 1;
				while(map.get(nums[i]-j)!=null){
					map.put(nums[i]-j, 0);
					templen++ ; j++; 
				}				
				if(maxlen<templen)
					maxlen = templen;
				System.out.println("当前中心"+nums[i]+"当前长度"+templen+"最大长度"+maxlen);
			}
		}
		return maxlen;
	}

}
