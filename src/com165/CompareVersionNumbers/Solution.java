package com165.CompareVersionNumbers;

public class Solution {

	public static void main(String args[]){
		System.out.println(compareVersion("1","1.0.0"));
	}	
	
	public static int compareVersion(String version1, String version2) {
		String[] str1 = version1.split("\\."); 
		String[] str2 = version2.split("\\.");
		int len1 = str1.length;
		int len2 = str2.length;
		int t = 0; 
		
		
		while(t<len1&&t<len2){
			if(Integer.valueOf(str1[t])>Integer.valueOf(str2[t]))
				return 1;
			else if(Integer.valueOf(str1[t])<Integer.valueOf(str2[t]))
				return -1;
			else{
				t++;
			}
		}
		
		if(t==len1&&t==len2)
			return 0;
		
		if(t!=len1){
			while(t<len1){
				if(Integer.valueOf(str1[t])!=0)
					break;
				t++;
			}
			if(t==len1) return 0;
			return 1;
		}
		else {
			while(t<len2){
				if(Integer.valueOf(str2[t])!=0)
					break;
				t++;
			}
			if(t==len2) return 0;
			return -1;
		}
		
	}
}
