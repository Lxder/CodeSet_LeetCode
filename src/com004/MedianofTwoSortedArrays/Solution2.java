package com004.MedianofTwoSortedArrays;

public class Solution2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = { 1, 2 };
		int[] nums2 = { 1, 2  ,4 };
		double media = findMedianSortedArrays(nums1, nums2);
		System.out.println(media);

	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m =nums1.length;
		int n = nums2.length;
		int total = m + n;  
	        if (total %2==1)  
	            return findKth(nums1, 0, m, nums2, 0,n, total / 2 + 1);  
	        else  
	            return (findKth(nums1,0, m, nums2,0 , n, total / 2)  
	                    + findKth(nums1, 0, m, nums2, 0, n, total / 2 + 1)) / 2.0;  
	}
	
	//m，n分别代表两个数组当前元素数量（不是数组长度，因为起点不同）
	public static double findKth(int a[],int starta, int m, int b[], int startb, int n, int k) {
		if (m > n)		// 总是令第一个数组的数字数量数量比较少
			return findKth(b, startb , n, a,starta , m, k);
		if (m == 0)
			return b[startb + k - 1];
		if (k == 1)
			return Math.min(a[starta], b[startb]);
		// divide k into two parts
		int pa = Math.min(k / 2, m), pb = k - pa;
		if (a[starta + pa - 1] < b[startb + pb - 1])
			return findKth(a ,starta+pa , m - pa, b, startb , n, k - pa);
		else if (a[starta + pa - 1] > b[startb + pb - 1])
			return findKth(a, starta, m, b , startb+pb , n - pb, k - pb);
		else
			return a[starta + pa - 1];
	}

}
