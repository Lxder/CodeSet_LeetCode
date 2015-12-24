package com040.CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidates = {2,5,2,1,1,1,2};
		System.out.println(combinationSum2(candidates,5));
	}

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(candidates);
		
	    helper(candidates, 0,candidates.length, target, new ArrayList<Integer>(),new HashSet<Integer>(),res);
	    return res;
	}
	
	//使用深度优先搜索
	private static void helper(int[] can, int start,int len, int target, List<Integer> each, Set<Integer> issame, List<List<Integer>> res ) {
	    if (target<0) return;
	    for (int i = start; i < len; i++) {	    	
	    	if(issame.contains(can[i])) continue; //排除重复的结果
	    	else issame.add(can[i]);
	    	
	        if (can[i] == target) {
	            each.add(can[i]);
	            res.add(each);
	            break;
	        } else if (can[i] < target) {
	        	List<Integer> temp = new ArrayList<>(each);
	            temp.add(can[i]);
	            helper(can, i+1, len,target-can[i], temp,new HashSet<Integer>(), res);
	        } else break;
	    }
	    return;
	}

}
