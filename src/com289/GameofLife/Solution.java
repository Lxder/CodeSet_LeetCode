package com289.GameofLife;
public class Solution {
	
	
	
	
    public void gameOfLife(int[][] board) {
    	int row = board.length;
    	if(row==0) return;
    	int col = board[0].length;
    	if(col==0) return;
    	int[][] solu = new int[row][col];
    	int currnum = 0;
    	for(int i = 0 ; i < row ; i++){
    		for(int j = 0 ; j < col ; j++){
    			currnum = 0;
    			if(i-1>=0 && j-1>=0 && board[i-1][j-1]==1) currnum++;
    			if(i-1>=0 && board[i-1][j]==1) currnum++;
    			if(i-1>=0 && j+1<col && board[i-1][j+1]==1 ) currnum++;
    			if(j-1>=0 && board[i][j-1]==1) currnum++;
    			if(j+1<col && board[i][j+1]==1)currnum++;
    			if(i+1<row && j-1>=0 && board[i+1][j-1]==1) currnum++;
    			if(i+1<row && board[i+1][j]==1) currnum++;
    			if(i+1<row && j+1<col && board[i+1][j+1]==1) currnum++;
    			
    			if(board[i][j]==1){
    				if(currnum<2||currnum>3) solu[i][j]=0;
    				else if(currnum==2||currnum==3) solu[i][j]=1;
    				else if(currnum>3) solu[i][j]=0;
    			}else{
    				if(currnum==3) solu[i][j]=1;
    			}    			
    		}
    	}
    	
    	for(int i = 0 ; i < row ; i++){
    		for(int j = 0 ; j < col ; j++){
    			board[i][j] = solu[i][j];
    		}
    	}
    }
}