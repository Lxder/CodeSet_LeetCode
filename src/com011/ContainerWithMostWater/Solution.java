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
		
		int v = 0; //��¼����ݻ�		
		int i = 0 ; //��¼���
		int j = len-1;	//��¼�յ�
		while(i<j){ //����������ҿ�ʼ����
			v = Math.max(v, Math.min(height[i],height[j])*(j-i)); //���¼�������ݻ�
			if(height[i]<height[j]){ //����Ƕ̰壬���ȴ���߿�ʼ
				int k = i;
				while(k<j&&height[k]<=height[i])
					k++;
				i=k;				
			}else{ //�ұ��Ƕ̰壬����ұ߿�ʼ
				int k = j;
				while(k>i&&height[k]<=height[j])
					k--;
				j=k;
			}
		}
		
		return v;
		
	}
}
