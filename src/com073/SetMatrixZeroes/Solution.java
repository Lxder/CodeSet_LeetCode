package com073.SetMatrixZeroes;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{0},{1}};
		setZeroes(matrix);
	}
//Given a m x n matrix,
//if an element is 0, set its entire row and column to 0. Do it in place.
	public static void setZeroes(int[][] matrix) {
		int row = matrix.length; //指示行数目
		int col = matrix[0].length; //指示列数目
		
		boolean flagcol = false; //查看第一列是否有为0的元素
		for(int i = 0 ; i < row ; i++){
			if(matrix[i][0]==0)
				flagcol=true;
		}
		
		boolean flagrow = false; //查看第一行是否有为0的元素
		for(int i = 0 ; i < col ; i++){
			if(matrix[0][i]==0)
				flagrow=true;
		}
		
		for(int i = 1 ; i< row ; i++){
			for(int j = 1 ; j < col ; j++){
				if(matrix[i][j]==0){
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		for(int i = 1 ; i < row ; i++){
			if(matrix[i][0]==0){
				for(int j = 1 ; j < col ; j++){
					matrix[i][j] = 0;
				}
			}
		}
		for(int j =  1 ; j < col ; j++){
			if(matrix[0][j]==0){
				for(int i = 1 ; i < row ; i++){
					matrix[i][j]=0;
				}
			}
		}
		
		if(flagcol == true){ //第一列有为0的元素,将第一列置为0
			for(int i = 0 ; i < row ;i++){
				matrix[i][0]=0;
			}
		}
		
		if(flagrow == true){//第一行有为0的元素，将第一行置为0
			for(int j = 0 ; j < col ; j++){
				matrix[0][j]=0;
			}
		}
	}

}
