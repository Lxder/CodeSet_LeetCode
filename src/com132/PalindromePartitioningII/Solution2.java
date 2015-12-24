package com132.PalindromePartitioningII;


public class Solution2 {

	public static void main(String[] args) {
		
		String s = "ababababababababababababcbabababababababababababaa";
		System.out.println(minCut(s));
	}
	
	
	public static int minCut(String s) {
		int len = s.length();
		if(len<=1) return 0;
		boolean[][] isPalin = new boolean[len][len];
		
		
		int[] minCuts = new int[len+1];
        for(int i=0; i<=len; ++i) minCuts[i] = i-1; //初始化，存放0到i最小切割次数

        for(int j=1; j<len; ++j) {
            for(int i=j; i>=0; --i){
                if((s.charAt(i)==s.charAt(j))&& ((j-i<2)||isPalin[i+1][j-1])){
                    isPalin[i][j] = true;
                    minCuts[j+1] =Math.min(minCuts[j+1], 1 + minCuts[i]);//更新0到j元素最小切割次数    
                }
            }
        }
        return minCuts[len];
    }
	

}
