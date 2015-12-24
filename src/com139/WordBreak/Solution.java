package com139.WordBreak;

import java.util.Set;

public class Solution {
	
	public static void main(String args[]){
		
	}
	
	public static boolean wordBreak(String s, Set<String> wordDict) {
		int len = s.length();
		boolean[] arrs = new boolean[len+1];
		arrs[0] = true;
		for(int i= 1 ; i <= len ;i++){
			for(int j = 0 ; j< i ;j++){
				//f(i) = f(0,j)+f(j,i)
				if(arrs[j]==true && wordDict.contains(s.subSequence(j, i))){
					arrs[i] = true;
					break;
				}
			}
		}
		
		return arrs[len];
	}
}
