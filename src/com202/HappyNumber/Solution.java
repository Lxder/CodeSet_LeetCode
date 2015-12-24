package com202.HappyNumber;

import java.util.HashMap;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isHappy(2));

	}

	public static boolean isHappy(int n) {
		int sum;
		int temp;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		while(true){
			sum = 0 ;
			while(n!=0){
				temp = n%10;
				sum+=temp*temp;
				n = n/10;
			}
			if(map.get(sum)!=null)return false;
			else map.put(sum, 1);
			
			if(sum==1)
				return true;
			else
				n = sum;
		}
		
	}

}
