package com007.ReverseInteger;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse(-2147483641));	
		System.out.println(reverse(1177463618));
		System.out.println(reverse(12345));
		System.out.println(reverse(-12345));
		
	}
	
	public static int reverse(int x) {
		//由于整数范围的影响，如果x为最小整数，那么Math.abs(x)还是x，为负数.因此需要单独处理
		if(x==Integer.MIN_VALUE) 
			return 0;
		long solu = 0; //x翻转后范围可能超过Integer.MAX_VALUE，因此需要更大的范围。
		int  t = 0;
		boolean flag = true;
		if(x<0){
			flag = false;
			x=Math.abs(x);

		}		
		while(x!=0){
			t=x%10;
			x=x/10;
			solu =solu*10+t;
			if(solu>Integer.MAX_VALUE){
				solu=0;
				break;
			}			

		}
		if(flag==false)
			solu = -solu;		
		return (int)solu;
    }

}
