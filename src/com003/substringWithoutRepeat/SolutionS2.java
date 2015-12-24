package com003.substringWithoutRepeat;

import java.util.HashMap;

public class SolutionS2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int maxnum = lengthOfLongestSubstring("aaaa");
		System.out.println(maxnum);

	}
	public static int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        int maxlen = 0;	//��󳤶�
        int currlen = 0; //��ǰ����
        int len = s.length();
        int start = 0;
        for(int i = 0 ; i < len ; i++ ){
        	char c = s.charAt(i);
        	Integer curr = map.get(c);
        	if(curr==null){ //��ǰ�Ӵ�û�������ĸ
        		map.put(c, 1);
        		currlen++;        		
        	}else{ //��ǰ�Ӵ����������ĸ����ǰ��������ĸ֮ǰ����ĸ��ɾȥ        		
        		if(currlen>maxlen) maxlen = currlen;
        		while(s.charAt(start)!=c){ //startֻ������ƶ�
        			map.remove(s.charAt(start));
        			start++;
        			currlen--;
        		}        
        		start++;
        	
        	}
        }
        
        if(currlen>maxlen)
        	maxlen = currlen;
        return maxlen;
    }

}
