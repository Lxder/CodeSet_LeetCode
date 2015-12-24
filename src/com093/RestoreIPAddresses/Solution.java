package com093.RestoreIPAddresses;

import java.util.LinkedList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s ="010010";
		//System.out.println(s.substring(0,1));
		System.out.println(restoreIpAddresses(s));

	}

	public static List<String> restoreIpAddresses(String s) {
		List<String> solu = new LinkedList<String>();
		StringBuffer sb = new StringBuffer();
		
		helper(s,solu,sb,4);
		return solu;
	}
	
	public static void helper(String str , List<String> solu, StringBuffer sb, int num){
		if(num==0&&str.length()==0){
			solu.add(sb.toString().substring(0,sb.length()-1));
			return ;
		}
		if(num*3<str.length()){ 
			System.out.println("不行："+num+" "+str);
			return;
		
		}
		for(int i = 1 ; i <= 3&&i<=str.length() ; i++){
			int curr = Integer.valueOf(str.substring(0,i));
			if(String.valueOf(curr).length()<i) continue;
			System.out.println("当前分段："+curr+" 已存分段："+sb+" 剩余分段："+(num-1));
			if(curr<256){
				helper(str.substring(i),solu,
						new StringBuffer(sb).append(str.substring(0,i)+"."),
						num-1);
			}
		}
		
	}
}
