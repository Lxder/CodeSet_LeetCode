package com079.WordSearch;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {
				{'a','b','c','e'},
				{'s','f','c','s'},
				{'a','d','e','e'}
		};
		
		
		String word = "fc";
		System.out.println(exist(board,word));
		
		
	}

	//------------原始超复杂版。
	static int row ; 
	static int col ;
	public static boolean exist(char[][] board, String word) {
		row = board.length;
		if(row == 0)return word.isEmpty();
		col = board[0].length;
		if(col == 0) return word.isEmpty();
		int[][] dyn = new int[row][col];	
		
		for(int i = 0 ; i < row ; i++){
			for(int j = 0 ; j < col ; j++){
				if(helper(word,0,dyn,board,i,j)) return true;
			}
		}
		return false;
	}
	
	public static boolean helper(String str, int loc, int[][] dyn , char[][] board,int i, int j){
		if(loc==str.length()) {
			return true;
		}
		if(dyn[i][j]!=0) return false;		
		
		System.out.println("前进！当前："+str.charAt(loc)+ "匹配："+board[i][j]);
		if(j+1<col&&board[i][j]==str.charAt(loc)&&dyn[i][j+1]==0){ // 可以向右
			dyn[i][j]++;
			if(helper(str,loc+1,dyn,board,i,j+1)) return true;
		}
		if(i+1<row && board[i][j]==str.charAt(loc)&&dyn[i+1][j]==0){
			dyn[i][j]++;
			if( helper(str,loc+1,dyn,board,i+1,j)) return true;
		}				

		if(j-1>=0 && board[i][j]==str.charAt(loc)&&dyn[i][j-1]==0){
			dyn[i][j]++;
			if( helper(str,loc+1,dyn,board,i,j-1)) return true;
		}

		if(i-1>=0 && board[i][j]==str.charAt(loc)&&dyn[i-1][j]==0){
			dyn[i][j]++;
			if( helper(str,loc+1,dyn,board,i-1,j)) return true; 
		}

		dyn[i][j]=0; //四个方向都没有找到；
		return false;
		
	}

}
