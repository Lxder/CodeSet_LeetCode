package com137.SingleNumberII;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,1,2,2,2,3,4,3,4,3,5,4};
		System.out.println("���"+singleNumber(nums));

	}

	//˼· �� ��ÿһ������ת���ɶ���������
	//��Ӧ��ÿһλ��ӣ�������ͬ�������ڸ�λ�ϵĺ�ֻ������0����3
	//��ÿһλ�Ľ����3ȡ�࣬��ô������־��ǵ��������Ǹ���
	public static int singleNumber(int[] nums) {
		int len = nums .length;
		int temp ; 
		int res  = 0;
		for(int i = 0 ; i < 32 ; i++){
			temp = 0;			
			for(int j = 0 ; j < len ; j++)
				temp = temp + ((nums[j]>>i)&1) ;
			res = res| (temp%3)<<i; //Ҳ���Ա�ʾ�� res+( (temp%3)<<i ); ע�� ��벿��Ҫ��������

		}
		return res;
	}

}
