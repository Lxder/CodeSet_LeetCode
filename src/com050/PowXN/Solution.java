package com050.PowXN;

public class Solution {
	public static void main(String args[]){
		System.out.println(myPow(-1, 214748364));
	}
	public static double myPow(double x, int n) {
		if(x==1) return 1;
		if(x==-1){
			if(n%2==0) return 1;
			else return -1;
		}
		
		double solu = 1;
		boolean flag =false;
		if(n<0) flag = true;
		n = Math.abs(n);
		double temp = x;
		while(n != 0){
			solu = solu*temp;
			n--;
			if(solu<Double.MIN_NORMAL&& solu>0 ) return 0;
			if(solu>Double.MAX_VALUE) 
				return Double.MAX_VALUE;
			
		}
		if(flag == true) return 1.0/solu;
		return solu;
	}
}
