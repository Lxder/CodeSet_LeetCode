package com153.FindMinimuminRotatedSortedArray;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4,5,6,7,1,2,3};
		System.out.println(findMin(nums));
	}
	
	public static  int findMin(int[] nums) {
		int len = nums.length;
		int start = 0 ; 
		int end = len-1 ;
		if(nums[start]<=nums[end]) //��ʾ�������������
			return nums[start];
		int mid ;
		
		while(start+1<end){
			mid= (start+end)/2;
			
			if(nums[mid]>nums[start]){ //���м��Ԫ�ش���startԪ�أ���start=min����˼����startһֱ�����������
				start = mid;
			}
			else if(nums[mid]<nums[end]){ //���м��Ԫ��С��startԪ�أ���end=min����˼����endһֱ��С��������
				end = mid;
			}
		}
		//Ҫ�����СԪ�ص�λ�þ���start����һ������Ҳ����end�� ��Ϊ��������ת�ģ�����������һ��������С��
		return nums[end];
    }

}
