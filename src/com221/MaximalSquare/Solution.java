package com221.MaximalSquare;

import java.util.Stack;


//����1������85��ķ����������ξ�������ľ��Σ��������ʱ�߳�����Ϊ���Ϳ����Сֵ
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
		int row = matrix.length; //����
		if(row==0) return 0 ;
		int col = matrix[0].length; //����
		if(col==0) return 0;
		
		int[][] dynarr = new int[row][col]; //���ڶ�̬�滮������
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
				} else { // �����б�height[i]��ĵĶ���ջ����height[i]����
					int count = 0; // ��¼��ջ����
					while ((!stack.isEmpty()) && stack.peek() > dynarr[i][j]) {
						count++;
						curr = Math.max(curr, Math.min(count*count, stack.peek()*stack.peek()));
						stack.pop();
					}

					while (count != 0) {
						count--;
						stack.push(dynarr[i][j]); // ��height[i]�����ջ��Ԫ��
					}
					stack.push(dynarr[i][j]);// ����ǰ��Ԫ����ӽ�ȥ
				}
			}
			// �������һ��Ԫ��
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
