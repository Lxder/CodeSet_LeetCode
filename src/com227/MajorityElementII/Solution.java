package com227.MajorityElementII;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums  ={1,2,3,4,2,2,2,3,3,3,3};
		//int[] nums  ={1,1,1,1,2,4,5,6,7,8,9};
		System.out.println(majorityElement(nums));
	}

	public static List<Integer> majorityElement(int[] nums) {
		List<Integer> solu = new ArrayList<Integer>();
		if(nums==null||nums.length==0){
			return solu;
		}
		int len = nums.length;
//		if(len==1){
//			solu.add(nums[0]);
//			return solu;
//		}

		int[] candidates = new int[2]; //要选出两个候选人
		int[] times = new int[2];
		for(int i = 0 ; i < len ; i ++){
			if(candidates[0]==nums[i]) times[0]++;
			else if(candidates[1]==nums[i]) times[1]++;
			else{				
				if(times[0]==0){times[0]=1; candidates[0]=nums[i];}
				else if(times[1]==0){times[1]=1; candidates[1]=nums[i];}
				else{
					times[0]--;
					times[1]--;
				}
			}
		}
		
		times[0] = times[1]=0;
		for(int i = 0 ; i< len ; i++){
			if(candidates[0]==nums[i])
				times[0]++;
			if(candidates[1]==nums[i])
				times[1]++;
		}
		System.out.println(times[0]+" "+times[1]);
		if(times[0]>len/3)
			solu.add(candidates[0]);
		if(times[1]>len/3&&candidates[0]!=candidates[1])
			solu.add(candidates[1]);
		return solu;
	}

}
