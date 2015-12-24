package com218.TheSkylineProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution3 {

	public static void main(String[] args) {
		int[][] buildings = {  {2, 9, 10},{3,7,15},{5,12,12},{15,20,10},{19,24,8} };		
		List<int[]> solu = getSkyline(buildings);
		for (int[] curr : solu) {
			System.out.println(curr[0] + " " + curr[1]);
		}
	}

	//http://segmentfault.com/a/1190000003786782
	// ���Ӷ� ʱ�� O(NlogN) �ռ� O(N)
	/*
	 * �������һ������һ��������������ǳ��鷳��
	 * ���ǿ��԰���Щ���β�������㣬һ�����϶��㣬һ�����϶��㡣
	 * �����ж��㰴�պ�������������ǿ�ʼ������Щ�㡣
	 * ����ʱ��ͨ��һ��������֪��ǰͼ�ε����λ�á�
	 * �Ѷ������ж�������ߵĵ㣬ֻҪ�����û���Ƴ��ѣ�˵�������ߵľ��λ�û������
	 * �����󶥵㣬���ǽ��������С�
	 * �����Ҷ��㣬�����ҳ���������Ӧ���󶥵㣬Ȼ���Ƴ�����󶥵㣬ͬʱҲ��ζ��������εĽ�����
	 * ��������У�Ϊ���������Ķ����б����������Ҷ��㣬�󶥵��ֵ�����������Ҷ���ֵ�����Ǹ�����
	 */
	
	
	public static List<int[]> getSkyline(int[][] buildings) {
		List<int[]> result = new ArrayList<>();
		List<int[]> height = new ArrayList<>();
		// �����Σ�����������б�
		for (int[] b : buildings) {
			// �󶥵��Ϊ����
			height.add(new int[] { b[0], -b[2] });
			// �Ҷ����Ϊ����
			height.add(new int[] { b[1], b[2] });
		}
		// ���ݺ�������б�������ͬ������ĵ�������С������ǰ��
		Collections.sort(height, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if (a[0] != b[0]) {
					return a[0] - b[0];
				} else {
					return a[1] - b[1];
				}
			}
		});
		// �����ѣ��������������жϴ�С
		Queue<Integer> pq = new PriorityQueue<Integer>(11,
				new Comparator<Integer>() {
					public int compare(Integer i1, Integer i2) {
						return i2 - i1;
					}
				});
		// ����ƽ��ֵ�ȼ������
		pq.offer(0);
		// prev���ڼ�¼�ϴ�keypoint�ĸ߶�
		int prev = 0;
		for (int[] h : height) {
			// ���󶥵�������
			if (h[1] < 0) {
				pq.offer(-h[1]);
			} else {
				// ���Ҷ����Ӧ���󶥵���ȥ(�൱�����¥������)
				pq.remove(h[1]);
			}
			int cur = pq.peek();
			// ����ѵ��¶������ϸ�keypoint�߶Ȳ�һ���������һ���µ�keypoint
			if (prev != cur) {				
				result.add(new int[] { h[0], cur });
				prev = cur;
			}
		}
		return result;
	}
}
