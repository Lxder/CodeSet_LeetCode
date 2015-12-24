package com130.SurroundedRegions;

public class Solution {

	public static void main(String[] args) {
		char[][] board = {
				{'X','X', 'X', 'X'},
				{'X', 'O', 'O', 'X'},
				{'X', 'X', 'O', 'X'},
				{'X', 'O', 'X', 'X'}
		};
//		char[][] board = {
//				{'O','O', 'O'},
//				{'O', 'O', 'O'},
//				{'O', 'O', 'O'}
//		};
		Solution s = new Solution();
		s.solve(board);
		for(int i = 0 ; i < board.length ; i++){
			for(int j =0 ; j < board[0].length ; j++){
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}

	}

	//大数据stack overflow (利用了深搜)
	public int row , col;
	public void solve(char[][] board) {
		row = board.length;
		if(row==0) return ;
		col = board[0].length;
		if(row<=2||col<=2) return ;

		//通过深搜，将所有与边界联通的0都变成2
		for(int i = 0 ; i < row ; i++){
			if(board[i][0]=='O'){
				dfs(board,i,0);
			}
			if(board[i][col-1]=='O'){
				dfs(board,i,col-1);
			}
		}
		
		for(int i = 0 ; i < col ; i++){
			if(board[0][i]=='O'){
				dfs(board,0,i);
			}
			if(board[row-1][i]=='O'){
				dfs(board,row-1,i);
			}
		}
				
		for(int i = 0 ; i < row ; i++){
			for(int j = 0 ;j < col ; j++){
				if(board[i][j]=='2')
					board[i][j]='O';
				else if(board[i][j]=='O')
					board[i][j] = 'X';
			}
		}

		
	}
	
	
	//深搜
	public void dfs(char[][] board, int i , int j){
		if(i<0||i>=row||j<0||j>=col) return;
		if(board[i][j]=='O'){
			board[i][j]='2';
			dfs(board,i-1,j);
			dfs(board,i+1,j);
			dfs(board,i,j-1);
			dfs(board,i,j+1);			
		}
			
	}

}
