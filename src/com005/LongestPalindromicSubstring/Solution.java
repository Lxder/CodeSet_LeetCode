package com005.LongestPalindromicSubstring;

public class Solution {

	public static void main(String[] args) {
		//String str = longestPalindrome("ababcbaaaaa");
		String str = longestPalindrome("ababccbaaaaeceaa");
		System.out.println("最长回文子串为" + str);

	}

	public static String longestPalindrome(String s) {
		int len = s.length();
		
		//回文是单数的情况，求出最长回文
		int maxmid = 0; //中间位置
		int max = 0; //数量的一半+1 例如 回文长为7 那么max是4
		//单数的情况
		for (int mid = 0; mid < len; mid++) {
			for (int i = mid, j = mid; i >= 0 && j < len; i--, j++) {
				if (s.charAt(i) == s.charAt(j)) {
					if (max < j - mid + 1) {
						max = j -mid+1;
						maxmid = mid;
					}
				}
				else break;
			}
		}
		
		//回文是双数的情况，求出最长回文
		int maxmid2 = 0; //中心位置（偏左侧的那个，例如 abccba，那么maxmid2指示第一个c）
		int max2 = 0; // 长度/2+1
		for (int mid2 = 0; mid2 < len; mid2++) {
			for (int i = mid2, j = mid2+1; i >= 0 && j < len; i--, j++) {
				if (s.charAt(i) == s.charAt(j)) {
					if (max2 < j - mid2 + 1) {
						max2 = j -mid2+1;
						maxmid2 = mid2;
					}
				}
				else break;
			}
		}
		if(max2>max){
			System.out.println("maxmid2:"+maxmid2+" max2:"+max2);
			return (String) s.subSequence(maxmid2-max2+2, maxmid2+max2);
		}else{
			System.out.println("maxmid:"+maxmid+" max:"+max);
			return (String) s.subSequence(maxmid-max+1, maxmid+max);			
		}
	}
}
