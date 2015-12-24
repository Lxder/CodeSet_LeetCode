package com316.RemoveDuplicateLetters;

//̰�ķ� 
public class Solution {
	public static void main(String args[]){
		Solution s = new Solution();
		System.out.println(s.removeDuplicateLetters("cbacdcbc"));
	}
	public String removeDuplicateLetters(String s) {
		int[] cnt = new int[26];
		int pos = 0; // ��С�ַ���λ��
		//����ÿһ�����ֵ�����
		for (int i = 0; i < s.length(); i++)
			cnt[s.charAt(i) - 'a']++;
		//��ǰ�������ַ�����ÿһ���ַ���ÿ����һ���ַ����ͽ���Ӧ��������1,
		//�����ǰ�������ַ�С����С���ַ�����ô������С�ַ�Ϊ��ǰ���ַ�����������ַ���λ�á�
		//ֱ��ĳ���ַ�������Ϊ0��ֹͣ������֮ǰ������Ǹ���С�ַ�����ͷ����
		//Ȼ��ɾ����С�ַ�λ�ú������������С�ַ���ͬ���ַ�������ͬ�ַ�ֻ�ܳ���һ�Σ�
		//���Ժ�����ַ��ݹ��������Ĳ���
		
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

