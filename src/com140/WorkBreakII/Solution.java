package com140.WorkBreakII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {

	public static void main(String args[]) {
		String s= "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"; 
		Set<String>dict = new HashSet<String>();
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
		
	
//		String s = "catanddog";
//		Set<String>dict = new HashSet<String>();
//		dict.add("cat");
//		dict.add("cats");
//		dict.add("and");
//		dict.add("sand");
//		dict.add("dog");
		System.out.println(wordBreak(s,dict));
	}
//原来超时了！！！！！！！！！！！！！！！！！！！！！！！但是加上前面注明的部分就没问题
	public static List<String> wordBreak(String s, Set<String> wordDict) {
		///////////////////专治超时///////////////////////////
		for(int j = s.length() - 1; j >= 0; j--){
	        if(wordDict.contains(s.substring(j)))
	            break;
	        else{
	            if(j == 0)
	                return new ArrayList<String>();
	        }
	    }
		/////////////////////////////////////////////////////
		
		HashMap<Integer,List<String>> solu = new HashMap<Integer,List<String>>(); 
		int len = s.length();
		boolean[] arr = new boolean[len + 1];
		arr[0] = true;
		for (int i = 1; i <= len; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] == true && wordDict.contains(s.substring(j, i))) {
					arr[i] = true;
					
					
					List<String> temp;
					if(solu.get(j)!=null){
						temp = new LinkedList<String>(solu.get(j));
						for(int k = 0 ; k < temp.size() ; k++){
							String str = temp.get(k)+" "+s.substring(j,i);
							temp.set(k, str);
						}
					}
					else{
						temp = new LinkedList<String>();
						temp.add(s.substring(j,i));
					}			
					
					if(solu.get(i)==null)
						solu.put(i,temp);
					else
						for(int k = 0 ; k< temp.size(); k++){
							solu.get(i).add(temp.get(k));
						}
				}
			}
			System.out.println(solu);
		}
		if(solu.get(len)==null) return new ArrayList<String>();
		return solu.get(len);
		
	}

}
