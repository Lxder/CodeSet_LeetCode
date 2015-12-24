package com135.Candy;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] ratings = {0,1,1,2,2,3,6,5,4,4,3,2,1,2,3,4,100,99,98,97,96,95,94,93,1,2,3,4};
		//int[] ratings = {0,1,1,2,2,3,6,5,4,4,3,2,1,2,3,4,100,99,98,97,96,95,94,93};
		//int[] ratings = {1,2,2};
		
		//int[] ratings = {5,3,1};
		int[] ratings = {5,1,1,1,10,2,1,1,1,3};
		for(int i = 0  ; i < ratings.length ; i++){
			System.out.print(ratings[i]+"\t");
		}
		System.out.println();
		System.out.println("最小糖果数："+candy(ratings));
	}
	
//////////错误，无法AC.............放弃本方法
	
	//寻找连续的有序段
	
	public static int candy(int[] ratings) {
		int len = ratings.length;
		if (len==0) return 0;
		int[] cnum = new int[len];
		cnum[0]=1;
		for(int i = 1 ; i < len ; i++){
			if(ratings[i]==ratings[i-1]){
				if(cnum[i-1]==1) cnum[i]=1;
				else cnum[i] = cnum[i-1]-1;
			}
			else if(ratings[i]>ratings[i-1]){
				if(cnum[i-1]<1) cnum[i]=1;
				else cnum[i] = cnum[i-1]+1;
			}
			else {
				if(cnum[i-1]>1) cnum[i]=1;
				else cnum[i] = cnum[i-1]-1;
			}
		}
		
		for(int i = 0 ; i < len ; i++){
			System.out.print(cnum[i]+"\t");
		}
		System.out.println();
		
		
		for(int i = 1 ; i < len ; i++){
			while(i<len){
				if(cnum[i-1]<1&&cnum[i]>0)
					break;
				else i++;
			}
			//下标i-1的元素为当前段最后一个小于0的元素
			if(i>=len && cnum[len-1]>0) {
				break;
			}
			int times = Math.abs(cnum[i-1]);
			System.out.println("当前元素："+cnum[i-1]);
			int curr = i-1;
			while(curr>=1 && ratings[curr-1]>=ratings[curr] ){
				cnum[curr] += (times+1);				
				curr--;
			}
			System.out.println("结束位置："+curr);
			if(ratings[curr]>ratings[curr+1]){
				cnum[curr] = cnum[curr+1]+1;
			}
//			if(cnum[curr]==cnum[curr+1])
//				cnum[curr]++;

			curr = i-1;
			while(curr<len-1 && ratings[curr+1]>=ratings[curr]){
				
				cnum[curr+1]++;
				curr++;
				System.out.println("当前下标"+curr);
			}
		}
		
		int solu = 0;
		for(int i = 0 ; i < len ; i++){
			solu += cnum[i];
			System.out.print(cnum[i]+"\t");
		}
		System.out.println();		
		
		return solu;
	}

}
