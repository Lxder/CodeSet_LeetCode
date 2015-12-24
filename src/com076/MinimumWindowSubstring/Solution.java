package com076.MinimumWindowSubstring;

import java.util.HashMap;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minWindow("vva","va"));
	}

	//同编程之美3.5 最短摘要的生成
	public static String minWindow(String s, String t) {
		int len_s = s.length();
		int len_t = t.length();
		int minlen = Integer.MAX_VALUE; //最短长度
		int minstart  = Integer.MIN_VALUE;
		int minend = Integer.MIN_VALUE;
		int start=0 ; 
		int end=0;
		
		
		HashMap<Character,Integer> map_t = new HashMap<Character,Integer>(); //用于保存t内的字符，方便以后查找
		HashMap<Character,Integer> map_tcount = new HashMap<Character,Integer>(); //用于保存t内的字符的具体数量
		for(int i = 0 ; i < len_t ; i++){
			map_t.put(t.charAt(i),0);
			Integer curr =map_tcount.get(t.charAt(i)) ; 
			if(curr==null){				
				map_tcount.put(t.charAt(i),1);				
			}
			else
				map_tcount.put(t.charAt(i),map_tcount.get(t.charAt(i))+1);
		}
		System.out.println(map_t);
		System.out.println(map_tcount);
		int tcount = 0;
		for(int i = 0 ; i < len_s ; i++){
			Integer currc = map_t.get(s.charAt(i));
			if(currc!=null){ 	//如果map内存在该字符,说明已经添加进去了
				if(tcount==0) start = minstart = i;
				if(currc<map_tcount.get(s.charAt(i)))
					tcount++;
								
				map_t.put(s.charAt(i),	map_t.get(s.charAt(i))+1);
			
			}
			if(tcount == len_t){ //已经找到一个集合
				end = minend = i; //指向结尾，（结尾包含在集合内）
				minlen = minend-minstart;
				break;
			}
		}
				
		System.out.println("开始位置:"+minstart+" 结束位置："+minend+" 长度："+minlen+" 数量:"+tcount);
		
		if(minlen==Integer.MAX_VALUE) return "";
		
		start = minstart ;
		while(start< len_s){
			System.out.println(map_t);
			char currchar = s.charAt(start);
			int cnum = map_t.get(currchar);
			if(cnum==1&&end==len_s-1) break;
			System.out.println("当前元素："+currchar+" 剩余数量："+cnum);
			if(cnum==map_tcount.get(currchar)){ //要除掉的字母在集合中只有一个了，需要从end开始向后找第一个与要除掉的字母相同的字母
				map_t.put(currchar,	cnum-1);
				
				for(int i = end+1 ; i < len_s ; i++){
					Integer currc = map_t.get(s.charAt(i)); //向后获取元素
					if(currc!=null){ //若当前元素是集合内的字母，需要更新字母的数量
						map_t.put(s.charAt(i),	currc+1);
					}
					if(s.charAt(i)==currchar){//若当前字母为要寻找的字母，则可确定结尾位置
						end = i; //更新结尾位置
						break;
					}
				}				
				System.out.print("PART1:");				
			}
			else{ //要除掉的字母在集合中不止一个,从start开始向后找第一个与要除掉的字母相同的字母			
				map_t.put(currchar,cnum-1); //更新集合内相应字母的数量
				
				System.out.print("PART2:");
			}

			//更新start位置
			for(int i = start+1 ; i < end ; i++){
				Integer currc = map_t.get(s.charAt(i)); //向后获取元素
				if(currc!=null){ //若当前元素是集合内的字母，需要更新起始位置
					start = i;
					break;
				}					
			}
			
			//如果数量不满足条件，则结束
			if(map_t.get(currchar)<map_tcount.get(currchar)){
				break;
			}
			
			
			//两种情况都需要更新start的位置
			//第一种情况必然更新end位置
			//第二种不需要更新end			
			System.out.println("开始位置:"+start+" 结束位置："+end+" 长度："+(end-start));

			if(end-start<minlen){
				minlen =end-start;
				minstart = start ;
				minend = end;
			}
			
			System.out.println("minstart: "+minstart+" minend:"+minend+" minlen:"+minlen);
			//if(flag ==true) break;
		}

		return s.substring(minstart,minend+1);
	}

}
