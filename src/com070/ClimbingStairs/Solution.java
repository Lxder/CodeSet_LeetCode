package com070.ClimbingStairs;

public class Solution {
	public static void main(String args[]){
		System.out.println(climbStairs(44));
	}

	public static int climbStairs(int n) {
		if( n<=2) return n;
		int a1 = 1 ;
		int a2 = 2;
		int temp;
		for(int i = 3 ; i <=n ; i++){
			temp = a1 ; 
			a1 = a2 ; 
			a2 = a2+temp;
		}
		return a2;
	}
}
