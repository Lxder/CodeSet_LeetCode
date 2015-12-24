package com005.LongestPalindromicSubstring;

public class SolutionS2 {

	public static void main(String[] args) {
		//String str = longestPalindrome("bb");
		String str = longestPalindrome("ababccbaaaaeceaa");
		//String str = longestPalindrome("abcba");
		System.out.println("我的最长回文子串为：" + str);

	}

	public static String longestPalindrome(String s) {
		int len = s.length();
		StringBuffer sb = new StringBuffer();
		sb.append("*"); //头部标记
		sb.append("#");
		for(int i = 0 ; i < len ; i++){
			sb.append(s.charAt(i));
			sb.append("#");
		}
		sb.append("^"); //尾部标记
		String str = sb.toString();
		int strlen = str.length()-2;
		
		int maxlen = 0 ; 
		int maxst = 0;
		
		for(int i = 2 ; i < strlen ; i++){
			int st = i;
			int ed = i;
			while(str.charAt(st) == str.charAt(ed)){
				st-- ;
				ed++ ;
			}
			int currlen =  ed - st -1;
			if(currlen > maxlen){
				maxlen = currlen;
				maxst = st+1;
			}
		}
		
		
		StringBuffer solu = new StringBuffer();
		for(int i = maxst ; i <maxst+maxlen ; i++){
			if(str.charAt(i)!='#')
				solu.append(str.charAt(i));
		}		
		return solu.toString();
		
	}
}
