package com164.MaximumGap;

public class Solution {

	public static void main(String args[]){
		int[] nums = {1,10000000};		
		System.out.println(maximumGap(nums));	
	}
	
	
	public static int maximumGap(int[] nums) {
		int len = nums.length;
		if(len<2) return 0;
		int maxval = Integer.MIN_VALUE;
		int minval = Integer.MAX_VALUE;
		
		for(int val:nums){
			if(val > maxval) maxval = val;
			if(val < minval) minval = val;				
		}
		
		int gap = (int) Math.ceil((double)(maxval-minval)/(len-1)); //���ƽ������
		int bucketCount = (int) Math.ceil((double)(maxval-minval)/gap); //��Ͱ������

		//�������飬�ֱ��¼��ǰͰ�����ֵ����Сֵ
		int[] maxarr = new int[bucketCount];
		int[] minarr = new int[bucketCount];
		
		//��ʼ��Ͱ
		for(int i = 0 ; i < bucketCount ; i++){
			maxarr[i] = Integer.MIN_VALUE;
			minarr[i] = Integer.MAX_VALUE;
		}
		
		//������Ԫ�ط���Ͱ��
		for(int val :nums){			
			if(val==maxval||val ==minval) continue;
			int currbucket = (val-minval)/gap; // �����ǰԪ������һ��Ͱ����			
			if(val<minarr[currbucket]) minarr[currbucket] = val;
			if(val>maxarr[currbucket]) maxarr[currbucket] = val;
		}
		
		for(int i = 0 ; i < bucketCount ; i++){
			System.out.println(minarr[i]+" "+maxarr[i]);
		}
		
		int maxgap = 0; //���������
		int lastmax = minval;
		
		for(int i= 0 ; i < bucketCount ; i++){
			if(maxarr[i]==Integer.MIN_VALUE) continue;
			int currmax = maxarr[i];
			int currmin = minarr[i];
			maxgap = Math.max(maxgap, currmin - lastmax);
			lastmax = currmax; 
		}
		return Math.max(maxgap, maxval-lastmax);
	}
}
