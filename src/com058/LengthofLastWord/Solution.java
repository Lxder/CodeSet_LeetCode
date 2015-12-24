package com058.LengthofLastWord;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "";
		System.out.println(lengthOfLastWord(str));
	}

	public static int lengthOfLastWord(String s) {
		int len = s.length();
		
		int i = len -1 ;
		while(i>=0&&s.charAt(i)==' ')
			i--;
		int count = 0;
		for(; i>=0 ; i--){
			if(s.charAt(i)!=' ')
				count++;
			else
				break;
		}
		
		return count;
	}

}
