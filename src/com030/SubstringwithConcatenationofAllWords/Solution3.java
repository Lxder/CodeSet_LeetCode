package com030.SubstringwithConcatenationofAllWords;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution3 {
	public static void main(String args[]){
		String[] words = {"foo","bar","bar"};
		
		String s = "barfoothebarfoobarmanfoobarbar1";
		List<Integer> list = findSubstring(s,words);
		System.out.println(list);
		
	}
	public static List<Integer> findSubstring(String s, String[] words) {
		int num = words.length;
		List<Integer> solu = new LinkedList<Integer>();
		if (num == 0||s==null||s.length()==0)
			return solu;
		int len = words[0].length(); // 注意 数组内所有单词长度都相同
		int lensum = 0; // 保存单词组合的长度

		Map<String,Integer> map_words = new HashMap<String,Integer>();
		for (int i = 0; i < num; i++) {
			if(!map_words.containsKey(words[i]))
				map_words.put(words[i],1); // 将单词添加到集合中
			else{
				map_words.put(words[i], map_words.get(words[i])+1);
			}
			lensum += len;
		}
		
		int slen = s.length(); // 单词长度
		for (int i = 0; i <= slen - lensum; i++) {
			Map<String,Integer> map_curr = new HashMap<String,Integer>();
			int start = i;
			String currstr = s.substring(i, i + len);
			boolean flag = true;
			while (start - i < lensum) {
				if (map_words.containsKey(currstr)) {
					Integer currnum = map_curr.get(currstr);					
					if(currnum!=null&&currnum>=map_words.get(currstr)){
						flag = false;
						break;
					}else{
						if(currnum==null)	map_curr.put(currstr,1);
						else map_curr.put(currstr, map_curr.get(currstr)+1);
						//System.out.println(start+" "+len+"curr"+map_curr);
						start += len;
						if(start+len>slen) break;
						currstr = s.substring(start, start + len);
					}
				} else {
					flag = false;
					break;
				}
			}			
			if (flag==true){				
				solu.add(i);
			}
		}
		return solu;
       
       
    }
	
	
	
}
