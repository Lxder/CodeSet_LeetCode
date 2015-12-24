package com011.ContainerWithMostWater;

public class Solution {
	
	public static void main(String args[]){
		//int[] height =  {4,6,2,6,7,11,2};
		int[] height =  {4,6,8,10,10,6,8,4};
		System.out.println(maxArea(height));
	}
	public static int maxArea(int[] height) {
		int len = height.length;
		if(len==0||len==1)
			return 0;
		
		int v = 0; //记录最大容积		
		int i = 0 ; //记录起点
		int j = len-1;	//记录终点
		while(i<j){ //从最左和最右开始计算
			v = Math.max(v, Math.min(height[i],height[j])*(j-i)); //重新计算最大容积
			if(height[i]<height[j]){ //左边是短板，则先从左边开始
				int k = i;
				while(k<j&&height[k]<=height[i])
					k++;
				i=k;				
			}else{ //右边是短板，则从右边开始
				int k = j;
				while(k>i&&height[k]<=height[j])
					k--;
				j=k;
			}
		}
		
		return v;
		
	}
}
