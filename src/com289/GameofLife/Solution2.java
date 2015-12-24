package com289.GameofLife;
public class Solution2 {
	
// States:
//  00 : dead to dead
//  01 : live to dead
//  10 : dead to live
//  11 : live to live
	
//低位表示原来状态，高位表示新状态
	
	
	public void gameOfLife(int[][] board) {  
		int row = board.length;
    	if(row==0) return;
    	int col = board[0].length;
    	if(col==0) return;
    	
	    for(int i=0; i<row; i++) {  
	        for(int j=0; j<col; j++) {  
	            int x = getLiveNum(board, i, j);  
	            if(board[i][j] == 0) {  
	                if(x==3) board[i][j]=2;  
	            } else {  
	                if(x==2 || x==3) board[i][j]=3;       
	            }  
	        }  
	    }  
	      
	    for(int i=0; i<row; i++) {  
	        for(int j=0; j<col; j++) {  
	            board[i][j] /= 2;   
	        }  
	    }  
	}  
	      
	private int getLiveNum(int[][] board, int x, int y) {  
	    int c=0;  
	    for(int i=x-1; i<=x+1; i++) {  
	        for(int j=y-1; j<=y+1; j++) {  
	            if(i<0 || j<0 || i>board.length-1 || j>board[0].length-1 || (i==x && j==y)) continue;  
	            if(board[i][j]%2==1) c++;  //根据原来状态判断周围到底多少个live
	        }  
	    }  
	    return c;  
	}  
}