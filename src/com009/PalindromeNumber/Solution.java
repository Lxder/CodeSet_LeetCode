package com009.PalindromeNumber;

public class Solution {

	public static void main(String[] args) {
		System.out.println(isPalindrome(10501));
	}

	public static boolean isPalindrome(int x) {
		if(x<0) 
			return false;
		int base = 1;
		while(x/base>=10){
			base = base*10;
		}
		//System.out.println(base);
		while(x!=0){
			//System.out.println(x/base+" "+x%10);
			if(x/base==x%10){
				x=x%base/10;
				base=base/100;
			}else
				return false;
		}
		return true;
	}

}
