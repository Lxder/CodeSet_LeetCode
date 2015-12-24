package com030.SubstringwithConcatenationofAllWords;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


//´íÎó½â·¨
public class Solution {
	public static void main(String args[]){
		String[] words = new String[2];
		words[0] = "foo";
		words[1] = "bar";
		String s = "barfoothefoobarman";
		List list = findSubstring(s,words);
		Iterator itr = list.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}
	public static List<Integer> findSubstring(String s, String[] words) {
        int len = words.length;
        List<Integer> solu = new ArrayList<Integer>();
        for(int i = 0 ; i < len ; i ++){
        	solu.add(strStr(s, words[i]));
        }
        return solu;
    }
	
	
	//ËÑË÷×Ó´®
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
