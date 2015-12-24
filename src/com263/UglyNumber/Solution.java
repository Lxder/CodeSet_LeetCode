package com263.UglyNumber;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isUgly(11));

	}

	public static  boolean isUgly(int num) {
		if (num==0) return false;
		boolean flag = true;
		for(int i = 2 ; i<= 5 ; i++){
			flag = true;
			while(flag ==true){
				if(num%i!=0)
					flag = false;
				else 
					num = num/i;
				
			}
		}
		
		if(num==1) return true;
		else return false;
	}

}
