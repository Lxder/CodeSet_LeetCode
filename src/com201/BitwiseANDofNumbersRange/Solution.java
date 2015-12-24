package com201.BitwiseANDofNumbersRange;

public class Solution {

	public static void main(String args[]){
		System.out.println(rangeBitwiseAnd(0,0));
	}
	public static int rangeBitwiseAnd(int m, int n) {
		
		
		int solu = 0 ;
		int base = 1<<30;
		System.out.println(base);
		for(int i = 30 ; i >=0 ; i--){
			System.out.println("base "+base+" m&base"+(m&base));
			if((m&base)!=(n&base)){
				break;
			}
			else if(((m&base)>>i)==0){
				base = base>>1;
				continue;
			}
			System.out.println("µ±Ç°solu "+solu);
			solu = solu|base;
			base = base>>1;
			
					
		}
		return solu;
	}
}
