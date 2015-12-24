package com029.DivideTwoIntegers;

public class Solution {

	public static void main(String args[]){
		System.out.println(divide(100,2));

	}
	
	public  static int divide(int dividend, int divisor) {
	    if(divisor == 0)
	        return Integer.MAX_VALUE;
	    if(dividend == 0)
	        return 0;

	    
	    boolean flag = true; //指示正负号
	    if(dividend <0 && divisor>0||dividend>0&&divisor<0)
	        flag = false;//负号
	    dividend = Math.abs(dividend);
	    divisor = Math.abs(divisor);
	    
	    int solu = 0;
	    while(dividend>=divisor){
	        solu++;

	        dividend-=divisor;
	    }
	    
	    if(flag == false)
	        return -solu;
	    else return solu;
	}

}
