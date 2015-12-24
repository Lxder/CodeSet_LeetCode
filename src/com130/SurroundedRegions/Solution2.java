package com130.SurroundedRegions;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

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
		Solution2 s = new Solution2();
		s.solve(board);
		for(int i = 0 ; i < board.length ; i++){
			for(int j =0 ; j < board[0].length ; j++){
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}

	public int row , col;
	public void solve(char[][] board) {
		row = board.length;
		if(row==0) return ;
		col = board[0].length;
		if(row<=2||col<=2) return ;

		//通过BFS，将所有与边界联通的0都变成2
		for(int i = 0 ; i < row ; i++){
			if(board[i][0]=='O'){
				bfs(board,i,0);
			}
			if(board[i][col-1]=='O'){
				bfs(board,i,col-1);
			}
		}
		
		for(int i = 0 ; i < col ; i++){
			if(board[0][i]=='O'){
				bfs(board,0,i);
			}
			if(board[row-1][i]=='O'){
				bfs(board,row-1,i);
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
	
	
	Queue<Integer> queue = new LinkedList<Integer>();
	public void fill(char[][] board, int x, int y) {
		if (x < 0 || x >= row || y < 0 || y >= col || board[x][y] != 'O')
			return;
		queue.offer(x * col + y);
		board[x][y] = '2';
	}

	void bfs(char[][] board, int x, int y) {
		fill(board, x, y);

		while (!queue.isEmpty()) {
			int curr = queue.poll();
			int i = curr / col;
			int j = curr % col;

			fill(board, i - 1, j);
			fill(board, i + 1, j);
			fill(board, i, j - 1);
			fill(board, i, j + 1);
		}
	}

}
