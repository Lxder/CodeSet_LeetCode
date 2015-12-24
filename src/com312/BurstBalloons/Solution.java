package com312.BurstBalloons;

//转换为求矩阵连乘的最 大 计算次数
public class Solution {
	public static void main(String args[]){
		int[] nums = {3,1,5,8};
		System.out.println(maxCoins(nums));
	}
    public static int maxCoins(int[] nums) {
    	int nlen = nums.length+2;
    	int[] arr = new int[nlen];
    	arr[0] = arr[nlen-1] = 1;
    	for(int i = 1 ; i < nlen-1 ; i++){
    		arr[i] = nums[i-1];
    	}
    	
    	int[][] cost = new int[nlen][nlen]; //存储计算次数
    	for(int i = 1 ; i < nlen-1 ; i++){
    		int str = 0;
    		for(int j = i ; j < nlen-1 ; j++ ,str++){
    			System.out.println("当前求的位置"+"x:"+str+" y:"+j+"\t");
    			for(int k = str ; k <j  ;k++){
    				int temp = cost[str][k] + cost[k+1][j] + arr[str]*arr[k+1]*arr[j+1];
    				System.out.print(arr[str]+" "+arr[k+1]+" "+arr[j+1]+"|||");
    				System.out.println("str:"+str+" j:"+j+" k:"+k+" "+temp + "\t");
    				if (temp > cost[str][j]) cost[str][j] = temp;
    			}
    			System.out.println();
    		}
    		System.out.println();
    	}
    	for(int i = 0 ; i <nlen ; i++){
    		for(int j =0 ; j <nlen ; j++){
    			System.out.print(cost[i][j]+"\t");
    		}
    		System.out.println();
    	}
    	return cost[0][nlen-2];
    	
        
    }
}