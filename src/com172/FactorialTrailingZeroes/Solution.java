package com172.FactorialTrailingZeroes;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(trailingZeroes(2147483647));
	}
	
	public static int trailingZeroes(int n) {
        int num = 0;
        long base = 5 ; 
        
		while(base<=n){  //2�ı���һ����5�ı�����
        	num = (int) (num + n/base) ;
        	base =base*5;
        	System.out.println(base);
        }
		
		return num;
        
    }

}
