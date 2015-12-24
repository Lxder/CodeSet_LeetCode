package com205.IsomorphicStrings;

import java.util.HashMap;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isIsomorphic("paper","title"));

	}

	public static boolean isIsomorphic(String s, String t) {
		int len = s.length();
		int index = 0;
		HashMap<Character, Integer> maps = new HashMap<Character ,Integer>();
		HashMap<Character, Integer> mapt = new HashMap<Character ,Integer>();
		for(int i = 0 ; i < len ; i++){
			char s1 = s.charAt(i);
			char t1 = t.charAt(i);			
			if(maps.get(s1)==null&&mapt.get(t1)==null){				
				maps.put(s1, index);
				mapt.put(t1, index);
				index++;
			}else if(maps.get(s1)!=mapt.get(t1)){				
				return false;
			}
		}
		return true;
	}

}
