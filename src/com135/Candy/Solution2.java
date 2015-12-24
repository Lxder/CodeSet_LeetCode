package com135.Candy;

public class Solution2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] ratings = {0,1,1,2,2,3,6,5,4,4,3,2,1,2,3,4,100,99,98,97,96,95,94,93,1,2,3,4};
		//int[] ratings = {0,1,1,2,2,3,6,5,4,4,3,2,1,2,3,4,100,99,98,97,96,95,94,93};
		//int[] ratings = {1,2,2};
		
		int[] ratings = {5,3,1};
		//int[] ratings = {5,1,1,1,10,2,1,1,1,3};
		for(int i = 0  ; i < ratings.length ; i++){
			System.out.print(ratings[i]+"\t");
		}
		System.out.println();
		System.out.println("最小糖果数："+candy(ratings));
	}
	

	public static int candy(int[] ratings) {
		int len = ratings.length;
		if (len <= 1)
			return len;

		int[] num = new int[len];
		for (int i = 0; i < len; i++) {
			num[i] = 1;
		}
		for (int i = 1; i < len; i++) {
			if (ratings[i] > ratings[i - 1])
				num[i] = num[i - 1] + 1;
		}

		for (int i = len - 1; i > 0; i--) {
			if (ratings[i - 1] > ratings[i])
				num[i - 1] = Math.max(num[i] + 1, num[i - 1]);
		}
		int result = 0;
		for (int i = 0; i < len; i++) {
			result += num[i];
			// cout<<num[i]<<" ";
		}
		return result;
	}

}
