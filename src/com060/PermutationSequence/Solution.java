package com060.PermutationSequence;

public class Solution {
	public static void main(String args[]){
		System.out.println(getPermutation(5,16));
	}
	public static String getPermutation(int n, int k) {
		//n位数字有n! 个序列
		//返回第k个序列
		long mult = 1 ;	//保存乘积
		int num =1;			//当前乘到了多少
		int[] isSelected = new int[n];
		StringBuffer sb_solu = new StringBuffer();		
		
		while(num<n){			
			mult *=num;		
			num++;
		}	
		
		int left = 0;
		k--;
		while(num>1){
			left=(int) (k%mult);
			k=(int) (k/mult);			
			int count = 0;
			for(int i = 0 ;i< n ; i++){
				if(count == k && isSelected[i]==0){
					isSelected[i]=1;
					sb_solu.append(String.valueOf(i+1));
					break;
				}else if(isSelected[i]==0){
					count++;
				}						
			}
			num--;
			mult/=num;
			k = left;
		}
		for(int i = 0 ; i < n ; i++){
			if(isSelected[i]==0)
				sb_solu.append(String.valueOf(i+1));
		}
		return sb_solu.toString();
		
	}
}
