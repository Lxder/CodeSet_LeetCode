package com003.substringWithoutRepeat;

import java.util.HashMap;

public class SolutionS2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int maxnum = lengthOfLongestSubstring("aaaa");
		System.out.println(maxnum);

	}
	public static int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        int maxlen = 0;	//最大长度
        int currlen = 0; //当前长度
        int len = s.length();
        int start = 0;
        for(int i = 0 ; i < len ; i++ ){
        	char c = s.charAt(i);
        	Integer curr = map.get(c);
        	if(curr==null){ //当前子串没有这个字母
        		map.put(c, 1);
        		currlen++;        		
        	}else{ //当前子串里已这个字母，将前面的这个字母之前的字母都删去        		
        		if(currlen>maxlen) maxlen = currlen;
        		while(s.charAt(start)!=c){ //start只会向后移动
        			map.remove(s.charAt(start));
        			start++;
        			currlen--;
        		}        
        		start++;
        	
        	}
        }
        
        if(currlen>maxlen)
        	maxlen = currlen;
        return maxlen;
    }

}
