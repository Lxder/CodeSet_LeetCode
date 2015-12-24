package com190.ReverseBits;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseBits(43261596));
	}

	public static int reverseBits(int n) {
		int solu = 0;
		for(int i = 0 ; i < 32 ; i++){
			solu = (solu<<1)+(n&1);
			n = n >> 1;
		}
		return solu;
	}

}
