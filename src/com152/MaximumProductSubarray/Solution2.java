package com152.MaximumProductSubarray;

public class Solution2 {

	public static void main(String args[]) {
		int[] nums = {2,3,-1,-2,-4,0,-5,-6,0,-7,2,5};
		//int[] nums = { 0, -2, 0 };
		System.out.println(maxProduct(nums));
	}

	public static int maxProduct(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int[] f = new int[A.length];
		int[] g = new int[A.length];
		f[0] = A[0];
		g[0] = A[0];
		int res = A[0];
		for (int i = 1; i < A.length; i++) {
			f[i] = Math.max(Math.max(f[i - 1] * A[i], g[i - 1] * A[i]), A[i]);
			g[i] = Math.min(Math.min(f[i - 1] * A[i], g[i - 1] * A[i]), A[i]);
			res = Math.max(res, f[i]);
		}
		return res;
	}
}

//��Сֵ����һ���������ܾͱ�Ϊ���ֵ�����Ҫά���������飬һ���ֲ���С��һ���ֲ����
//ͬʱ����һ��ѡ�������߼���
//���֮ǰ��������Сֵͬ��ǰԪ�����֮��û�е�ǰԪ�ش󣨻�С����ô��ǰԪ�ؾͿ���Ϊ�µ���㡣
//���磬ǰһ��Ԫ��Ϊ0�������{1,0,9,2}����9��ʱ��9Ӧ����Ϊһ�����ֵ��Ҳ�����µ����
// f[i] means maximum product that can be achieved ending with i
// g[i] means minimum product that can be achieved ending with i
