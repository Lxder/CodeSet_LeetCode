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
		int iCount = 0; // 1�ĸ���

		long iFactor = 1;

		long iLowerNum = 0;
		int iCurrNum = 0;
		long iHigherNum = 0;

		while (n / iFactor != 0) {
			iLowerNum = n%(iFactor); //����n-(n/iFactor)*iFactor	
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

	// ���� ����10134�������0~12134����1�ĸ���
	// ��λ1�ĸ�����(1013+1)*1
	// ʮλ1�ĸ�����(101+1)*10
	// ��λ1�ĸ�����10*100+34+1
	// ǧλ1�ĸ�����1*1000 (ʵ��Ϊ��01000��01999,��λΪ1�Ķ�������)
	// ��λ1�ĸ�����0*10000+134+1 (�Ѿ������λ�ˣ�iHigherNum=0)

}
