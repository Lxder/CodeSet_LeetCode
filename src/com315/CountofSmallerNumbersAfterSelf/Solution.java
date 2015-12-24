package com315.CountofSmallerNumbersAfterSelf;

import java.util.Arrays;
import java.util.List;

public class Solution {
	
	public static void main(String args[]){
		int[] nums = {5,2,6,1};
		Solution s = new Solution();
		System.out.println(s.countSmaller(nums));
	}
	
	public List<Integer> countSmaller(int[] nums) {
	    int len = nums.length;
		int[] tmp = nums.clone();
	    int[] i_nums = new int[len]; //保存nums每一个元素在排序后数组中的下标
	    Arrays.sort(tmp);
	    for (int i = 0; i < len; i++) {
	        i_nums[i] = Arrays.binarySearch(tmp, nums[i]);
	    }
	    int[] bit = new int[len]; //保存数字的结果
	    Integer[] ans = new Integer[len]; //保存最终结果
	    for (int i = len - 1; i >= 0; i--) {
	        ans[i] = bit[i_nums[i]]; //从最右边开始计算结果
	        for(int j = i_nums[i]+1 ; j < bit.length ; j++){
	        	bit[j] ++ ; 
	        	//j从nums[i]在排序后下下标位置后一个开始，bit[j]++,
	        	//因为排序后下标在右侧的数字一定比在左侧的数字大。
	        	//注意：该位置右边的都要增加1（已经计算完了的再增加没有影响，因为结果已经保存了）
	        }	        
	    }
	    
	    return Arrays.asList(ans);
	}
}