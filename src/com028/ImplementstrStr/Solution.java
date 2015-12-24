package com028.ImplementstrStr;

public class Solution {

	public static void main(String[] args) {
		String haystack = "aaffsdffddsaaaef";
		String needle = "ddsaa";
	
		System.out.println("¿ªÊ¼ËÑË÷...");
		int i = strStr( haystack, needle);
		System.out.println(i);

	}

	// ËÑË÷×Ó´®
	public static int strStr(String haystack, String needle) {		
		int lenhay = haystack.length();
		int lenneed = needle.length();		
		if(lenneed==0)
			return 0;
		else if(lenhay==0)
			return -1;
		int next[] = GetNextval(needle);
		int i = 0, j = 0, v;
		
		while (i < lenhay && j < lenneed) {
			if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
				i++;
				j++;
			} else
				j = next[j];
		}
		if (j >= lenneed)
			v = i - lenneed;
		else
			v = -1;
		return v;
	}

	public static int[] GetNextval(String str) {
		int j, k;
		int nextval[] = new int[str.length()];
		j = 0;
		k = -1;
		nextval[0] = -1;
		int len = str.length();
		while (j < len - 1) {
			if (k == -1 || str.charAt(j) == str.charAt(k)) {
				j++;
				k++;
				if (str.charAt(j) != str.charAt(k)) {
					nextval[j] = k;
				} else
					nextval[j] = nextval[k];
			} else
				k = nextval[k];
		}
		return nextval;
	}

}
