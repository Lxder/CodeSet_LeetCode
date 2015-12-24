package com008.StringtoInteger;

public class Solution {
	public static void main(String args[]){
		System.out.println(myAtoi("-111"));
		System.out.println(myAtoi("0000"));
		System.out.println(myAtoi("         15"));
		System.out.println(myAtoi("         1asdf67"));
		System.out.println(myAtoi("         2147483648"));
		System.out.println(myAtoi("         -2147483648"));
		System.out.println(myAtoi("         -2147483649"));
		System.out.println(myAtoi("+-5"));
		System.out.println(myAtoi("         010"));
	}
	
	public static int myAtoi(String str) {
		str = str.trim(); //去掉前面的空格
		long solu =0;
		long maxint = Integer.MAX_VALUE;
		int len = str.length();
		boolean isPositive = true;
		boolean flag = false;
		char c ; 
		for(int i = 0 ; i <len ;i++){
			c = str.charAt(i);
			if(c == '-'||c=='+'){
				if(flag == true)
					return 0;
				else{
					if(c=='-')
						isPositive = false;
					flag = true;
				}
			}
			
			else if(c >'9'||c<'0')
				break;
			else {
				solu = solu*10+c-'0';
				if(solu>maxint&&isPositive==true)
					return Integer.MAX_VALUE;
				if(solu>maxint+1&&isPositive == false){
					return Integer.MIN_VALUE;
				}
			}
							
		}
		if( isPositive == false)
			solu = - solu;
		
		return (int)solu;
	}
}
