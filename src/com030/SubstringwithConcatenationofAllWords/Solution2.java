package com030.SubstringwithConcatenationofAllWords;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

//不正确，不能解决words数组有重复的情况
public class Solution2 {
	public static void main(String args[]){
		String[] words = {"word","best","good","good"};
		
		String s = "wordbestgoodgoodgoodbestword";
		List<Integer> list = findSubstring(s,words);
		System.out.println(list);
		
	}
	public static List<Integer> findSubstring(String s, String[] words) {
		int num = words.length;
		List<Integer> solu = new LinkedList<Integer>();
		if (num == 0)
			return solu;
		int len = words[0].length(); // 注意 数组内所有单词长度都相同
		int lensum = 0; // 保存单词组合的长度

		Set<String> set_words = new HashSet<String>();
		
		for (int i = 0; i < num; i++) {
			set_words.add(words[i]); // 将单词添加到集合中
			lensum += len;
		}
		
		

		int slen = s.length(); // 单词长度

		for (int i = 0; i <= slen - len; i++) {

			Set<String> set_curr = new HashSet<String>();
			int start = i;
			String currstr = s.substring(i, i + len);
			
			while (start <= slen-len && start - i < lensum) {
				if (set_words.contains(currstr)) {
					if(set_curr.contains(currstr)){
						set_curr = new HashSet<String>();
						start+=len;
					}else{
						set_curr.add(currstr);
						System.out.println(start+" "+len+"curr"+set_curr);
						start += len;
						if(start>=slen) break;
						currstr = s.substring(start, start + len);
					}
				} else {
					break;
				}
			}
			System.out.println("数量："+num);
			
			if (set_curr.size()==num){				
				solu.add(i);
			}

		}
		return solu;
       
       
    }
	
	
	
}
