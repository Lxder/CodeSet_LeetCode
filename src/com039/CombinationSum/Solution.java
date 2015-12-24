package com039.CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidates = {2,3,6,7};
		System.out.println(combinationSum(candidates,7));

	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(candidates);
		
	    helper(candidates, 0,candidates.length, target, new ArrayList<Integer>(),res);
	    return res;
	}
	
	//使用深度优先搜索
	private static void helper(int[] can, int start,int len, int target, List<Integer> each, List<List<Integer>> res ) {
	    if (target<0) return;
	    for (int i = start; i < len; i++) {	   	    	
	        if (can[i] == target) {
	            each.add(can[i]);
	            res.add(each);
	            break;
	        } else if (can[i] < target) {
	        	List<Integer> temp = new ArrayList<>(each);
	            temp.add(can[i]);
	            helper(can, i, len,target-can[i], temp, res);
	        } else break;
	    }
	    return;
	}

}
