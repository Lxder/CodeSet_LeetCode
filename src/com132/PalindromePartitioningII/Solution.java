package com132.PalindromePartitioningII;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		
		//String s = "ababababababababababababcbabababababababababababa";
		String s = "ababaa";
		System.out.println(minCut(s));
	}
	
	//注意！！！！！！！！！！！对于上面被注释掉的s，会超时。！！！！！！！！！！！！！
	public static int minCut(String s) {
		List<List<String>> solu = new ArrayList<List<String>>();
		if(s.length() == 0 ) return 0;
		
		helper(solu,new ArrayList<String>(),s);
		int mincut = Integer.MAX_VALUE;
		int len = solu.size();
		for(int i = 0 ; i < len ;i++ ){
			if(solu.get(i).size()<mincut)
				mincut = solu.get(i).size();
		}
		return mincut-1;		
    }
	
	public static void helper(List<List<String>> solu, List<String> temp , String s){
		if(s.length()==0){
			solu.add(new ArrayList<String>(temp));
			return;
		}		
		for(int i = 0  ; i< s.length() ; i++){
			if(isPalin(s.substring(0,i+1))){
				temp.add(s.substring(0,i+1)); //将回文子串加入到当前集合
				helper(solu,temp,s.substring(i+1));
				//System.out.println(temp);
				temp.remove(temp.size()-1); //移除最后一个元素				
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
