package com046.Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution {
	public static void main(String args[]) {
		int[] nums = { 3, 3, 0, 3 };
		List<List<Integer>> list = permute(nums);
		System.out.println(list);
		System.out.println(list.size());
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> solu = new ArrayList<List<Integer>>();
		if (nums.length == 0)
			return solu;

		int len = nums.length;
		addlist(solu, nums, len);
		if (nums.length == 1)
			return solu;

		int count = 1; // 全排列的数量
		for (int i = len; i > 0; i--) {
			count *= i;
		}
		count--; // 原始的序列已经加进去了

		while (count > 0) {
			count--;
			int ismal = len - 2;
			while (ismal >= 0 && nums[ismal] >= nums[ismal + 1])
				ismal--; // 1. 向前找出第一个比右边数字小的数字的序号j

			if (ismal == -1) { // 如果整个数组都是递增的，就返回第一个序列，即变为递减的那个序列
				InvertArray(nums, 0, len - 1);
				addlist(solu, nums, len);
				continue;
			}

			int i_min = ismal + 1; // 2.
									// 在P[j]的右边的数字中，找出所有比P[j]大的数中最小的数字Pk(右侧为递增的)

			while (i_min < len && nums[i_min] > nums[ismal])
				i_min++;
			i_min--;
			Swap(nums, ismal, i_min); // 3. 交换nums[ismal]和nums[i_min]
			InvertArray(nums, ismal + 1, len - 1); // 4. 将ismal+1到len-1的元素逆置

			addlist(solu, nums, len);

		}
		return solu;
	}

	public static void addlist(List<List<Integer>> solu, int[] nums, int len) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < len; i++) {
			list.add(nums[i]);
		}
		solu.add(list);
	}

	public static void Swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void InvertArray(int[] nums, int start, int end) {
		int temp;
		while (start < end) {
			temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}
}
