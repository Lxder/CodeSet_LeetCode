package com029.DivideTwoIntegers;

public class Solution2 {

	public static void main(String args[]) {
		//System.out.println(divide(0, 0));
		//System.out.println(divide(100, 4));
		
		System.out.println(divide(Integer.MIN_VALUE, -1));
		System.out.println(10<<2);
		//System.out.println(divide(-1000, -10));

	}

	
	  
	//���������ɳ˷��Ĺ������ƣ�
	//���μ��������x�����ģ�y*(2^31),y*(2^30),...y*8,y*4,y*2,y*1��
	//������Ӧ������y���ڽ��������Ӧ��������  
	public static int divide(int dividend, int divisor) {
		if (divisor == 0)
			return Integer.MAX_VALUE;
		if (dividend == 0)
			return 0;
		
		long dived = dividend;
		long divsor = divisor;
		
		System.out.println(dived+" "+divsor);
		boolean flag = true; 	// ָʾ������
		if (dived < 0 && divsor > 0 || dived > 0 && divsor < 0)
			flag = false;	// ����
		dived = Math.abs(dived);
		divsor = Math.abs(divsor);
		System.out.println(dived+" "+divsor);
		long ans = 0;
		

//		//�����31�������ֵ�������Խ�����ĳ�����
//		int digit = 0;
//	    while(divisor<=(dividend>>1))
//	    {
//	        divisor <<= 1;
//	        digit++;
//	    }	    
//	    while(digit>=0)
//	    {
//	        if(dividend>=divisor)
//	        {
//	            dividend -= divisor;
//	            res += 1<<digit;
//	        }
//	        divisor >>= 1;
//	        digit--;
//	    }
		
		for (int i = 31; i >= 0; i--) {
			// �Ƚ�dived�Ƿ����divsor��(1<<i)�η������⽫dived��(divsor<<i)�Ƚϣ���Ϊ��ȷ��divsor��(1<<i)�η��Ƿ����
			if ((dived >> i) >= divsor) {
				ans += (1 << i);
				dived -= (divsor << i);
			}
		}
		
		
		if(Math.abs(ans)>Integer.MAX_VALUE&&flag==true) //��������������,�����������
			return Integer.MAX_VALUE;
		if (flag == false)
			return (int) -ans;
		else
			return (int) ans;
	}
}
