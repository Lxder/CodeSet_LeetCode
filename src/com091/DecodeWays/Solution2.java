package com091.DecodeWays;

public class Solution2 {

	public static void main(String[] args) {
		System.out.println(numDecodings("20"));
	}

	//动态规划，第i个元素表示：从开始到第i个字符有多少种表示方法
	
	public static int numDecodings(String s ){
		int len = s.length();
		if(len==0) return 0;
		if(s.charAt(0)=='0')
			return 0;
		if(len==1) {
			return 1;
		}
		int[] decarr = new int[len];
		decarr[0] = 1;
		int startnum = Integer.valueOf(s.substring(0,2));		
		if(startnum<=26&&startnum>10&&startnum!=20){
			decarr[1]=2;
		}else if(startnum>20&&s.charAt(1)=='0'){
			return 0;
		}else {
			decarr[1]=1;
		}
		for(int i= 2 ;i <len ; i++){
			int currnum = Integer.valueOf(s.substring(i-1,i+1));
			if(currnum==0) return 0;
			char c = s.charAt(i);		
			if(c=='0'){
				if(currnum>20)	return 0;
				decarr[i] = decarr[i-2];
			}else if(currnum<=26&&currnum>=10){
				decarr[i]= decarr[i-1]+decarr[i-2];
			}else
				decarr[i]= decarr[i-1];
		}
		
		return decarr[len-1];
		
	}

}
