package com166.FractiontoRecurringDecimal;

import java.util.HashMap;

public class Solution {

	
//--------����汾��������������������������
	
	public static void main(String[] args) {
		System.out.println(fractionToDecimal(-50,8));
	}

	//��hashset��¼������������������ͬ��ʱ������һ��ѭ����ѭ������Ϊÿ�ε���
	public static String fractionToDecimal(int numerator, int denominator) {		
		HashMap<Long,Integer> rem  = new HashMap<Long,Integer>();//����������͵�ǰ������λ��
		long num = numerator; 
		long den = denominator;
		long partint =  (num/den); //�����������
		
		if(num%den==0) return String.valueOf(partint); //����������������������
		StringBuffer sb = new StringBuffer();
		if((num>0)^(den>0))
			sb.append("-");		
		
		num = Math.abs(num);
		den = Math.abs(den);		
		long currrem =  (num%den); //�������			
		partint = Math.abs(partint);
		sb.append(String.valueOf(partint)+".");
		int div ;		//��ŵ�ǰλ����
		currrem = (int) (currrem%den);		
		while(!rem.containsKey(currrem) && currrem!=0){ //���������޵�ǰ����			
			rem.put(currrem,sb.length());			
			currrem*=10;
			div = (int) (currrem/den);
			sb.append(div);
			currrem = (int) (currrem%den);			
		}	
		if(currrem!=0){
			sb.insert(rem.get(currrem),"("); 
			sb.append(")");
		}		
		
		System.out.println(rem);				
		System.out.println("�������֣�"+partint);
		System.out.println("С�����֣�"+sb.toString());
		return sb.toString();
		
	}

}
