package com204.CountPrimes;

public class Solution {

	public static void main(String args[]){
		System.out.println("½á¹û£º"+countPrimes(100));
	}
	public static int countPrimes(int n) {
		if(n<=2) return 0;
		if(n==3) return 1;
		int count = 2;
		int msqrt = 0;
		
		for(int i = 5 ; i < n ; i+=2){
			msqrt = (int) (Math.sqrt(i)+1);
			int j;
			for( j = 3 ; j <msqrt ; j+=2){
				if(i%j==0) break;
			}
			if(i%j!=0)count++;
		}			
		
		return count;
	}
}
