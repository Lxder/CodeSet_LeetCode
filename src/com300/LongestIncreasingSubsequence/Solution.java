package com300.LongestIncreasingSubsequence;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	
	public static void main(String args[]){
		int[] nums = { 10, 9, 2, 4, 5, 3, 1, 7, 101, 18 };
		System.out.println("���1��"+lengthOfLIS(nums));
		
		System.out.println("���2��"+lengthOfLIS2(nums));
		
	}
	//ʱ�临�Ӷ�O(n^2)
    public static int lengthOfLIS(int[] nums) {
    	int len = nums.length;
    	if(len==0) return 0;
    	int[] sarr = new int[len];
    	sarr[len-1] = 1;
    	for(int i = len-2 ; i>=0 ; i--){
    		sarr[i] = 1;
    		for(int j = i+1 ; j < len ; j++){
    			if(nums[i]<nums[j]){
    				sarr[i] = Math.max(sarr[i], sarr[j]+1);
    			}
    		}
    	}
    	
    	int solu = 0;
    	for(int i = 0; i < len ; i++){
    		if(sarr[i]>solu) solu = sarr[i];
    	}
    	return solu;
    }
    //{ 10, 9, 2, 4, 5, 3, 1, 7, 101, 18 };
    
    //ʱ�临�Ӷ�O(nlog(n))
    //dp[i]��ʾ����Ϊi+1�ĵ�������������һ��Ԫ�ص���Сֵ
    public static int lengthOfLIS2(int[] nums) {
		ArrayList<Integer> dp = new ArrayList<>(nums.length);
		//ע��dp�ڵ�Ԫ���������
		for (int num : nums) {
			//�����ǰԪ�ش���dp�����һ��Ԫ�أ���ֱ����ӵ�����
			if (dp.size() == 0 || dp.get(dp.size() - 1) < num){ 
				dp.add(num);
			} else {
				//ȷ��Ԫ��Ҫ���ǵ�λ��
				int i = Collections.binarySearch(dp, num);
				if(i<0){ //i<0 ˵��dp��û�����Ԫ��
					i = -(i+1); //-(i+1)Ϊ����λ��
					dp.set(i, num); //�����ֵ��ǰ��С��Ӧ���滻����ֵ����
				}				
			}
			System.out.println(dp); 
		}
		return dp.size(); //ע�⣡��dp�ڱ���Ĳ������յĵ�������
    }
}