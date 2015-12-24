package com221.MaximalSquare;

import java.util.Stack;


public class Solution2 {

	public static void main(String args[]){
		char[][] matrix = {
				{'1','1','0','1','0','1'},
				{'0','0','1','1','0','1'},
				{'1','1','1','1','0','1'},
				{'1','1','1','1','0','1'},
				{'1','1','0','1','0','1'}
		};
		
		int times = 10000;
		System.out.println(maximalSquare(matrix));
//		long starttime = System.currentTimeMillis();
//		for(int i = 0 ; i< times ; i++ )
//			maximalSquare(matrix);
//		long endtime = System.currentTimeMillis();
//		System.out.println((endtime-starttime)/times);
	}
	
	public static int maximalSquare(char[][] matrix) {
		int row = matrix.length; //行数
		if(row==0) return 0 ;
		int col = matrix[0].length; //列数
		if(col==0) return 0;
		
		int[][] dynarr = new int[row+1][col+1]; //用于动态规划的数组
		for(int i = 0 ; i <= col ; i++){
			dynarr[0][i]=0;			
		}
		for(int i = 0 ; i <= row ; i++){
			dynarr[i][0] = 0;
		}
		int maxedge = 0;
		
		for(int i = 1 ; i <= row ; i++){
			for(int j = 1 ; j <=col ; j++){
				if(matrix[i-1][j-1] =='1'){
					dynarr[i][j] =Math.min(dynarr[i-1][j-1], Math.min(dynarr[i-1][j],dynarr[i][j-1]))+1;
					
					if(dynarr[i][j]>maxedge)
						maxedge = dynarr[i][j];
				}
				else
					dynarr[i][j] = 0;
			}
		}
		
		for(int i = 0 ; i <= row ; i++){
			for(int j = 0 ; j <= col ; j++){
				System.out.print(dynarr[i][j]+" ");
			}
			System.out.println();
		}

		return maxedge*maxedge;

		
	}
}
