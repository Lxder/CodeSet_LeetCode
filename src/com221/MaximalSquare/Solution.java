package com221.MaximalSquare;

import java.util.Stack;


//方法1：利用85题的方法，正方形就是特殊的矩形，计算面积时边长设置为长和宽的最小值
public class Solution {

	public static void main(String args[]){
		char[][] matrix = {
				{'1','1','0','1','0','1'},
				{'0','1','1','1','0','1'},
				{'1','1','1','1','0','1'},
				{'1','1','1','1','0','1'},
				{'1','1','0','1','0','1'}
		};
		
		int times = 10000;
		System.out.println(maximalSquare(matrix));
		long starttime = System.currentTimeMillis();
		for(int i = 0 ; i< times ; i++ )
			maximalSquare(matrix);
		long endtime = System.currentTimeMillis();
		System.out.println((endtime-starttime)/times);
	}
	
	public static int maximalSquare(char[][] matrix) {
		int row = matrix.length; //行数
		if(row==0) return 0 ;
		int col = matrix[0].length; //列数
		if(col==0) return 0;
		
		int[][] dynarr = new int[row][col]; //用于动态规划的数组
		for(int i = 0 ; i < col ; i++){
			dynarr[0][i]=matrix[0][i]-48;			
		}
		
		for(int i = 1 ; i < row ; i++){
			for(int j = 0 ; j <col ; j++){
				if(matrix[i][j] =='1')
					dynarr[i][j] = dynarr[i-1][j]+1;
				else
					dynarr[i][j] = 0;
			}
		}
		
//		for(int i = 0 ; i < row ; i++){
//			for(int j = 0 ; j < col ; j++){
//				System.out.print(dynarr[i][j]+" ");
//			}
//			System.out.println();
//		}

		
		
		int solu = 0;

		for (int i = 0; i < row; i++) {
			int curr = 0;
			Stack<Integer> stack = new Stack<Integer>();
			for (int j = 0; j < col; j++) {
				if (stack.isEmpty() || stack.peek() < dynarr[i][j]) {
					stack.push(dynarr[i][j]);
				} else { // 将所有比height[i]大的的都出栈，用height[i]代替
					int count = 0; // 记录出栈次数
					while ((!stack.isEmpty()) && stack.peek() > dynarr[i][j]) {
						count++;
						curr = Math.max(curr, Math.min(count*count, stack.peek()*stack.peek()));
						stack.pop();
					}

					while (count != 0) {
						count--;
						stack.push(dynarr[i][j]); // 用height[i]代替出栈的元素
					}
					stack.push(dynarr[i][j]);// 将当前的元素添加进去
				}
			}
			// 处理最后一个元素
			int count = 0;
			while (!stack.isEmpty()) {
				count++;
				curr = Math.max(curr, Math.min(count*count, stack.peek()*stack.pop()));
			}
			if (curr > solu)
				solu = curr;
		}		
		return solu;
		
	}
}
