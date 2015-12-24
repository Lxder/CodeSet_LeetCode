package com233.NumberofDigitOne;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countDigitOne(123));

		 Integer n1 = new Integer(1);
		 returnTest();
		 


	}
	public static void returnTest()
	{
	    try
	    {
	    	System.out.println("try");;return;
	    }
	    catch (Exception e)
	    {
	    	System.out.println("exception");
	    }
	    finally
	    {
	        System.out.println("finally");
	        
	    }
	    System.out.println("other");
	}
	
	public static void doSomething(Integer integer){
	    integer=new Integer(2);
	}

	public static int countDigitOne(int n) {
		if(n<=0) return 0;
		int iCount = 0; // 1的个数

		long iFactor = 1;

		long iLowerNum = 0;
		int iCurrNum = 0;
		long iHigherNum = 0;

		while (n / iFactor != 0) {
			iLowerNum = n%(iFactor); //或者n-(n/iFactor)*iFactor	
			iCurrNum = (int) (n / iFactor) % 10;
			iHigherNum = n / iFactor / 10;

			switch (iCurrNum) {
			case 0:
				iCount += iHigherNum * iFactor;
				break;
			case 1:
				iCount += iHigherNum * iFactor + iLowerNum + 1;
				break;
			default:
				iCount += (iHigherNum + 1) * iFactor;
				break;
			}
			iFactor *= 10;
		}
		return iCount;
	}

	// 例如 数字10134，计算从0~12134共有1的个数
	// 个位1的个数：(1013+1)*1
	// 十位1的个数：(101+1)*10
	// 百位1的个数：10*100+34+1
	// 千位1的个数：1*1000 (实际为从01000到01999,万位为1的都不可能)
	// 万位1的个数：0*10000+134+1 (已经到最高位了，iHigherNum=0)

}
