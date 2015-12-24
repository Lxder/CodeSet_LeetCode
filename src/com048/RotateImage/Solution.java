package com048.RotateImage;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
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
		int[][] n = new int[len][len];
		for(int i = 0 ; i < len ; i++ ){
			for(int j = 0 ; j < len ; j++){
				n[j][len-1-i] = matrix[i][j];
			}
		}
		for(int i = 0 ; i < len ; i++ ){
			for(int j = 0 ; j < len ; j++){
				matrix[i][j] = n[i][j];
			}
		}
		
	}

}
