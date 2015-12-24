package com214.ShortestPalindrome;

public class Solution3 {
	public static void main(String args[]){
		System.out.println(shortestPalindrome("abcdd"));
	}
    public static String shortestPalindrome(String s) {
        if(s.length()<=1) return s;
        String new_s = s+"#"+new StringBuilder(s).reverse().toString();
        System.out.println(new_s);
        int[] position = new int[new_s.length()];

        for(int i=1;i<position.length;i++) {
            int pre_pos = position[i-1];
            while(pre_pos>0 && new_s.charAt(pre_pos)!=new_s.charAt(i))
                pre_pos = position[pre_pos-1];
            position[i] = pre_pos+((new_s.charAt(pre_pos)==new_s.charAt(i))?1:0); //如果两个字母相等，则下次比较直接从下一个比即可
        }

        return new StringBuilder(s.substring(position[position.length-1])).reverse().toString()+s;
    }
}
