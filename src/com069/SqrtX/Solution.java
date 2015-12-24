package com069.SqrtX;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(mySqrt(2147483647));
	}

	public static int mySqrt(int x) {
		long start = 1 ;
		long end =x;
		long mid ;
		long temp;
		while(start<=end){
			mid = start + ((end-start)>>1);		
			temp = x/mid;
			if(temp<mid)
				end = mid -1;				 
			else if(temp>mid)
				start = mid+1;
			else return (int) mid;
			
		}
		
		return (int) start-1;
	}
}
