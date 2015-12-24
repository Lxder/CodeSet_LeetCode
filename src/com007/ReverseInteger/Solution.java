package com007.ReverseInteger;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse(-2147483641));	
		System.out.println(reverse(1177463618));
		System.out.println(reverse(12345));
		System.out.println(reverse(-12345));
		
	}
	
	public static int reverse(int x) {
		//����������Χ��Ӱ�죬���xΪ��С��������ôMath.abs(x)����x��Ϊ����.�����Ҫ��������
		if(x==Integer.MIN_VALUE) 
			return 0;
		long solu = 0; //x��ת��Χ���ܳ���Integer.MAX_VALUE�������Ҫ����ķ�Χ��
		int  t = 0;
		boolean flag = true;
		if(x<0){
			flag = false;
			x=Math.abs(x);

		}		
		while(x!=0){
			t=x%10;
			x=x/10;
			solu =solu*10+t;
			if(solu>Integer.MAX_VALUE){
				solu=0;
				break;
			}			

		}
		if(flag==false)
			solu = -solu;		
		return (int)solu;
    }

}
