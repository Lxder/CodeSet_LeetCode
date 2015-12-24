package com003.substringWithoutRepeat;

import java.util.HashMap;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int maxnum = lengthOfLongestSubstring("cdd");
		System.out.println(maxnum);

	}
	public static int lengthOfLongestSubstring(String s) {
        int maxnum = 0; //�����
        int num=0;	//��ǰ����
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        int start = 0; //��ʼλ��
        Integer temp = null; //�±�
        int len = s.length();
        for(int i = 0 ; i <len ; i++){
        	char c = s.charAt(i);  //��ȡ�ַ�
        	temp = (Integer) map.get(c); //��map��Ѱ��c
        	if(temp==null){ //��������ڣ���ӽ�ȥ������1
        		map.put(c, i);
        		num++;
        	}
        	else{	//���map���Ѿ����ڣ��������ڵ�ǰ����ʼλ��֮ǰ������Ϊ���ظ������������±꣬������1
        		if(temp<start){
        			map.put(c, i);
        			num++;
        		}
        		else{	//���ȷʵ�ظ�����ô��ʼλ�ø���Ϊ�ظ�Ԫ�ص���һ��Ԫ��
        			start=temp+1;
        			map.put(c, i); 	//�����±�
        			num = i -start+1;
        		}
        	}
        	if(num>maxnum)
        		maxnum = num;
        }
        
        return maxnum;
    }

}
