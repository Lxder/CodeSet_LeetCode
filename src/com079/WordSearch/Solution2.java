package com079.WordSearch;

public class Solution2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean exist(char[][] board, String word) {
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
	public boolean dfs(char[][] board, boolean[][] visited, 
			int x, int y,String word, int k) {
		//����Ѿ�ƥ�䵽����ˣ�true
		if (k == word.length())
			return true;
		
		//�����һ���±�����ˣ�false
		if (x < 0 || x >= board.length || y < 0 || y >= board[0].length)
			return false;

		//�����ǰԪ���Ѿ����ʣ�false
		if (visited[x][y])
			return false;
		
		//�����ǰԪ�غ�Ҫƥ�����ĸ����ȣ�false
		if (board[x][y] != word.charAt(k))
			return false;

		//����ĸ�������һ�����Եݹ���ʲ��ҵõ����������true
		visited[x][y] = true;
		if (dfs(board, visited, x - 1, y, word, k + 1))
			return true;
		if (dfs(board, visited, x + 1, y, word, k + 1))
			return true;
		if (dfs(board, visited, x, y - 1, word, k + 1))
			return true;
		if (dfs(board, visited, x, y + 1, word, k + 1))
			return true;
		
		//���ĸ����򶼵ò����������ǰ����Ϊδ���ʣ�����false
		visited[x][y] = false; 

		return false;
	}
}
