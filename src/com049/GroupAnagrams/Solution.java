package com049.GroupAnagrams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"} ;
		Arrays.sort(strs);
		for(int i = 0  ; i < strs.length ; i++ ){
			System.out.println(strs[i]);
		}
		System.out.println(groupAnagrams(strs));
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		Arrays.sort(strs);
		int len = strs.length;
		Map<String,List<String>> solu_map = new HashMap<String,List<String>>();
		
		for(int i = 0 ; i < len ; i++){
			char[] currstr = strs[i].toCharArray();
			Arrays.sort(currstr);
			String str_sorted = String.valueOf(currstr);
			
			if(!solu_map.containsKey(str_sorted)){
				List<String> currlist = new LinkedList<String>();
				currlist.add(strs[i]);
				solu_map.put(str_sorted,currlist);
			}else{
				solu_map.get(str_sorted).add(strs[i]);
			}			
		}
		
		List<List<String>> solu = new LinkedList<List<String>>();
		
		for (Map.Entry<String, List<String>> entry : solu_map.entrySet()) {
		   solu.add(entry.getValue());
		}
		
		return solu;
	}

}
