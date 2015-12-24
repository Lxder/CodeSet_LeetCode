package com318.MaximumProductofWordLengths;


//方法1  暴力破解，三重循环 速度     慢!!!!!!!!!!
public class Solution {
	public static void main(String args[]){
		String[] words = {"a", "aa", "aaa", "aaaa"};
		System.out.println(maxProduct(words));
	}
    public static int maxProduct(String[] words) {
    	int len = words.length ;
    	if(len == 0 || len == 1) return 0;
    	int[][] arr = new int[len][26];
    	for(int i = 0 ; i < len ; i++){
    		int slen = words[i].length();
    		for(int j = 0 ; j <slen ; j++ ){
    			char c = words[i].charAt(j);
    			arr[i][c-'a'] = 1;
    		}
    	}
    	int maxlen = 0;
    	for(int i = 0 ; i < len ;i++){
    		for(int j = i+1 ;j < len ; j++){
    			int slen = words[j].length();
    			int k = 0;
    			for(  ; k < slen ; k++){
    				char c = words[j].charAt(k);
    				if(arr[i][c-'a']==1) break;
    			}
    			if(k==slen && slen*words[i].length()>maxlen){
    				maxlen = slen*words[i].length();
    			}
    		}
    	}
    	return maxlen;
    }
}