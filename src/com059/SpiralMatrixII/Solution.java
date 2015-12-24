package com059.SpiralMatrixII;

public class Solution {
	public static void main(String args[]){
		int[][] solu = generateMatrix(8);
		for(int i = 0 ; i < solu.length ; i++){
			System.out.print("{");
			for(int j = 0 ; j < solu.length ; j++){
				System.out.print(solu[i][j]+",");
			}
			System.out.println("},");
		}
	}
	public static int[][] generateMatrix(int n) {
		int i = 0 ; 
		int j = 0;
		int[][] solu = new int[n][n];
		int t = 1;
		int len1 = n-1;
		int len2 = n-1; 
		int len3 = 0;
		int len4 = 0;
		int start =0;
		while(true){
			i = start ;
			j = start;
			while(j<len1){
				solu[i][j] = t++;
				j++;
			}
			while(i<len2){
				solu[i][j] = t++;
				i++;
			}
			while(j>len3){
				solu[i][j] = t++;
				j--;
			}
			while(i>len4){
				solu[i][j] = t++;
				i--;
			}
			start++;
			len1-=1 ; 
			len2-=1 ; 
			len3+=1 ;
			len4+=1 ;
			
			if(t>=n*n) break;
		}
		if(n%2==1)
			solu[n/2][n/2]=n*n;
		return solu;
	}
}
