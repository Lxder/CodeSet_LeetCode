package com074.Searcha2DMatrix;

public class Solution {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {  {1,   3,  5,  7},
							{10, 11, 16, 20},
							{23, 30, 34, 50} };
		System.out.println(searchMatrix(matrix,6));
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		if(matrix==null) return false;
		int row = matrix.length; 	//行的数量
		int col = matrix[0].length; //列的数量
		
		int low = 0 ; 
		int high = row*col-1;
		int mid;
		while(low<=high){
			mid = (low+high)/2;
			if(matrix[mid/col][mid%col]<target){
				low = mid+1;
			}else if(matrix[mid/col][mid%col]>target){
				high = mid -1;
			}else return true;
		}
		return false;
	}

}
