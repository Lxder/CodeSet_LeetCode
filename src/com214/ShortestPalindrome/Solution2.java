package com214.ShortestPalindrome;

public class Solution2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(shortestPalindrome("abcdd"));
	}

	//思想正确，但是超时！！！！！！！！！！！！！！！
	public static String shortestPalindrome(String s) {
		int len = s.length();
		
		StringBuffer sb = new StringBuffer(s);
		String s2 = sb.reverse().toString();
		int i;
		for( i = len ; i >=0 ; i--){
			if(s2.substring(len-i).equals(s.substring(0, i)))
				break;
		}
		
		return s2.substring(0,len)+s.substring(i);
	}
}
