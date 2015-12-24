package com188.BestTimetoBuyandSellStockIV;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k >= len-1) return quickSolve(prices); //����״����㹻����ôֻҪ��

        int[][] t = new int[k + 1][len];
        for (int i = 1; i <= k; i++) {
            int tmpMax = -prices[0];
            for (int j = 1; j < len; j++) {
                t[i][j] = Math.max(t[i][j-1], tmpMax+prices[j]);
                tmpMax =  Math.max(tmpMax, t[i-1][j-1] - prices[j]);
            }
        }
        return t[k][len - 1];
    }


	//�����������������״����㹻����ôֻҪ������Ϳ��Խ��н���
    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
        	//ֻҪǰ���ֵΪ������������
            if (prices[i] > prices[i-1])  
            	profit += prices[i] - prices[i-1];
        return profit;
    }

}
