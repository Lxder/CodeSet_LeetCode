package com005.LongestPalindromicSubstring;

public class Solution2 {

	public static void main(String[] args) {
		//String str = longestPalindrome("bb");
		String str = longestPalindrome("ababccbaaaaeceaa");
		//String str = longestPalindrome("abcba");
		System.out.println("最长回文子串为" + str);

	}

	public static String longestPalindrome(String s) {
		int len = s.length();
		
		//isPalindrome[i][j]=true 表示从i到j的子串为回文
		boolean[][] isPalindrome = new boolean[len][len];
		for(int i = 0 ; i < len ; i++){
			isPalindrome[i][i] =true;	//单个元素为回文
		}
		for(int i = 0 ; i < len-1 ; i++){
			isPalindrome[i+1][i] =true;	//将对角线下一行也设置为true，方便下面只有两个元素的时候进行比较的情况
		}
		
		int maxlen = 1;
		int maxi = 0 ; 
		int maxj = 0;
		
		for(int i = 1 ; i < len ; i++){			
			for(int n = 0 ; n<len-i ;n++){ //这里的i为最长回文长度-1
				if(isPalindrome[n+1][i+n-1]==true&&s.charAt(n)==s.charAt(i+n)){
					isPalindrome[n][i+n]=true;
					if(maxlen<=i){ //更新最长长度
						maxlen = i+1;
						maxi=n;
						maxj=i+n;						
					}
				}
				else isPalindrome[n][i+n]=false;
				
			}			
		}
		for(int i = 0 ; i < len ; i++){ //输出结果数组
			for(int j = 0   ;j < len ;j ++){
				System.out.print(isPalindrome[i][j]+"\t");
			}
			System.out.println();
		}
		return (String)s.substring(maxi,maxj+1);
	}
}
