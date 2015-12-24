package com088.MergeSortedArray;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = new int[20];
		nums1[0] = 0;
		nums1[1] = 3;
		nums1[2] = 5;
		nums1[3] = 7;
		nums1[4] = 9;
		int[] nums2 = {1,4,6,8,10};
		merge(nums1,0,nums2,1);
		for(int i = 0  ; i < 1 ; i++){
			System.out.println(nums1[i]);
		}
	}

	//m和n代表数组元素数量
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int end = m+n-1; //指示最后一位
		int e1 = m-1;
		int e2 = n-1;
		while(e1>=0&&e2>=0){
			if(nums1[e1]>=nums2[e2])
				nums1[end--] = nums1[e1--];
			else{
				nums1[end--] = nums2[e2--];
			}
			System.out.println("sadf");
		}
		while(e1>=0){
			nums1[end--] = nums1[e1--];
		}
		while(e2>=0){
			nums1[end--] = nums2[e2--];
		}
	}

}
