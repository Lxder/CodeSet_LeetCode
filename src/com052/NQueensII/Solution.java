package com052.NQueensII;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	public static void main(String args[]){
		System.out.println(totalNQueens(9));
	}
	public static int totalNQueens(int n) {
		
		return helper(0,0,n);
	}

	private final static Set<Integer> setCols = new HashSet<Integer>();
	private final static Set<Integer> setDiag1s = new HashSet<Integer>();
	private final static Set<Integer> setDiag2s = new HashSet<Integer>();
	public static int helper(int row , int count ,int n){
		for(int col = 0 ; col < n ; col++){
			if(setCols.contains(col)) continue;
			int diag1s = row+col; 
			if(setDiag1s.contains(diag1s)) continue ;//���Խ����Ƿ��ظ� 
			int diag2s = row-col;
			if(setDiag2s.contains(diag2s)) continue ; //����һ�߶Խ����Ƿ��ظ�

			if(row==n-1) count++; //�Ѿ����е����һ����˵�������������
			else{
				setCols.add(col);
				setDiag1s.add(diag1s);
				setDiag2s.add(diag2s);
				count = helper(row+1,count,n);
				
				setCols.remove(col);
				setDiag1s.remove(diag1s);
				setDiag2s.remove(diag2s);
			}
		}
		return count;
		
		
	}
}
