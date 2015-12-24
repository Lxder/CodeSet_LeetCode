package com064.MinimumPathSum;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minPathSum(int[][] grid) {
		int row = grid.length ; 
		if(row == 0) return 0;
		int col = grid[0].length;
		int[][] sum = new int[row][col]; //新建数组存放到当前点的最小和
		sum[0][0] = grid[0][0];
		for(int i = 1 ;  i < row ; i++){ //为第0列赋值
			sum[i][0] = sum[i-1][0]+grid[i][0];
		}
		
		for(int j = 1 ; j < col ; j++){
			sum[0][j] = sum[0][j-1]+grid[0][j];
		}
		
		for(int i = 1 ; i < row ; i++){
			for(int j = 1 ; j < col ; j++){
				sum[i][j] = Math.min(sum[i][j-1], sum[i-1][j])+grid[i][j];
			}
		}
		
		return sum[row-1][col-1];
	}

}
