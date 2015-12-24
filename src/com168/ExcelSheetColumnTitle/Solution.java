package com168.ExcelSheetColumnTitle;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convertToTitle(26*26+27));
	}
	
	public static String convertToTitle(int n) {
		StringBuffer sb = new StringBuffer();
		while(n!=0){
			sb.append((char) ((n-1) % 26+65));
			n=(n-1)/26;
		}
		return sb.reverse().toString();
    }

}
