package com029.DivideTwoIntegers;

public class Solution2 {

	public static void main(String args[]) {
		//System.out.println(divide(0, 0));
		//System.out.println(divide(100, 4));
		
		System.out.println(divide(Integer.MIN_VALUE, -1));
		System.out.println(10<<2);
		//System.out.println(divide(-1000, -10));

	}

	
	  
	//除法就是由乘法的过程逆推，
	//依次减掉（如果x够减的）y*(2^31),y*(2^30),...y*8,y*4,y*2,y*1。
	//减掉相应数量的y就在结果加上相应的数量。  
	public static int divide(int dividend, int divisor) {
		if (divisor == 0)
			return Integer.MAX_VALUE;
		if (dividend == 0)
			return 0;
		
		long dived = dividend;
		long divsor = divisor;
		
		System.out.println(dived+" "+divsor);
		boolean flag = true; 	// 指示正负号
		if (dived < 0 && divsor > 0 || dived > 0 && divsor < 0)
			flag = false;	// 负号
		dived = Math.abs(dived);
		divsor = Math.abs(divsor);
		System.out.println(dived+" "+divsor);
		long ans = 0;
		

//		//下面的31代表最大值，还可以将代码改成这样
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
			// 比较dived是否大于divsor的(1<<i)次方，避免将dived与(divsor<<i)比较，因为不确定divsor的(1<<i)次方是否溢出
			if ((dived >> i) >= divsor) {
				ans += (1 << i);
				dived -= (divsor << i);
			}
		}
		
		
		if(Math.abs(ans)>Integer.MAX_VALUE&&flag==true) //结果超过最大正数,返回最大正数
			return Integer.MAX_VALUE;
		if (flag == false)
			return (int) -ans;
		else
			return (int) ans;
	}
}
