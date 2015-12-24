package com085.MaximalRectangle;

import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] matrix = {
				{'1','1','0','1','0','1'},
				{'0','1','1','1','0','1'},
				{'1','1','1','1','0','1'},
				{'1','1','1','1','0','1'},
				{'1','1','0','1','0','1'}
		};
		System.out.println(maximalRectangle(matrix));
	}

	public static int maximalRectangle(char[][] matrix) {
		
		int row = matrix.length;
		if(row==0) return 0;
		int col = matrix[0].length;
		if(col==0) return 0;
		
		int solu = 0;
				
		int[][] totalnum = new int[row][col];
		
		for(int i = 0 ; i < col ; i++){
			totalnum[0][i] = matrix[0][i]-48; //ASCII和数字的转换			
		}
		
		for(int i = 1 ; i < row ; i++){
			for(int j = 0 ; j < col ; j++){
				if(matrix[i][j]=='1')
					totalnum[i][j] = totalnum[i-1][j]+1;
				else totalnum[i][j] = 0;
			}
		}
		
		for (int i = 0; i < row; i++) {
			int curr = 0;
			Stack<Integer> stack = new Stack<Integer>();
			for (int j = 0; j < col; j++) {
				if (stack.isEmpty() || stack.peek() < totalnum[i][j]) {
					stack.push(totalnum[i][j]);
				} else { // 将所有比height[i]大的的都出栈，用height[i]代替
					int count = 0; // 记录出栈次数
					while ((!stack.isEmpty()) && stack.peek() > totalnum[i][j]) {
						count++;
						curr = Math.max(curr, count * stack.peek());
						stack.pop();
					}
					
					while (count != 0) {
						count--;
						stack.push(totalnum[i][j]); // 用height[i]代替出栈的元素
					}
					stack.push(totalnum[i][j]);// 将当前的元素添加进去
				}
			}

			// 处理最后一个元素
			int count = 0;
			while (!stack.isEmpty()) {
				count++;
				curr = Math.max(curr, count * stack.pop());
			}
			if (curr > solu)
				solu = curr;
		}		
		return solu;
	}

}
