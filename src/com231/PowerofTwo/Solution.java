package com231.PowerofTwo;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
		System.out.println(Integer.toBinaryString(Integer.MIN_VALUE-1));
		System.out.println(isPowerOfTwo(-2));
	}

	public static boolean isPowerOfTwo(int n) {
		if(n==0)return false;

		while (n != 1) {
			if (n % 2 == 0)
				n = n / 2;
			else
				return false;
		}
		return true;
	}

	//2�������η����λ��Ȼ��1����ֻ����һ��1����������������n&(n-1) = 0
	public static boolean isPowerOfTwo2(int n ){
		if(n==0||n==Integer.MIN_VALUE) return false;
		n = n&(n-1);
		if(n==0) return true;
		return false;
	}
}
