package com228.SummaryRanges;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums =  {1,2,4,5,7,8,9};
		List solu = summaryRanges(nums);
		Iterator itr = solu.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}

	public static  List<String> summaryRanges(int[] nums) {
			int len = nums.length;	
			List<String> solu = new ArrayList();
			if(len==0) return solu;
			int start = 0 ;
			
			for(int i = 0 ; i < len -1; i++){
				if(nums[i+1] != nums[i]+1){
					String str = new String();
					if (start == i){
						str = Integer.toString(nums[start]);
					}else{
						str = Integer.toString(nums[start])+"->"+Integer.toString(nums[i]);
					}
					solu.add(str);
					start = i+1;
				}

			}
		//	if(nums[len-1]==nums[len-2]){
				String str = new String();
				if(start == len-1)
					str = Integer.toString(nums[start]);
				else{
					str = Integer.toString(nums[start])+"->"+Integer.toString(nums[len-1]);
				}
				solu.add(str);
		//	}
			

			return solu;
	    }
}
