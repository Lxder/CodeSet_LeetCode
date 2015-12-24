package com242.ValidAnagram;

import java.util.HashMap;

public class Solution {
	public static void main(String args[]){
		System.out.println(isAnagram("",""));
	}
	public static boolean isAnagram(String s, String t) {
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		char c;
		Integer cnum;
		
		int len = s.length();		
		if(len != t.length())  return false;
		
		for(int i = 0 ; i < len ; i++){ //³õÊ¼»¯
			c = s.charAt(i);
			cnum = map.get(c);
			if(cnum==null)
				map.put(c, 1);
			else
				map.put(c, cnum+1);
		}
		
		for(int i = 0 ; i < len ; i++){
			c = t.charAt(i);
			cnum = map.get(c);
			if(cnum==null) return false;
			else if(cnum==1) map.remove(c);
			else map.put(c, cnum-1);			
		}
		return true;
	}
}
