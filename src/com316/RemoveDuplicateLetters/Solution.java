package com316.RemoveDuplicateLetters;

//贪心法 
public class Solution {
	public static void main(String args[]){
		Solution s = new Solution();
		System.out.println(s.removeDuplicateLetters("cbacdcbc"));
	}
	public String removeDuplicateLetters(String s) {
		int[] cnt = new int[26];
		int pos = 0; // 最小字符的位置
		//计算每一个数字的数量
		for (int i = 0; i < s.length(); i++)
			cnt[s.charAt(i) - 'a']++;
		//从前向后遍历字符串的每一个字符，每遍历一个字符，就将对应的数量减1,
		//如果当前遍历的字符小于最小的字符，那么更新最小字符为当前的字符，保存这个字符的位置。
		//直到某个字符的数量为0，停止操作，之前保存的那个最小字符就是头部，
		//然后删除最小字符位置后面的所有与最小字符相同的字符，（相同字符只能出现一次）
		//最后对后面的字符递归进行上面的操作
		
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch < s.charAt(pos))
				pos = i;
			if (--cnt[ch - 'a'] == 0)
				break;
		}
		
		if(s.length() == 0) 
			return "";
		else{
			String nextstr =s.substring(pos+1).replaceAll(String.valueOf(s.charAt(pos)), "");
			return s.charAt(pos)+removeDuplicateLetters(nextstr);
		}
			
		
	}
}

/*Given the string s, the greedy choice (i.e., the leftmost letter in the answer) is the smallest s[i], s.t. the suffix s[i .. ] contains all the unique letters. (Note that, when there are more than one smallest s[i]'s, we choose the leftmost one. Why? Simply consider the example: "abcacb".)
 * After determining the greedy choice s[i], we get a new string s' from s by

removing all letters to the left of s[i],
removing all s[i]'s from s.
We then recursively solve the problem w.r.t. s'.

The runtime is O(26 * n) = O(n).
 * */

