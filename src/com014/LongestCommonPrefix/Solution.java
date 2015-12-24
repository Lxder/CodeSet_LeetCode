package com014.LongestCommonPrefix;

public class Solution {
	public static void main(String args[]) {
		String[] strarr = {"asdf41312","asdffff","asdfeg","asdfe"};
		String[] strarr2 = {"asdfeee"};
		System.out.println(longestCommonPrefix(strarr));
		System.out.println(longestCommonPrefix(strarr2));
	}

	public static String longestCommonPrefix(String[] strs) {
		int strslen = strs.length;
		if(strslen == 0)
			return "";
		else if(strslen ==1)
			return strs[0];
		int minlen = Integer.MAX_VALUE;
		for(int i = 0 ; i < strslen ; i++){
			if(strs[i].length()<minlen)
				minlen = strs[i].length();
		}
		
		int i ;
		char c;
		for(i = 0 ; i < minlen ; i++){
			c = strs[0].charAt(i);
			int j ;
			for(j = 1 ; j < strslen ; j++){
				if(c!=strs[j].charAt(i)) break;
			}
			if(j!= strslen)
				break;
		}
		return strs[0].substring(0,i);
	}
}
