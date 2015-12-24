package com122.BestTimetoBuyandSellStockII;

public class Solution2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {8,1,4,5,3,6,5,4,7};
		System.out.println(maxProfit(nums));
	}
//Î´Íê³É£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡
	public static int maxProfit(int[] prices) {
		int len = prices.length;

		int sprice = 0;
		int eprice = 0;
		int maxproift = 0;

		int end = 0;
		for (int i = 0; i < len - 1; i++) {
			while (i < len - 1) {
				if (prices[i] < prices[i + 1])
					sprice = prices[i];
				else i++;
			}
			end = i+1;
			while(end<len-1){
				if(prices[end]>prices[end+1])
					eprice = prices[end];
				else end++;
			}
			maxproift += (eprice-sprice);

		}
		
		return maxproift;
	}

}
