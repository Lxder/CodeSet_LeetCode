package com306.AdditiveNumber;

import java.math.BigInteger;

public class Solution {
	public static void main(String args[]){
		Solution s = new Solution();
		System.out.println(s.isAdditiveNumber("101"));
	}
    public boolean isAdditiveNumber(String num) {
    	int len = num.length();
    	for(int i = 1 ; i < len ;i++){
    		for(int j = i+1 ; j < len ; j++){
    			if(helper(num,i,j-i)==true)
    				return true;
    		}
    	}
        return false;
    }
    
    public boolean helper(String s, int len1 , int len2 ){
    	if(s.length()<len1+len2) return false;
    	
    	String snum1 = s.substring(0,len1);
    	String snum2 = s.substring(len1,len1+len2);
    	System.out.println(snum1+"|"+snum2);
    	
    	if(snum1.length()!=1&&snum1.charAt(0)=='0' || snum2.length()!=1&&snum2.charAt(0)=='0') return false;
    	BigInteger bsum =new BigInteger(snum1).add(new BigInteger(snum2)) ;
    	
    	String ssum = bsum.toString();
    	if(len1+len2+ssum.length()>s.length()) return false;
    	
    	if(s.substring(len1+len2,len1+len2+ssum.length()).equals(ssum)){
    		if(len1+len2+ssum.length()==s.length()) return true;
    		return helper(s.substring(len1),len2,ssum.length());
    	} else{
    		return false;
    	}
    }
}