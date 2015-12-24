package com036.ValidSudoku;

import java.util.HashMap;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {
				{'.','.','4','.','.','.','6','3','.'},
				{'.','.','.','.','.','.','.','.','.'},				
				{'5','.','.','.','.','.','.','9','.'},
				{'.','.','.','5','6','.','.','.','.'},
				{'4','.','3','.','.','.','.','.','1'},
				{'.','.','.','7','.','.','.','.','.'},
				{'.','.','.','.','.','.','.','.','.'},
				{'.','.','.','.','.','.','.','.','.'},
				{'.','.','.','.','.','.','.','.','.'}
		};
		System.out.println(isValidSudoku(board));
	}

	public static boolean isValidSudoku(char[][] board) {
		
		HashMap<Character,Integer>[] maprow = new HashMap[9];//横行
		HashMap<Character,Integer>[] mapcol = new HashMap[9];//竖行
		HashMap<Character,Integer>[] maprect = new HashMap[9];//方格
		for(int i = 0 ; i < 9 ; i++){
			maprow[i] = new HashMap<Character,Integer>();
			mapcol[i] = new HashMap<Character,Integer>();
			maprect[i] = new HashMap<Character,Integer>();
		}
		
		for(int i = 0 ; i < 9 ; i++){
			for(int j = 0 ; j < 9 ; j++){
				if(board[i][j]=='.') continue;
				Integer irow = maprow[i].get(board[i][j]);
				Integer icol = mapcol[j].get(board[i][j]);
				Integer irect = maprect[i/3*3+j/3].get(board[i][j]);
				if(irow==null&&icol==null&&irect==null){
					maprow[i].put(board[i][j], 1);
					mapcol[j].put(board[i][j], 1);
					maprect[i/3*3+j/3].put(board[i][j], 1);
				}
				else return false;
			}
		}
		return true;
 	}

}
