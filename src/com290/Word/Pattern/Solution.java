package com290.Word.Pattern;

import java.util.HashMap;

public class Solution {
	
	public static void main(String args[]){
		String pattern = "ab";
		String str = "dog dog";
		System.out.println(wordPattern(pattern,str));
	}
	
    public static boolean wordPattern(String pattern, String str) {
        HashMap<Character,String> map_p_s = new HashMap<Character,String>();
        HashMap<String,Character> map_s_p = new HashMap<String,Character>();
        int len = pattern.length();
        String[] strs = str.split("\\s+");
        if(len!=strs.length ) return false;
        for(int i = 0 ; i < len ; i++){
        	char currc = pattern.charAt(i);
        	if(map_p_s.containsKey(currc)){
        		String s = map_p_s.get(currc);
        		if(!s.equals(strs[i])) return false;
        	}else if(map_s_p.containsKey(strs[i])){
        		char c = map_s_p.get(strs[i]);
        		if(c!=currc) return false;
        	}else{
        		map_p_s.put(currc, strs[i]);
        		map_s_p.put(strs[i],currc);
        	}
        }
        return true;
    }
}