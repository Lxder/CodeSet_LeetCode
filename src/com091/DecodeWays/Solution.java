package com091.DecodeWays;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numDecodings("9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253"));
	}

//----------使用递归，大数据超时！！！！！！！！！！！！！
	
	public static int numDecodings(String s ){
		int len = s.length();
		if(len==0|| len ==1) return 1;
		int totalnum =0;
		if(len>=2){
			int num =Integer.valueOf(s.substring(0,2));
			if(num<=26) {
				totalnum = numDecodings(s.substring(1))+numDecodings(s.substring(2));
			}else{
				totalnum = numDecodings(s.substring(1));
			}
		}
		return totalnum;
	}

}
