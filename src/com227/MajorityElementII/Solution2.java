package com227.MajorityElementII;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums  ={1,2,3,4,2,2,2,3,3,3,3};
		//int[] nums  ={1,1,2};
		System.out.println(majorityElement(nums));
	}

	
	//ע�⣺����ĿҪ��һ��
	//Ѱ�ҷ���ˮ�� �Ĵ��룬�ҵ���������������1/3����
	public static List<Integer> majorityElement(int[] nums) {
		List<Integer> solu = new ArrayList<Integer>();
		int len = nums.length;

		int[] candidates = new int[2]; //Ҫѡ��������ѡ��
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
		
		solu.add(candidates[0]);
		solu.add(candidates[1]);
		return solu;
	}

}
