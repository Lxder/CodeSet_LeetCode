package com043.MultiplyStrings;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(multiply("0","0"));
	}

	public static String multiply(String num1, String num2) {
		StringBuffer sb = new StringBuffer();
		char[] cnum1 = num1.toCharArray();
		char[] cnum2 = num2.toCharArray();
		int len1 = cnum1.length;
		int len2 = cnum2.length;
		int[] solu = new int[len1+len2+2]; //存放结果的数组

		int start = 0;
		int istart = 0;
		
		int flag ; //向上一位的进位 
		int curr ; //当前位
		int temp ; //当前乘积
		for(int i = cnum2.length-1 ; i >=0 ; i--){ //代表乘数
			flag = 0;
			start = istart ;
			for(int j = cnum1.length-1 ; j >=0 ; j--){ //代表被乘数				
				temp = (cnum1[j]-48)*(cnum2[i]-48) + solu[start]+flag;
				curr = temp%10; //当前位				
				solu[start++] = curr;
				
				flag = temp/10 ; //下一位
			}
			solu[start] = flag;
			istart++;
		}

		int i ;
		for(i = solu.length-1 ; i >= 0 ; i--){ //跳过前面的0
			if(solu[i]!=0)
				break;			
		}		
		if(i==-1)
			 return Integer.toString(0);
		
		while(i>=0){
			sb.append(solu[i]);
			i--;
		}
		return sb.toString();
	}

}
