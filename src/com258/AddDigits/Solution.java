package com258.AddDigits;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addDigits(210));

	}
	
	public static int addDigits(int num) {
        int solu = num ;
        while(num/10!=0){
        	solu = 0;
			while(num!=0){
		        solu = solu+num%10;
		        num = num/10;
		    }
			num = solu;
        }
		
		return solu;
    }

}
