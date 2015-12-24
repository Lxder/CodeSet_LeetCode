package com010.RegularExpressionMatching;

public class Solution {

	public static void main(String[] args) {

		System.out.println(isMatch("aaassdff","a*s*df.f"));
		System.out.println(isMatch("aa","a"));
		System.out.println(isMatch("ab",".*c"));
		System.out.println(isMatch("aaa","a*a"));
		System.out.println(isMatch("","b."));
		System.out.println(isMatch("aaa", "ab*a*c*a"));
		System.out.println(isMatch("aaa", "aaaa"));
		System.out.println(isMatch("", ".*"));
		System.out.println(isMatch("aa", ".*"));
		System.out.println(isMatch("a", "ab*"));
		

	}

	public static boolean isMatch(String s, String p) {
		if (p.length() == 0)
			return s.length() == 0;

		// p�ĳ�����1�����,����p��0��ʼ����1λ����'*'�������
		if (p.length() == 1 || p.charAt(1) != '*') {
			if (s.length() < 1 || (p.charAt(0) != '.' && s.charAt(0) != p.charAt(0)))
				return false;
			return isMatch(s.substring(1), p.substring(1));

		} else { // p�ĳ��ȴ���1�����
			// case 2.1: һ���ַ�����'*'��ͬ����0��Ԫ�ص����
			if (isMatch(s, p.substring(2))) {
				return true;
			}

			// case 2.2: һ���ַ�����'*'��ͬ����1������Ԫ�ص����
			// ��ÿһ���Ӵ����г���
			int i = 0;
			while (i < s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
				if (isMatch(s.substring(i + 1), p.substring(2))) {
					return true;
				}
				i++;
			}
			return false;
			
		}
	}

}
