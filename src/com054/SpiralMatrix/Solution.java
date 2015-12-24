package com054.SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {};
		List<Integer> solu = spiralOrder(matrix);
		System.out.println(solu);


	}

	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> solu = new ArrayList<Integer>();
		int row = matrix.length; //行数目
		if(row==0) return solu;		
		int col = matrix[0].length; //列数目
		
		int count = row*col;
		int len1 = col-1;
		int len2 = row-1; 
		int len3 = 0;
		int len4 = 0;

		
		int i = 0 ; 
		int j = 0;
		
		while(count>1){
			
			while(j<len1&&count>0){
				solu.add(matrix[i][j]);
				count--;
				j++;
			}
			while(i<len2&&count>0){
				solu.add(matrix[i][j]);
				count--;
				i++;
			}
			while(j>len3&&count>0){
				solu.add(matrix[i][j]);
				count--;
				j--;
			}
			while(i>len4&&count>0){
				solu.add(matrix[i][j]);
				count--;
				i--;
			}
			len1-=1 ; 
			len2-=1 ; 
			len3+=1 ;
			len4+=1 ;
			i++; j++;
		}
		if(row==col && row%2==1){ //专门处理是方阵，且元素个数为奇数时的情况。
			solu.add(matrix[row/2][col/2]);
		}
		
		return solu;
	}

}
