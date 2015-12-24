package com191.Numberof1Bits;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(hammingWeight(9));
	}

	public  static int hammingWeight(int n) {
		int num = 0;
		for(int i = 0 ; i < 32 ; i++){
			num = num +(n&1);
			n = n>>1;
			
		}
		return num;
	}

}
