package com096.UniqueBinarySearchTrees;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numTrees(6));
	}

	public static int numTrees(int n) {
		if(n==0||n==1||n==2) return n;
		if(n==3) return 5;
		int[] a = new int[n+1];
		a[0] = 1 ; 
		a[1] = 1 ;
		a[2] = 2 ; 
		a[3] = 5 ;
		for(int i = 4 ; i <= n ; i++){
			for(int j = 0 ; j < i ; j++){
				a[i] += a[j] * a[i-j-1];
			}
		}

		return a[n];
		
	}

}
