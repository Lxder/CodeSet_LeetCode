package com214.ShortestPalindrome;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(shortestPalindrome("abcd"));
	}

	public static String shortestPalindrome(String s) {
		int len = s.length();
		if(len==0||len==1) return s;
		int sarrlen= 2*len-1;
		char[] sarr = new char[sarrlen];
		for(int i = 0 ,j=0;i<sarrlen-2 ; i++){ //保持要处理的字符串为奇数
			sarr[i++]=s.charAt(j++);
			sarr[i] = '*';			
		}
		sarr[sarrlen-1] = s.charAt(len-1);
		for(int i= 0 ; i < sarrlen ; i++){
			System.out.println(sarr[i]);
		}
		int mid = sarrlen/2;
		int smid = 0;
		for(int i = mid ; i>=0 ; i--){
			if(isPalin(sarr,i)==true){
				smid = i;
				break;
			}
		}
		
		int slen = (sarrlen-smid)*2-1;
		char[] solu = new char[slen];
		int m = smid+1;
		for(int i = 1,currmid = slen/2; i<sarrlen-smid ; i++){
			solu[currmid+i] = sarr[m];
			solu[currmid-i] = sarr[m];
			m++;			
		}
		solu[slen/2] = sarr[smid];
		StringBuffer sb = new StringBuffer();
		for(int i= 0;i< slen  ; i++){
			if(solu[i]!='*')
				sb.append(solu[i]);
		}
		return sb.toString();		
	}
	
	public static boolean isPalin(char[] sarr  , int mid){
		for(int i = mid ; i>0 ; i--){
			if(sarr[mid+i]!=sarr[mid-i])
				return false;			
		}
		return true;
	}
}
