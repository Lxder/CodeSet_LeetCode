package com013.RomantoInteger;

import java.util.HashMap;

public class Solution {

	public static void main(String args[]) {
		System.out.println( romanToInt("MMMDCCCXCIV") );
		System.out.println( romanToInt("M") );
		System.out.println( romanToInt("I") );
	}

	public static int romanToInt(String s) {
		int solu = 0;
		String[] numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		HashMap<String,Integer> romanint = new HashMap<String, Integer>();
		int len = values.length;
		for(int i = 0 ; i < len ; i++){
			romanint.put(numerals[i], values[i]);
		}		
		
		int strlen = s.length();
		char curr ;
		char next ;
		int i ;
		
		for(i = 0  ; i < strlen-1 ; i++){			
			curr = s.charAt(i);
			next = s.charAt(i+1);
			String str = new String()+curr+next;			
			
			Integer n = romanint.get(str);
			if(n!=null){ //如果前后两个字符组成的字符串不属于numerals(不可能是罗马数字表示形式)
				solu += n; //直接把第一个数字加在结果上
				i++;
				System.out.println(str);
			}else{
				System.out.println(curr);
				solu += romanint.get(new String()+curr); //前后两个字符组成的字符串是罗马数字表示形式，将结果累加
			}
		}
		if(i<strlen){ //判断最后一个罗马字符是否已经处理
			solu+=romanint.get(new String()+s.charAt(i));
		}
		return solu;
	}

}
