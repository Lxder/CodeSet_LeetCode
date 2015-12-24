package com134.GasStation;

public class Solution {
	
	public static void main(String args[]){
//		int[] gas  = {5,4,3,2,9,2,10};
//		int[] cost = {2,1,6,7,5,8,11};
		
		int[] gas  = {2,4};
		int[] cost = {3,4};
		System.out.println(canCompleteCircuit(gas,cost));
	}
	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int len = gas.length;
		int[] temp = new int[len];
		int start = 0;
		
		for(int i = 0 ; i < len ; i++){
			temp[i] = gas[i]-cost[i];
		}
		
		int sum = 0;
		int totalsum = 0;
		for(int i = 0 ; i < len ; i++){
			totalsum+=temp[i];
			sum += temp[i];
			if(sum<0){
				start = i+1;
				sum = 0;
			}
		}
		if(start == len||totalsum<0)
			return -1;
		return start;
    }
}
