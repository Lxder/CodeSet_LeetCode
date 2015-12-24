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

		int count = 1; // ȫ���е�����
		for (int i = len; i > 0; i--) {
			count *= i;
		}
		count--; // ԭʼ�������Ѿ��ӽ�ȥ��

		while (count > 0) {
			count--;
			int ismal = len - 2;
			while (ismal >= 0 && nums[ismal] >= nums[ismal + 1])
				ismal--; // 1. ��ǰ�ҳ���һ�����ұ�����С�����ֵ����j

			if (ismal == -1) { // ����������鶼�ǵ����ģ��ͷ��ص�һ�����У�����Ϊ�ݼ����Ǹ�����
				InvertArray(nums, 0, len - 1);
				addlist(solu, nums, len);
				continue;
			}

			int i_min = ismal + 1; // 2.
									// ��P[j]���ұߵ������У��ҳ����б�P[j]���������С������Pk(�Ҳ�Ϊ������)

			while (i_min < len && nums[i_min] > nums[ismal])
				i_min++;
			i_min--;
			Swap(nums, ismal, i_min); // 3. ����nums[ismal]��nums[i_min]
			InvertArray(nums, ismal + 1, len - 1); // 4. ��ismal+1��len-1��Ԫ������

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
