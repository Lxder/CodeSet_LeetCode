package com174.DungeonGame;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[][] dungeon = {
//				{-2,-3,3},
//				{-5,-10,1},
//				{10,30,-5}
				{0,0,0},
				{1,1,-1}
		};
		System.out.println(calculateMinimumHP(dungeon));
	}

	public static int calculateMinimumHP(int[][] dungeon) {

		int row = dungeon.length;
		if(row==0) return 0;
		int col = dungeon[0].length;
		int[][] min_arr = new int[row][col];
		int[][] currsum = new int[row][col];
		currsum[0][0] = dungeon[0][0];
		min_arr[0][0] = Math.min(0,dungeon[0][0]);
		for(int i = 1 ; i < col ; i++){
			currsum[0][i]=currsum[0][i-1]+dungeon[0][i];
			min_arr[0][i] = Math.min(min_arr[0][i-1], currsum[0][i]);
			
		}
		for(int i = 1 ;  i< row ; i++){
			currsum[i][0] = currsum[i-1][0] + dungeon[i][0];
			min_arr[i][0] = Math.min(min_arr[i-1][0], currsum[i][0]);
		}
		
		for(int i = 1 ; i < row ; i++){
			for(int j = 1 ; j < col ; j++){
				currsum[i][j]= Math.max(currsum[i][j-1], currsum[i-1][j])+dungeon[i][j];
				if(min_arr[i][j-1]>min_arr[i-1][j]){
					min_arr[i][j] =Math.min(min_arr[i][j-1], Math.max(min_arr[i][j-1], currsum[i][j-1])+dungeon[i][j]);
				}else
					min_arr[i][j] =Math.min(min_arr[i-1][j], Math.max(min_arr[i-1][j],currsum[i-1][j])+dungeon[i][j]);
			}
		}
		
		for(int i = 0 ; i < row ; i++){
			for(int j = 0 ; j < col  ;j++){
				System.out.print(min_arr[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println();
		for(int i = 0 ; i < row ; i++){
			for(int j = 0 ; j < col  ;j++){
				System.out.print(currsum[i][j]+"\t");
			}
			System.out.println();
		}
		
		return -min_arr[row-1][col-1]+1;
		
		
	}

}
