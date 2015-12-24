package com240.Searcha2DMatrixII;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {
		                   {1,   4,  7, 11, 15},
		                   {2,   5,  8, 12, 19},
		                   {3,   6,  9, 16, 22},
		                   {10, 13, 14, 17, 24},
		                   {18, 21, 23, 26, 30}
		                 };
		System.out.println(searchMatrix(matrix,24));

	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		int row = matrix.length; 	//行数目
		if(row==0) return false;
		int col = matrix[0].length; //列数目
		
		int i = 0;
		int j = col-1;
		while(i<row&&j>=0){
			if(matrix[i][j]<target)
				i++;
			else if(matrix[i][j]>target)
				j--;
			else return true;
		}
		return false;
	}

}
