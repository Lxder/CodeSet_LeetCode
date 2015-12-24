package com051.NQueens;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<String>> solu = solveNQueens(5);
		System.out.println(solu);

	}

	public static List<List<String>> solveNQueens(int n) {
		List<List<String>> solu = new ArrayList<List<String>>();
		helper(solu,new ArrayList<String>(),0,n);
		return solu;
	}
	
	private final static Set<Integer> setCols = new HashSet<Integer>();
	private final static Set<Integer> setDiag1s = new HashSet<Integer>();
	private final static Set<Integer> setDiag2s = new HashSet<Integer>();
	
	public static void helper(List<List<String>> solu, List<String> curr,int row ,int n){
		boolean  flag =true;
		StringBuffer str = new StringBuffer();		
		for(int col = 0 ; col < n ; col++){
			int index = 0;
			if(flag==true){			
				str = new StringBuffer();
				while(index<col){
					str.append(".");
					index++;
				}
				flag = false;
			}			
			
			if(setCols.contains(col)) {
				str.append(".");
				continue;
			}
			int diag1s = row+col; 
			if(setDiag1s.contains(diag1s)){//看对角线是否重复
				str.append(".");
				continue ; 
			}
			int diag2s = row-col;
			if(setDiag2s.contains(diag2s)) {//看另一边对角线是否重复
				str.append(".");
				continue ; 
			}

			if(row==n-1){ //已经进行到最后一个，将当前情况添加到结果集
				str.append("Q");				
				for(index = col+1;index<n; index++){
					str.append(".");
				}	
				
				curr.add(new String(str.toString()));
				System.out.println(curr);
				solu.add(curr);
				
			}
			else{
				setCols.add(col);
				setDiag1s.add(diag1s);
				setDiag2s.add(diag2s);				
				
				StringBuffer sb = new StringBuffer(str);
				sb.append("Q");
				for (index = col+1 ; index<n ; index++){
					sb.append(".");
				}
				
				flag = true;
				List<String> temp = new ArrayList<String>(curr);				
				temp.add(new String(sb.toString()));
				helper(solu,temp,row+1,n);		
				
				setCols.remove(col);
				setDiag1s.remove(diag1s);
				setDiag2s.remove(diag2s);
			}
		}		
	}
	
}
