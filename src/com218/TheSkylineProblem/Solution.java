package com218.TheSkylineProblem;

import java.util.LinkedList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] buildings= {
				 {2, 9, 10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}
		};
		List<int[]> solu = getSkyline(buildings);
		
		
		for(int[] curr: solu){
			System.out.println(curr[0]+" "+curr[1]);
		}
		System.out.println(solu);
		
		
	}

	//---错误!!!!!!!!!!只适用于建筑物的x坐标较小的情况（因为要根据x坐标的最大值开辟数组）
	public static List<int[]> getSkyline(int[][] buildings) {
		int row = buildings.length;		
		
		int asize = 0;
		for(int i = 0 ; i < row ; i++){
			if(buildings[i][1]>asize)
				asize = buildings[i][1];
		}
		
		int[] higharr = new int[asize+1];
		
		for(int i = 0 ; i < row ; i++){
			int currh = buildings[i][2]; //获取当前高度
			for(int j = buildings[i][0] ;j <= buildings[i][1] ; j++){
				if(higharr[j]<currh){
					higharr[j] = currh;
				}
			}
		}
		List<int[]> solu = new LinkedList<int[]>();
		
		int preh = higharr[0];		
		if(preh!=0){
			solu.add(new int[]{0,higharr[0]});
		}
		
		for(int i = 1 ; i < asize+1 ; i ++){
			if(higharr[i]>preh){
				solu.add(new int[]{i,higharr[i]});
				preh = higharr[i];
			}else if(higharr[i]<preh){
				solu.add(new int[]{i-1,higharr[i]});
				preh = higharr[i];
			}
		}
		
		if(higharr[asize]!=0){
			int[] temp = new int[2];
			temp[0]=asize;
			temp[1] = 0;
			solu.add(temp);
		}
		return solu;
	}

}
