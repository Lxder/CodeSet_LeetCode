package com003.substringWithoutRepeat;

import java.util.HashMap;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int maxnum = lengthOfLongestSubstring("cdd");
		System.out.println(maxnum);

	}
	public static int lengthOfLongestSubstring(String s) {
        int maxnum = 0; //最长长度
        int num=0;	//当前长度
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        int start = 0; //开始位置
        Integer temp = null; //下标
        int len = s.length();
        for(int i = 0 ; i <len ; i++){
        	char c = s.charAt(i);  //获取字符
        	temp = (Integer) map.get(c); //在map中寻找c
        	if(temp==null){ //如果不存在，添加进去，长增1
        		map.put(c, i);
        		num++;
        	}
        	else{	//如果map中已经存在，但是是在当前的起始位置之前，可视为不重复，重新设置下标，长度增1
        		if(temp<start){
        			map.put(c, i);
        			num++;
        		}
        		else{	//如果确实重复，那么起始位置更新为重复元素的下一个元素
        			start=temp+1;
        			map.put(c, i); 	//更新下标
        			num = i -start+1;
        		}
        	}
        	if(num>maxnum)
        		maxnum = num;
        }
        
        return maxnum;
    }

}
