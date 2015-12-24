package com122.BestTimetoBuyandSellStockII;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {8,1,4,5,3,6,5,4,7};
		System.out.println(maxProfit(nums));
	}

	public static int maxProfit(int[] prices) {
		int len = prices.length;
		int maxproift = 0;
		for (int i = 0; i < len - 1; i++) {
			int temp = prices[i+1]-prices[i];
			if(temp>0) 
				maxproift += temp;
		}
		return maxproift;
	}

}
