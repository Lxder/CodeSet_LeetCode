package com079.WordSearch;

public class Solution3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {
				{'a'}
		};
		
		
		String word = "a";
		System.out.println(exist(board,word));
		
		
	}

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
		//如果有一个下标过界了，false
		if (i < 0 || i >= row || j < 0 || j >= col)
			return false;
		if(dyn[i][j]!=0) return false;		
		if(board[i][j]!=str.charAt(loc))return false;
		dyn[i][j]++;	
			
		if(	helper(str,loc+1,dyn,board,i,j+1)) return true;
		if( helper(str,loc+1,dyn,board,i+1,j)) return true;	
		if( helper(str,loc+1,dyn,board,i,j-1)) return true;
		if( helper(str,loc+1,dyn,board,i-1,j)) return true; 
		

		dyn[i][j]=0; //四个方向都没有找到；
			
		
		return false;
		
	}

}
