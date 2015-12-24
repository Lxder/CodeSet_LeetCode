package com062.UniquePaths;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(uniquePaths(0,4));
	}

	public static int uniquePaths(int m, int n) {
		if(m==0||n==0) return 0;
		if(m==1||n==1) return 1;
		int[][] solu = new int[m][n];
		
		for(int i = 0 ; i < m ; i++){ //第0列置为1
			solu[i][0] = 1;
		}
		
		for(int j = 0 ; j < n ; j++){ //第0行置为1
			solu[0][j] = 1;
		}
		
		for(int i = 1 ; i < m ; i++){
			for(int j = 1 ; j < n ; j++)
				solu[i][j] = solu[i][j-1]+solu[i-1][j];
		}
		
		return solu[m-1][n-1];
	}

}
