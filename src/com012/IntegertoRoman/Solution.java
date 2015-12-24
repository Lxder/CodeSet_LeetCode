package com012.IntegertoRoman;

public class Solution {

	public static void main(String args[]){
		System.out.println(intToRoman(3894)); 
		System.out.println(intToRoman(3));
		System.out.println(intToRoman(1));
	}
	public static String intToRoman(int num) {
		StringBuffer solu = new StringBuffer(); 
		int x = 0 ;
		char[] roman = {'I','V','X','L','C','D','M'};
		int rindex = 0;
		while(num!=0){
			x =num%10;
			System.out.println(x);			
			num=num/10;			
			
			if(x<=3){
				while(x!=0){
					solu.append(roman[rindex]);
					x--;
				}
			}
			else if(x<=8){
				if(x==4){
					solu.append(roman[rindex+1]);
					solu.append(roman[rindex]);
				}else{
					while(x-5!=0){
						solu.append(roman[rindex]);
						x--;
					}
					solu.append(roman[rindex+1]);
				}
			}else{
				solu.append(roman[rindex+2]);				
				solu.append(roman[rindex]);
			}
			
			rindex+=2;
				
		}
		
		return solu.reverse().toString();
	}
}
