package com166.FractiontoRecurringDecimal;

import java.util.HashMap;

public class Solution {

	
//--------错误版本！！！！！！！！！！！！！
	
	public static void main(String[] args) {
		System.out.println(fractionToDecimal(-50,8));
	}

	//用hashset记录，余数，当余数有相同的时候，则获得一个循环，循环内容为每次的商
	public static String fractionToDecimal(int numerator, int denominator) {		
		HashMap<Long,Integer> rem  = new HashMap<Long,Integer>();//存放余数，和当前余数的位置
		long num = numerator; 
		long den = denominator;
		long partint =  (num/den); //存放整数部分
		
		if(num%den==0) return String.valueOf(partint); //若能整除，返回整数部分
		StringBuffer sb = new StringBuffer();
		if((num>0)^(den>0))
			sb.append("-");		
		
		num = Math.abs(num);
		den = Math.abs(den);		
		long currrem =  (num%den); //存放余数			
		partint = Math.abs(partint);
		sb.append(String.valueOf(partint)+".");
		int div ;		//存放当前位的商
		currrem = (int) (currrem%den);		
		while(!rem.containsKey(currrem) && currrem!=0){ //集合中尚无当前余数			
			rem.put(currrem,sb.length());			
			currrem*=10;
			div = (int) (currrem/den);
			sb.append(div);
			currrem = (int) (currrem%den);			
		}	
		if(currrem!=0){
			sb.insert(rem.get(currrem),"("); 
			sb.append(")");
		}		
		
		System.out.println(rem);				
		System.out.println("整数部分："+partint);
		System.out.println("小数部分："+sb.toString());
		return sb.toString();
		
	}

}
