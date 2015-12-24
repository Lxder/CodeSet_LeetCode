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

//最小值乘以一个负数可能就变为最大值，因此要维护两个数组，一个局部最小，一个局部最大
//同时还有一个选择起点的逻辑，
//如果之前的最大和最小值同当前元素相乘之后，没有当前元素大（或小）那么当前元素就可作为新的起点。
//例如，前一个元素为0的情况，{1,0,9,2}，到9的时候9应该作为一个最大值，也就是新的起点
// f[i] means maximum product that can be achieved ending with i
// g[i] means minimum product that can be achieved ending with i
