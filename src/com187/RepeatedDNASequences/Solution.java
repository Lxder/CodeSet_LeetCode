package com187.RepeatedDNASequences;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "AAAAACCCCCAAAAACCCCCAAAAACCCCCAAAAACCCCCAAAAACCCCCAAAAACCCCCAAAAAGGGTTT";
		List<String> solu = findRepeatedDnaSequences(s);
		System.out.println(solu);
		System.out.println(solu.size());
		
		
	}

	public static List<String> findRepeatedDnaSequences(String s) {
		int[] char2int = new int[26];
		char2int[0] = 0;
		char2int['C'-'A']=1;
		char2int['G'-'A']=2;
		char2int['T'-'A']=3;
		
		HashMap<Integer,Integer> dnamap = new HashMap<Integer,Integer>();
		
		List<String> solu = new LinkedList<String>();
		int len = s.length();
		String currstr;
		for(int i=0 ; i < len-9 ; i++ ){
			currstr = s.substring(i,i+10);
			int currint=0;
			for(int j = 0 ; j < 10 ; j++){
				currint  = currint <<2;
				currint = currint|char2int[currstr.charAt(j)-'A'];
			}			
			
			if(dnamap.containsKey(currint)){
				dnamap.put(currint,dnamap.get(currint)+1);
			}else
				dnamap.put(currint, 1);		
			
			if(dnamap.get(currint)==2)
				solu.add(currstr);
		}		
		return solu;
	}

}
