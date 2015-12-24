package com212.WordSearchII;

import java.util.LinkedList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {
				{'o','a','a','n'},
				{'e','t','a','e'},
				{'i','h','k','r'},
				{'i','f','l','v'}
		};
		String[] words = {"oath","pea","eat","rain"};
		System.out.println(findWords(board,words));
	}
//-----------------��ʱ��������������������������������
//����1����79��word search1�Ļ����ϸĽ�����ÿһ���ַ������в��ң�����ҵ��������������	
	public static List<String> findWords(char[][] board, String[] words) {
		int len = words.length;
		List<String> solu = new LinkedList<String>();
		
		for(int i = 0 ; i < len ; i++){
			if(exist(board,words[i])==true)
				solu.add(words[i]);
		}
		return solu;
	}
	
	
	public static boolean exist(char[][] board, String word) {
		int row = board.length;
		if(row == 0)return word.isEmpty();
		int col = board[0].length;
		if(col == 0) return word.isEmpty();
		boolean[][] visited = new boolean[row][col];
		for(int i = 0 ; i < row ; i++){
			for(int j = 0 ; j < col ; j++){
				 //��ÿһ��Ԫ�ؿ�ʼ�������ѣ�ֻҪ�ҵ�һ�����з������ɷ���true
				if(dfs(board,visited,i,j,word,0))
					return true;
			}
		}
		return false;
	}

	//��������
	public static boolean dfs(char[][] board, boolean[][] visited, 
			int x, int y,String word, int k) {
		if (k == word.length())
			return true;
		
		if (x < 0 || x >= board.length || y < 0 || y >= board[0].length)
			return false;

		if (visited[x][y])
			return false;

		if (board[x][y] != word.charAt(k))
			return false;

		visited[x][y] = true;
		if (dfs(board, visited, x - 1, y, word, k + 1))
			return true;
		if (dfs(board, visited, x + 1, y, word, k + 1))
			return true;
		if (dfs(board, visited, x, y - 1, word, k + 1))
			return true;
		if (dfs(board, visited, x, y + 1, word, k + 1))
			return true;

		visited[x][y] = false; 
		return false;
	}
}
