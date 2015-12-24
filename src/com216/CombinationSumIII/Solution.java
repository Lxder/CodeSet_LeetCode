package com216.CombinationSumIII;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(combinationSum3(2,6));
	}


	public static List<List<Integer>> combinationSum3(int k, int n) {
		int maxn = n;
		for(int i =1  ; i < k ; i++){
			maxn = n-i;
		}
		if(maxn > 9) maxn = 9;
		List<List<Integer>> solu = new ArrayList<List<Integer>>();
		if(k==0) return solu;
		
		
		int[] tag = new int[k]; //每一位数字设定一个tag
		int[] start = new int[k]; //每位数字的最小值
		int[] end = new int[k]; //每位数字的最大值（假设我们选择的组合结果每一位都按从小到大排列）
		
		for(int i = 0 ; i < k ; i++){
			start[i] = i+1;
			end[i] = maxn-k+1 +i;
			tag[i] = i+1;
			System.out.println("start "+start[i]+" end "+end[i]);
		}
		
		
		int sum ;
		while(tag[0]<=end[0]){
			sum = 0;
			List<Integer> list = new ArrayList<Integer>();
			for(int i = 0 ; i < k ; i++){
				sum = sum+tag[i];
				list.add(tag[i]);
			}
			if(sum == n){
				solu.add(list);				
				System.out.println(list);
			}
			
			tag[k-1]++;
			int i ;
			for(i = k-1 ; i >0  ; i--){
				if(tag[i]>end[i]){ //若当前数字已经到头了，令当前从头开始，前一个数字加1
					tag[i-1]++; 
				}
				else break;
			}
			//在上面的for循环中只是得到了最前面变化的那个元素，后面的在更新过程中都被更改了
			//因此下面根据最前面变化的元素来计算后面的元素。由所有元素递增的原则，只需令后面的比前面的大1即可
			for(int j = i ; j <k-1 ; j++){ 
				tag[j+1] = tag[j]+1;
			}
		}
		
		return solu;
	}

}
