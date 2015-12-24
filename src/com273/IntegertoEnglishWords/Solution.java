package com273.IntegertoEnglishWords;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(Integer.MAX_VALUE);
		
		String solu = numberToWords(1000000);
		System.out.println(solu);		
		//System.out.println(2147483647/1000000000);
	}

	public static String numberToWords(int num) {
		if(num==0)return "Zero";
		StringBuffer sb = new StringBuffer();
		String[] words = {"","Thousand ","Million ","Billion "};
		
		String[] numbers = {"","One ","Two ","Three ","Four ","Five ","Six ","Seven ","Eight ","Nine "};		
		String[] lessThan20 = {"Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
        String[] tens = {"", "Ten ", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
		
        int base = 1000;
		int div = 1;
		int temp = num%base/div;
		int numtemp = num/(base/1000);
		System.out.println(numtemp);
		int i_words = 0;
		while(numtemp>0){	
			if(temp!=0)
				sb.insert(0,words[i_words]);
			
			int n1 = temp % 10;
			int n10 = temp%100/10;
			int n100 = temp/100;
			
			if(n10==1){
				sb.insert(0,lessThan20[n1]);
			}else {
				sb.insert(0,numbers[n1]);
				sb.insert(0,tens[n10]);
			}
			
			if(n100!=0){
				sb.insert(0,"Hundred ");
				sb.insert(0,numbers[n100]);
			}	
			
			base *= 1000;
			div *= 1000;
			temp = num%base/div;
			i_words++;
			numtemp = num/(base/1000);
		}
		
		temp = num/1000000000; //最后一次
		if(temp!=0){
			sb.insert(0,"Billion ");
			sb.insert(0,numbers[temp]);
		}
		//System.out.println(temp);
		
		String solu = sb.toString();
		return solu.substring(0,solu.length()-1);
	}

}
