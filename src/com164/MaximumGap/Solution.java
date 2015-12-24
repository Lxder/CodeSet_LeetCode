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
		
		int gap = (int) Math.ceil((double)(maxval-minval)/(len-1)); //求出平均距离
		int bucketCount = (int) Math.ceil((double)(maxval-minval)/gap); //求桶的数量

		//两个数组，分别记录当前桶的最大值和最小值
		int[] maxarr = new int[bucketCount];
		int[] minarr = new int[bucketCount];
		
		//初始化桶
		for(int i = 0 ; i < bucketCount ; i++){
			maxarr[i] = Integer.MIN_VALUE;
			minarr[i] = Integer.MAX_VALUE;
		}
		
		//将所有元素放入桶内
		for(int val :nums){			
			if(val==maxval||val ==minval) continue;
			int currbucket = (val-minval)/gap; // 求出当前元素在哪一个桶里面			
			if(val<minarr[currbucket]) minarr[currbucket] = val;
			if(val>maxarr[currbucket]) maxarr[currbucket] = val;
		}
		
		for(int i = 0 ; i < bucketCount ; i++){
			System.out.println(minarr[i]+" "+maxarr[i]);
		}
		
		int maxgap = 0; //保存最大间隔
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
