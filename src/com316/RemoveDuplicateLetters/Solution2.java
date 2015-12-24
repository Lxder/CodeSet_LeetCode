package com316.RemoveDuplicateLetters;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//错误方法！！超时且结果不对！！！
public class Solution2 {
	public static void main (String args[]){
		Solution2 s = new Solution2();
		System.out.println(s.removeDuplicateLetters("cadvdfcbc"));
	}
	
    public String removeDuplicateLetters(String s) {
    	int len = s.length();
    	HashSet<Character> set = new HashSet<Character>();
    	for(int i = 0 ; i < len ; i++){
    		set.add(s.charAt(i));
    	}
    	int diffs = set.size();
    	Set<String> solu = new HashSet<String>();
    	helper( s , solu , new StringBuffer() , diffs);
    	System.out.println(diffs);
    	Iterator<String> itr =  solu.iterator();
    	String minstr = itr.next();
    	while(itr.hasNext()){
    		String curr = itr.next();
    		if(curr.compareTo(minstr)<0)
    			minstr = curr;
    	}
    	System.out.println(solu);
    	return minstr;
    }
    
    public void helper(String s , Set<String> solu , StringBuffer curr , int len){
    	if(len == curr.length()){
    		//System.out.println(curr);
    		solu.add(curr.toString());
    	}
    	int slen = s.length();
    	if(slen==0) return ;
    	for(int i = 0 ; i < slen ; i++){
    		StringBuffer nsb = new StringBuffer(curr);
    		char c_curr = s.charAt(i);
    		for(int j = 0 ; j < nsb.length() ; j++){
    			if(nsb.charAt(j)==c_curr){    			
    				nsb.delete(j, j+1);   
    				//System.out.println(nsb);
    				break;
    			} 
    		}
    		nsb.append(c_curr);
			helper(s.substring(1),solu,nsb,len);
    	}
    }
}