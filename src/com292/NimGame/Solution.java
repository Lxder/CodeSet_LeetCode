package com292.NimGame;
public class Solution {
	
	
	//大数据内存溢出（不能创建那么大的数组）
    public boolean canWinNim(int n) {
    	if(n<=3) return true;
    	boolean dp[] = new boolean[n];
    	dp[0] = true;
    	dp[1] = true;
    	dp[2] = true;
    	for(int i = 3 ; i< n ;i++){
    		if(dp[i-1]==true && dp[i-2]==true && dp[i-3]== true)
    			dp[i] = false;
    		else dp[i] = true;
    	}
    	return dp[n-1];
    }
    //输出上面的结果发现，只有下标为4的倍数的时候才可能失败，因此有了下面的方法：

    public boolean canWinNim2(int n) {
    	return (n%4==0)? false : true;
    }
}