package com087.ScrambleString;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//String str = "asdf";
		//System.out.println(str.substring(0,3));
		System.out.println(isScramble("abcd","badc"));

	}

	public static boolean isScramble(String s1, String s2) {
		if (s1.length() != s2.length())
			return false; // 如果两个字符串长度不同，则一定不可能
		int len = s1.length();
		if (len == 1)
			return s1.equals(s2);

		char[] str1 = s1.toCharArray();
		char[] str2 = s2.toCharArray();
		Arrays.sort(str1);
		Arrays.sort(str2);
		// 判断两个字符串排序后是否相等。如果不相等，则一定不可能
		for (int i = 0; i < len; i++) {
			if (str1[i] != str2[i])
				return false;
		}

		String s11, s12, s21, s22;
		boolean res = false;
		for (int i = 1; i < len ; ++i) {
			s11 = s1.substring(0, i);
			s12 = s1.substring(i, len);
			s21 = s2.substring(0, i);
			s22 = s2.substring(i, len);
			System.out.println(s11 + " " + s12);
			System.out.println(s21 + " " + s22);
			res = isScramble(s11, s21) && isScramble(s12, s22);
			if (res == false) {
				s21 = s2.substring(0, len - i);
				s22 = s2.substring(len - i, len);
				System.out.println("呵呵 "+s21 + " " + s22);
				res = isScramble(s11, s22) && isScramble(s12, s21);
			}
			if(res == true ) return true;
		}
		return res;
	}
}
