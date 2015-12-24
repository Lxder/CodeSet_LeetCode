package com123.BestTimetoBuyandSellStockIII;

public class Solution {
	public static void main(String args[]) {
		int[] prices = {4,1,8,3,5,6,7,9};
		System.out.println(maxProfit(prices));
	}

	public static int maxProfit(int[] prices) {
		int len = prices.length;
		if(len==0) return 0;
		//正向计算最大利润
		int[] opt = new int[len]; //保存当前最大利润
		opt[0] = 0;
		int low = prices[0];
		int maxprofit = 0;
		for(int i = 1 ;i< len ; i++){
			if(low > prices[i]) low = prices[i];
			else if(prices[i]-low > maxprofit)
				maxprofit = prices[i]-low;
			opt[i]  = maxprofit;
		}
		
		//逆向计算最大利润 optRev[i] 表示i到n-1的最大收益
		int[] optRev = new int[len];
		optRev[len-1] = 0 ; 
		int high = prices[len-1];
		maxprofit = 0;
		for(int i = len-2 ; i>=0 ; i--){
			if(high < prices[i]) high = prices[i];
			else if(high - prices[i]> maxprofit)
				maxprofit =high - prices[i];
			optRev[i] = maxprofit;
		}
		
		//计算两次交易的最大收益
		maxprofit = 0;
		int profit = 0;
		for(int i = 0 ; i < len ; i++){
			profit = opt[i]+optRev[i]; 
			if(profit>maxprofit)
				maxprofit = profit; 
		}
		return maxprofit;
		
		
	}
}
