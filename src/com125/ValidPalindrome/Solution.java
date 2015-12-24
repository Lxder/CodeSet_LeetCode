package com125.ValidPalindrome;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str ="A man, a plan, a canal: Panama" ;
		System.out.println(str. toLowerCase());
		System.out.println(isPalindrome(str));
		System.out.println(isPalindrome("race a car"));
		System.out.println(isPalindrome("ab2a"));
	}

	public static boolean isPalindrome(String s) {
		
		s = s.toLowerCase();
		int start = 0 ;
		int end = s.length()-1;
		while(start<end){
			while((s.charAt(start)<48||s.charAt(start)>57)&&(s.charAt(start)>'z'||s.charAt(start)<'a')&&start<end)
				start++;
			while((s.charAt(end)<48||s.charAt(end)>57)&&(s.charAt(end)>'z'||s.charAt(end)<'a')&start<end)
				end--;
			if(s.charAt(start)!=s.charAt(end))
				return false;
			else{
				start++;
				end--;
			}
		}
		return true;
	}
}
