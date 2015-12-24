package com174.DungeonGame;

public class Solution2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[][] dungeon = {
//				{-2,-3,3},
//				{-5,-10,1},
//				{10,30,-5}
				{0,0,0},
				{1,1,-1}
		};
		System.out.println(calculateMinimumHP(dungeon));
	}
//http://blog.csdn.net/ljiabin/article/details/42616291
	
	public static int calculateMinimumHP(int[][] dungeon) {  
        int row = dungeon.length;  
        int col = dungeon[0].length;  
          
        int[][] ans = new int[row][col];  
          
        //初始化最后一行和最后一列  
        ans[row - 1][col - 1] = dungeon[row - 1][col - 1] > 0 ? 0 : -dungeon[row - 1][col - 1];  
        for (int i = row - 2; i >= 0; i--) {  
            ans[i][col - 1] = dungeon[i][col - 1] >= ans[i + 1][col - 1] ? 0 : ans[i + 1][col - 1] - dungeon[i][col - 1];  
        }  
        for (int j = col - 2; j >= 0; j--) {  
            ans[row - 1][j] = dungeon[row - 1][j] >= ans[row - 1][j + 1] ? 0 : ans[row - 1][j + 1] - dungeon[row - 1][j];  
        }  
          
        //从右下角往左上角遍历  
        for (int i = row - 2; i >= 0; i--) {  
            for (int j = col - 2; j >= 0; j--) {  
                int down = dungeon[i][j] >= ans[i + 1][j] ? 0 : ans[i + 1][j] - dungeon[i][j];  
                int right = dungeon[i][j] >= ans[i][j + 1] ? 0 : ans[i][j + 1] - dungeon[i][j];  
                ans[i][j] = Math.min(down, right);  
            }  
        }  
        
        for(int i = 0 ; i < row ; i++){
			for(int j = 0 ; j < col  ;j++){
				System.out.print(ans[i][j]+"\t");
			}
			System.out.println();
		}
          
        //要保证勇士活着，至少需要1魔力  
        return ans[0][0] + 1;  
    }  

}
