package com031.NextPermutation;

//全排列 字典算法
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] nums = {2,3,1};
		//int[] nums = {1,3,2};
		int[] nums = {5,1,1};
		nextPermutation(nums);
		for(int i = 0 ; i <nums.length ; i++)
			System.out.print(nums[i]+" \t");

	}

	public static void nextPermutation(int[] nums) {
		if(nums.length==0||nums.length==1)
			return;
		int len = nums.length;
		int ismal = len-2;
		while(ismal>=0 && nums[ismal]>=nums[ismal+1])
			ismal--; //1. 向前找出第一个比右边数字小的数字的序号j

		if(ismal==-1){ //如果整个数组都是递增的，就返回第一个序列，即变为递减的那个序列
			InvertArray(nums, 0,len-1);
			return;
		}		
		int i_min = ismal+1;//2. 在P[j]的右边的数字中，找出所有比P[j]大的数中最小的数字Pk(右侧为递增的)
		
		while(i_min<len&& nums[i_min]> nums[ismal]) 
			i_min++;
		i_min--;
		Swap(nums,ismal,i_min);	//3. 交换nums[ismal]和nums[i_min]		
		InvertArray(nums, ismal+1,len-1); //4. 将ismal+1到len-1的元素逆置
    }
	
	public static void Swap(int[] nums, int i , int j ){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void InvertArray(int[] nums, int start , int end){
		int temp;
		while(start<end){
			temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++; end--;
		}
	}
	
}
