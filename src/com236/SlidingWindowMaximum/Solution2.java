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

		// ע�� ���˫�˶��д�ŵ����±�
		Deque<Integer> queue = new LinkedList<Integer>();

		// ���ڻ�û�������������ֵ����
		for (int i = 0; i < k && i < nums.length; i++) {
			while (!queue.isEmpty() && nums[i] > nums[queue.getLast()]) {
				queue.removeLast();
			}
			// �������
			queue.addLast(i);
		}

		// �����Ѿ�����
		for (int i = k; i < nums.length; i++) {
			// �����һ�����ڵ����ֵ
			solu.add(nums[queue.getFirst()]);
			while (!queue.isEmpty() && nums[i] > nums[queue.getLast()]) {
				queue.removeLast();
			}

			// ���������������ƣ�ɾ���ʼ��
			if (!queue.isEmpty() && queue.getFirst() <= (i - k))
				queue.pollFirst();

			// �µ������봰�ڣ���ʱ������ܱ�֤�����ڵ��±��Ӧ�����ǵݼ���
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
