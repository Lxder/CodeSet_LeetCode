package com264.UglyNumberII;


public class Solution {

	public static void main(String[] args) {
		System.out.println(nthUglyNumber(0));
	}

	public static int nthUglyNumber(int n) {
		//if(n==0) return 0;
		int[] ugly = new int[n];
		ugly[0]=1;
		
		int index2 = 0 , index3 =0 , index5 = 0;
		int factor2 = ugly[0]*2 , factor3 = ugly[0]*3 , factor5 = ugly[0]*5;
		int currmin ;
		for(int i = 1 ;i < n ; i++){
			currmin = findmin(factor2,factor3,factor5);
			ugly[i] = currmin;
			if(factor2 == currmin) factor2 = ugly[++index2]*2;
			if(factor3 == currmin) factor3 = ugly[++index3]*3;
			if(factor5 == currmin) factor5 = ugly[++index5]*5;
		}
		return ugly[n-1];
		
	}
	
	
	public static int findmin(int i1,int i2 , int i3){
		return Math.min(Math.min(i1, i2),i3);		
	}

}
