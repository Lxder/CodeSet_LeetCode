package com309.BestTimetoBuyandSellStockwithCooldown;
public class Solution {
	
	public static void main(String args[]){
		int[] prices = {1,2,3,0,2};
		System.out.println(maxProfit2(prices));
	}
	//maxProfit2�ļ򻯰�
    public static int maxProfit(int[] prices) {
    	int len = prices.length;
    	if(len<2) return 0;
    	int sell = 0, prev_sell = 0 ; 
    	int buy = Integer.MIN_VALUE, prev_buy;
    	for(int price : prices){
    		prev_buy = buy ; 
    		buy = Math.max(prev_sell-price, prev_buy);
    		prev_sell = sell;
    		sell = Math.max(prev_buy + price, prev_sell);
    	}
    	return sell;    	
    }
    
    //˼·������
    public static int maxProfit2(int[] prices){
    	int len = prices.length;
    	if(len < 2) return 0;
    	int[] buy = new int[len];  //��ֹ����i��֮ǰ��������棬�ҽ�������Ϊ����
    	int[] sell = new int[len]; //��ֹ����i��֮ǰ��������棬�ҽ�������Ϊ����
    	int[] rest = new int[len]; //��ֹ����i��֮ǰ��������棬�ҽ�������Ϊcolldown
    	buy[0] = -prices[0]; //buy[0]Ϊ-prices[0]����һ�����룬�϶��ǳɱ�������prices[0],�ɿ�������prices[0]
    	sell[0] = 0;
    	rest[0] = 0;
    	for(int i = 1 ; i < len ; i++){
    		int price = prices[i];
    		buy[i]  = Math.max(rest[i-1]-price, buy[i-1]) ;
    		sell[i] = Math.max(buy[i-1]+price, sell[i-1]);
    		rest[i] = sell[i-1];
    	}
    	for(int i = 0 ; i < len ;i++){
    		System.out.print(buy[i]+ "\t");
    	}
    	System.out.println();
    	for(int i = 0 ; i < len ;i++){
    		System.out.print(sell[i]+ "\t");
    	}
    	System.out.println();
    	for(int i = 0 ; i < len ;i++){
    		System.out.print(rest[i]+ "\t");
    	}
    	System.out.println();
    	return sell[len-1];
    }
}