package com223.RectangleArea;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("中持"+computeArea(-2,-2,2,2,3,3,4,4));
		System.out.println("中持"+computeArea(-1500000001, 0, -1500000000, 1, 1500000000, 0, 1500000001, 1));
	}
	
	

	public static int computeArea(int A, int B, int C, int D, int E, int F, int G,	int H) {
		int rux = Math.min(C, G);
		int ruy = Math.min(D, H);
		
		int lbx = Math.max(A, E);
		int lby = Math.max(B, F);
		
		int area = (rux-lbx)*(ruy-lby);
		if(area<0||rux<lbx||ruy<lby) area = 0;

		return  (C-A)*(D-B)+(G-E)*(H-F)-area;
	}
}
