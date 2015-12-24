package com003.substringWithoutRepeat;


public class Solution2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int maxnum = lengthOfLongestSubstring("aaaa");
		System.out.println(maxnum);

	}
	public static int lengthOfLongestSubstring(String s) {
        int maxnum = 1;
        int num=1;        
        int start = 0; 
        
        int len = s.length();
        if(len==0)
        	return 0;
        for(int i = 1 ; i <len ; i++){
        	num =1;
        	char c = s.charAt(i);
        	for(int j=i-1; j>=start ; j--){
        		if(c==s.charAt(j)){
        			start = j+1;
        			break;
        		}else{
        			num++;
        		}
        	}
        	if (maxnum<num)
        		maxnum = num;
        }
        
        return maxnum;
    }

}
