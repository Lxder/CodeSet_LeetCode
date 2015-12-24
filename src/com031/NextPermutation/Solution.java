package com031.NextPermutation;

//ȫ���� �ֵ��㷨
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
			ismal--; //1. ��ǰ�ҳ���һ�����ұ�����С�����ֵ����j

		if(ismal==-1){ //����������鶼�ǵ����ģ��ͷ��ص�һ�����У�����Ϊ�ݼ����Ǹ�����
			InvertArray(nums, 0,len-1);
			return;
		}		
		int i_min = ismal+1;//2. ��P[j]���ұߵ������У��ҳ����б�P[j]���������С������Pk(�Ҳ�Ϊ������)
		
		while(i_min<len&& nums[i_min]> nums[ismal]) 
			i_min++;
		i_min--;
		Swap(nums,ismal,i_min);	//3. ����nums[ismal]��nums[i_min]		
		InvertArray(nums, ismal+1,len-1); //4. ��ismal+1��len-1��Ԫ������
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
