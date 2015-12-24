package com048.RotateImage;

public class Solution2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		rotate(matrix);
		for(int i = 0 ; i <matrix.length ; i++){
			for(int j = 0 ; j < matrix.length ; j++){
				System.out.print(matrix[i][j]+"\t");
			}
			System.out.println();
		}
	}

	public static void rotate(int[][] matrix) {
		int len = matrix.length;
		int limit = (len+1)/2;
		System.out.println(limit);
		int temp = 0 ;
		for(int i = 0 ; i < limit ; i++){
			for(int j = i ; j < len-i-1 ; j++){
				temp = matrix[i][j];
				matrix[i][j] = matrix[len-1-j][i];
				matrix[len-1-j][i] = matrix[len-1-i][len-1-j];
				matrix[len-1-i][len-1-j] = matrix[j][len-1-i];
				matrix[j][len-1-i] = temp;
			}
		}
		
		
	}

}
