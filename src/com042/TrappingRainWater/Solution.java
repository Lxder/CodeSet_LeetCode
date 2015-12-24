package com042.TrappingRainWater;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = { 2,0,2 };
		System.out.println(trap(height));
	}
//³¬Ê±ÁË£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡
	public static int trap(int[] height) {
		int len = height.length;
		if(len==0||len==1||len==2)
			return 0;
		int maxh = height[0];
		for (int i = 1; i < len; i++) {
			if (height[i] > maxh)
				maxh = height[i];
		}
		int start = 0;
		int end = 0;

		int vwater = 0;
		for (int h = 1; h <= maxh; h++) {
			int i = 0;

			while (i < len-1) {
				start = 0;
				while (i < len-1) {
					if (height[i] >= h && height[i + 1] < h) {
						start = i;
						break;
					}
					i++;
				}
				i++;
				
				end = start + 1;
				while (i < len) {
					if (height[i] >= h && height[i - 1] < h) {
						end = i;
						break;
					}
					i++;

				}
				
				vwater += (end - start - 1);
				System.out.println(start+" "+end+" "+h+" v:"+ vwater);

			}
		}
		return vwater;

	}

}
