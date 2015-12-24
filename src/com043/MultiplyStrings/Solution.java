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
		int[] solu = new int[len1+len2+2]; //��Ž��������

		int start = 0;
		int istart = 0;
		
		int flag ; //����һλ�Ľ�λ 
		int curr ; //��ǰλ
		int temp ; //��ǰ�˻�
		for(int i = cnum2.length-1 ; i >=0 ; i--){ //�������
			flag = 0;
			start = istart ;
			for(int j = cnum1.length-1 ; j >=0 ; j--){ //��������				
				temp = (cnum1[j]-48)*(cnum2[i]-48) + solu[start]+flag;
				curr = temp%10; //��ǰλ				
				solu[start++] = curr;
				
				flag = temp/10 ; //��һλ
			}
			solu[start] = flag;
			istart++;
		}

		int i ;
		for(i = solu.length-1 ; i >= 0 ; i--){ //����ǰ���0
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
