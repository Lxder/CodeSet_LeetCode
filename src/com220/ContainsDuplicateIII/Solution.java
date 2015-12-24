package com220.ContainsDuplicateIII;

import java.util.SortedSet;
import java.util.TreeSet;

//如何使用treeset
public class Solution {
	public static void main(String args[]){
		int[] nums = {-1,-1}; 
		System.out.println(containsNearbyAlmostDuplicate(nums, 1,0));
		
		
		SortedSet<Integer> set = new TreeSet<Integer>();
		for(int i = 0 ; i <10 ; i++){
			set.add(i);
		}
		
		System.out.println(set.subSet(1, 5));
		TreeSet<Integer> set2 = new TreeSet<Integer>(set);
		System.out.println(set2.subSet(1,true, 5,true));
		
	}

	//k: 下标差  t: 数值差
	public static boolean containsNearbyAlmostDuplicate(int[] nums , int k  ,int t){
		int len = nums.length;
		if(k<1 || t<0 || nums==null || len<2) return false;
		SortedSet<Long> set = new TreeSet<Long>();
		for(int i = 0 ; i < len ; i++){
			if(!set.subSet((long)nums[i]-t,(long)nums[i]+t+1).isEmpty()) return true;
			
			if(i>=k){
				set.remove((long)nums[i-k]);
			}
			set.add((long)nums[i]);
		}
		return false;
	}
	


	
	//双层循环暴搜,超时!!!!!!!!!!!!!
	public static boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
		int len = nums.length;
		for(int i = 0 ; i < len ; i++){
			for(int j = i+1 ; j < len ;j++){
				if(Math.abs(nums[j]-nums[i])<t && Math.abs(j-i)<k)
					return true;
			}
		}
		return false;
	}
	
	
}