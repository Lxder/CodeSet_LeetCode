package com236.SlidingWindowMaximum;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {

	public static void main(String args[]) {
		// int[] nums = {1,3,-1,-3,5,3,6,7};
		int[] nums = { 1, -1 };
		int[] solu = maxSlidingWindow(nums, 1);
		for (int i = 0; i < solu.length; i++) {
			System.out.println(solu[i]);
		}
	}

	public static int[] maxSlidingWindow(int[] nums, int k) {
		ArrayList<Integer> solu = new ArrayList<Integer>();
		if (nums == null || nums.length == 0 || k < 1)
			return new int[0];

		// 注意 这个双端队列存放的是下标
		Deque<Integer> queue = new LinkedList<Integer>();

		// 窗口还没有填满，找最大值索引
		for (int i = 0; i < k && i < nums.length; i++) {
			while (!queue.isEmpty() && nums[i] > nums[queue.getLast()]) {
				queue.removeLast();
			}
			// 添加索引
			queue.addLast(i);
		}

		// 窗口已经填满
		for (int i = k; i < nums.length; i++) {
			// 保存第一个窗口的最大值
			solu.add(nums[queue.getFirst()]);
			while (!queue.isEmpty() && nums[i] > nums[queue.getLast()]) {
				queue.removeLast();
			}

			// 数量超过窗口限制，删除最开始的
			if (!queue.isEmpty() && queue.getFirst() <= (i - k))
				queue.pollFirst();

			// 新的数加入窗口，这时候加入能保证窗口内的下标对应数字是递减的
			queue.add(i);
		}

		solu.add(nums[queue.getFirst()]);
		int[] solu_arr = new int[solu.size()];
		for (int i = 0; i < solu.size(); i++) {
			solu_arr[i] = solu.get(i);
		}
		return solu_arr;

	}
}
