package com216.CombinationSumIII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2DFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(combinationSum3(2,6));
	}
	
	public static List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<>();
	    int[] can = {1,2,3,4,5,6,7,8,9};
	    Arrays.sort(can);
	    helper(can, 0, n, new ArrayList<Integer>(), k ,res);
	    return res;
	}

	
	//使用深度优先搜索
	private static void helper(int[] can, int start, int target, List<Integer> each, int len , List<List<Integer>> res ) {
	    if (each.size() >= len) {return;}
	    for (int i = start; i < can.length; i++) {
	        List<Integer> temp = new ArrayList<>(each);
	        if (can[i] == target) {
	            if (each.size() == len - 1) {
	                temp.add(can[i]);
	                res.add(temp);
	            }
	            break;
	        } else if (can[i] < target) {
	            temp.add(can[i]);
	            helper(can, i+1, target-can[i], new ArrayList<>(temp),len , res);
	        } else {break;}
	    }
	    return;
	}

}
