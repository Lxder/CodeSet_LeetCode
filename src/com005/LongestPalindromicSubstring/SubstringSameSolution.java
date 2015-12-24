package com005.LongestPalindromicSubstring;

public class SubstringSameSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = longestSameSubstring("dabcabd","dbabcaeefbd");
		System.out.println("最长公共子串为"+str);

	}

	public static String longestSameSubstring(String strA ,String strB) {
		int lenA = (int) strA.length();
	    int lenB = (int) strB.length();
	    int maxi = 0;
	    int maxlen = 0;
	    //c[i][j]存放的为子串相似的数量。（因为c的边界不算）
	    int[][] c = new int[lenA + 1][lenB + 1];
	    // Record the distance of all begin points of each String
	    // 初始化边界
	    for (int i = 0; i <= lenA; i++)
	        c[i][0] = 0;
	    for (int j = 0; j <= lenB; j++)
	        c[0][j] = 0;
	    c[0][0] = 0;
	    //递推求出所有c元素
	    for (int i = 1; i <= lenA; i++)
	        for (int j = 1; j <= lenB; j++) {
	            if (strB.charAt(j - 1) == strA.charAt(i - 1)){
	                c[i][j] = c[i - 1][j - 1]+1;
	                if(c[i][j]>maxlen){
	                	maxi = i;
	                	maxlen=c[i][j];
	                }
	            }
	            else
	                c[i][j] = 0;
	        }

	    for (int i = 0; i <= lenA; i++) {
	        for (int j = 0; j <= lenB; j++) {
	            System.out.print(c[i][j] + " ");
	        }
	        System.out.println();
	    }
	    System.out.println("最大长度"+maxlen);
	    int start = maxi-maxlen;

	    return (String) strA.subSequence(start, maxi);
	    
    }
}
