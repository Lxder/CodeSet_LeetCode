package com200.NumberofIslands;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	//DFS��BFS��ֻҪ����һ�飬����һ��1���Ͱ�����Χ����������1�����Ϊ��1��
	//������������������������1�ĸ�����������⡣
	
	
	private int m, n;     
	public int numIslands(char[][] grid) {  
		m = grid.length;
		if(m<=0) return 0;
		n = grid[0].length;
		if(n<=0) return 0;
		int solu = 0;
		for(int i = 0 ; i < m ; i++){
			for(int j = 0 ; j < n ; j++){
				if(grid[i][j]=='1'){
					solu++;
					dfs(grid,i,j);
				}
			}
		}
		return solu;
	}
	
	
	public void dfs(char[][] grid, int i , int j ){
		if(i<0||i>=m||j<0||j>=n) return;
		if(grid[i][j]=='1'){
			grid[i][j]='2';
			dfs(grid,i-1,j);
			dfs(grid,i+1,j);
			dfs(grid,i,j-1);
			dfs(grid,i,j+1);				
		}
	}
	
	
	
	
	
	
//	
//	
//	private int m, n;     
//
//    public int numIslands(char[][] grid) {  
//        m = grid.length;  
//        if (m == 0) return 0;  
//        n = grid[0].length;  
//        if (n == 0) return 0;  
//          
//        int ans = 0;  
//        for (int i = 0; i < m; i++) {  
//            for (int j = 0; j < n; j++) {  
//                if (grid[i][j] != '1') continue;  
//                  
//                ans++;  
//                dfs(grid, i, j);  
//            }  
//        }  
//        return ans;  
//    }  
//      
//      
//    public void dfs(char[][] grid, int i, int j) {  
//        if (i < 0 || i >= m || j < 0 || j >= n) return;  
//          
//        if (grid[i][j] == '1') {  
//            grid[i][j] = '2';  
//            dfs(grid, i - 1, j);  
//            dfs(grid, i + 1, j);  
//            dfs(grid, i, j - 1);  
//            dfs(grid, i, j + 1);  
//        }  
//    }  

}
