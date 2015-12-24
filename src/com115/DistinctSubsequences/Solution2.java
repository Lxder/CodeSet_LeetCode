package com115.DistinctSubsequences;

public class Solution2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "rabbbit", T = "rabbit" ; 
		System.out.println("数量是："+numDistinct(S,T));
	}

	
	public static int numDistinct(String S, String T) {
	    int m = T.length();
	    int n = S.length();
	    if (m > n) return 0;    // impossible for subsequence
	    
	    int[][] path = new int[m+1][n+1];
	    
	    for (int k = 0; k <= n; k++) path[0][k] = 1;    // initialization

	    for (int j = 1; j <= n; j++) {
	        for (int i = 1; i <= m; i++) {
	            path[i][j] = path[i][j-1] + (T.charAt(i-1) == S.charAt(j-1) ? path[i-1][j-1] : 0);
	            //如果currc = T.charAt(i-1) == S.charAt(j-1) ，path[i][j] =path[i][j-1] + path[i-1][j-1] 
	            System.out.print(path[i][j]+"\t");
	            try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	        System.out.println();
	    }

	    return path[m][n];
	}
}
