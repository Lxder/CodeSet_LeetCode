package com131.PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String s = "aas";
		System.out.println(partition(s));
	}
	
	public static List<List<String>> partition(String s) {
		List<List<String>> solu = new ArrayList<List<String>>();
		if(s.length() == 0 ) return solu;
		helper(solu,new ArrayList<String>(),s);
		return solu;
        	 
    }
	
	public static void helper(List<List<String>> solu, List<String> temp , String s){
		if(s.length()==0){
			solu.add(new ArrayList<String>(temp));
			return;
		}
		
		for(int i = 0  ; i< s.length() ; i++){
			if(isPalin(s.substring(0,i+1))){
				List<String> curr = new ArrayList<String>(temp);
				curr.add(s.substring(0,i+1));//将回文子串加入到当前集合
				helper(solu,curr,s.substring(i+1));	
			}
		}
	}
	
	public static boolean isPalin(String s){
		int len = s.length();
		for(int i = 0 , end = s.length()/2; i < end ; i++){
			if(s.charAt(i)!=s.charAt(len-i-1)) return false;
		}
		return true;
	}

}
