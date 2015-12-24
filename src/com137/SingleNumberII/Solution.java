package com137.SingleNumberII;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,1,2,2,2,3,4,3,4,3,5,4};
		System.out.println("结果"+singleNumber(nums));

	}

	//思路 ： 将每一个数字转换成二进制数，
	//对应的每一位相加，三个相同的数，在该位上的和只可能是0或者3
	//将每一位的结果和3取余，那么这个数字就是单下来的那个数
	public static int singleNumber(int[] nums) {
		int len = nums .length;
		int temp ; 
		int res  = 0;
		for(int i = 0 ; i < 32 ; i++){
			temp = 0;			
			for(int j = 0 ; j < len ; j++)
				temp = temp + ((nums[j]>>i)&1) ;
			res = res| (temp%3)<<i; //也可以表示成 res+( (temp%3)<<i ); 注意 后半部分要加上括号

		}
		return res;
	}

}
