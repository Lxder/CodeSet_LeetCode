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
				 //从每一个元素开始进行深搜，只要找到一个可行方案即可返回true
				if(dfs(board,visited,i,j,word,0))
					return true;
			}
		}
		return false;
	}

	//采用深搜
	public boolean dfs(char[][] board, boolean[][] visited, 
			int x, int y,String word, int k) {
		//如果已经匹配到最后了，true
		if (k == word.length())
			return true;
		
		//如果有一个下标过界了，false
		if (x < 0 || x >= board.length || y < 0 || y >= board[0].length)
			return false;

		//如果当前元素已经访问，false
		if (visited[x][y])
			return false;
		
		//如果当前元素和要匹配的字母不相等，false
		if (board[x][y] != word.charAt(k))
			return false;

		//如果四个方向有一个可以递归访问并且得到结果，返回true
		visited[x][y] = true;
		if (dfs(board, visited, x - 1, y, word, k + 1))
			return true;
		if (dfs(board, visited, x + 1, y, word, k + 1))
			return true;
		if (dfs(board, visited, x, y - 1, word, k + 1))
			return true;
		if (dfs(board, visited, x, y + 1, word, k + 1))
			return true;
		
		//若四个方向都得不到结果，当前设置为未访问，返回false
		visited[x][y] = false; 

		return false;
	}
}
