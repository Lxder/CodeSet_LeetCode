package com171.ExcelSheetColumnNumber;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(titleToNumber("Z"));
	}

	public  static int titleToNumber(String s) {
		int len = s.length();
		int solu = 0;
		for(int i = 0 ; i < len ; i++){
			solu = solu*26 +(s.charAt(i)-64);
		}
		return solu;
	}
	
	

}
