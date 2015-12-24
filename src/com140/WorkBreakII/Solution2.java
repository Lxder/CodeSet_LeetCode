package com140.WorkBreakII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution2 {

	public static void main(String args[]) {
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		Set<String> dict = new HashSet<String>();
		dict.add("a");
		dict.add("aa");
		dict.add("aaa");
		dict.add("aaaa");
		dict.add("aaaaa");
		dict.add("aaaaaa");
		dict.add("aaaaaaa");
		dict.add("aaaaaaaa");
		dict.add("aaaaaaaaa");
		dict.add("aaaaaaaaaa");

		// String s = "catanddog";
		// Set<String>dict = new HashSet<String>();
		// dict.add("cat");
		// dict.add("cats");
		// dict.add("and");
		// dict.add("sand");
		// dict.add("dog");
		System.out.println(wordBreak(s, dict));
	}

	public static List<String> wordBreak(String s, Set<String> dict) {
		List<String> result = new ArrayList<String>();
		for (int j = s.length() - 1; j >= 0; j--) {
			if (dict.contains(s.substring(j)))
				break;
			else {
				if (j == 0)
					return result;
			}
		}
// π”√µ›πÈ
		for (int i = 0; i < s.length() - 1; i++) {
			if (dict.contains(s.substring(0, i + 1))) {
				List<String> strs = wordBreak(s.substring(i + 1, s.length()),dict);
				if (strs.size() != 0)
					for (Iterator<String> it = strs.iterator(); it.hasNext();) {
						result.add(s.substring(0, i + 1) + " " + it.next());
					}
			}
		}
		if (dict.contains(s))
			result.add(s);
		return result;
	}

}
