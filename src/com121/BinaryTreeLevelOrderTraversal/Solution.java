package com121.BinaryTreeLevelOrderTraversal;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {2,1};
		System.out.println(maxProfit(prices));

	}
	//相邻的两个数之差就是这两天之间的收益，可正可负。转换成求连续几天收益的最大和
	public static int maxProfit(int[] prices) {
		int len = prices.length;
		if (len==0||len==1) return 0;
		int sum = Integer.MIN_VALUE;
		int maxsum = Integer.MIN_VALUE;
		int temp;
		for(int i = 1 ; i < len ; i++){
			temp = prices[i]-prices[i-1];
			if(sum<0)
				sum = temp;
			else 
				sum = sum + temp;
			if(sum>maxsum)
				maxsum = sum;
		}
		if(maxsum<0) return 0;
		return maxsum;
	}

}
