package com066.PlusOne;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] digits = {9,9,9,9,9};
		int[] solu = plusOne(digits);
		for(int i = 0  ;i <solu.length ; i++){
			System.out.print(solu[i]);
		}
	}

	public static int[] plusOne(int[] digits) {
		int len = digits.length;
		boolean flag = true; 
		for(int i = len-1 ; i >=0  ; i--){			
			if(flag==true){
				if(digits[i]==9){
					digits[i]= 0;
					flag = true;
				}
				else {
					digits[i]++;
					flag = false;
				}
			}
			else{
				flag = false;
				
			}
		}
		if(digits[0]==0&&flag == true){
			int[] solu = new int[len+1];
			solu[0]=1;
			return solu;
		}
			
		
		return digits;
	}
}
