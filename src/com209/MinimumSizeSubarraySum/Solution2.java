package com209.MinimumSizeSubarraySum;


public class Solution2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {2,3,1,2,4,3};
		System.out.println(minSubArrayLen(7,nums));
	}

	public static int minSubArrayLen(int s, int[] nums) {
		int len = nums.length;
		int start = 0 ; 
		int end = 0;
		int sum = 0;
		int minlen = Integer.MAX_VALUE;
		int templen = 0;
		while(start<len&&end<len){
			while(sum<s&&end<len){
				sum = sum+nums[end];
				end++;
				templen++;
			}
			while(sum>=s && start<=end){ //�ʹ���Ŀ��� ������ʵλ��С���յ�λ��
				if(templen<minlen) 
					minlen = templen;
				sum = sum-nums[start];
				start++;
				templen--;
			}
		}
		
		if(minlen==Integer.MAX_VALUE) return 0;
		return minlen;
	}

}
