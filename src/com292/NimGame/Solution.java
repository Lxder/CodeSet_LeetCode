package com292.NimGame;
public class Solution {
	
	
	//�������ڴ���������ܴ�����ô������飩
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
    //�������Ľ�����֣�ֻ���±�Ϊ4�ı�����ʱ��ſ���ʧ�ܣ������������ķ�����

    public boolean canWinNim2(int n) {
    	return (n%4==0)? false : true;
    }
}