package com063.UniquePathsII;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length; //������
        if(m==0) return 0 ;
        int n = obstacleGrid[0].length; //������
		if(n==0) return 0;
		
		int[][] solu = new int[m][n];		
		for(int i = 0 ; i < m ; i++){ //��0����Ϊ1
			if(obstacleGrid[i][0]==1) //��������ϰ�����ô�ϰ��Լ��ϰ���ȫΪ0
				break;
			else solu[i][0] = 1;			
		}
		
		for(int j = 0 ; j < n ; j++){ //��0����Ϊ1
			if(obstacleGrid[0][j]==1)
				break;
			solu[0][j] = 1;
		}
		
		for(int i = 1 ; i < m ; i++){
			for(int j = 1 ; j < n ; j++)
				if(obstacleGrid[i][j]==1)
					solu[i][j]=0;
				else
					solu[i][j] = solu[i][j-1]+solu[i-1][j];
		}
		
		return solu[m-1][n-1];
	}

}
