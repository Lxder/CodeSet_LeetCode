package com215.KthLargestElementinanArray;


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {7,6,5,4,3,2,1};
		System.out.println(findKthLargest(nums,2));
	}

	public static int findKthLargest(int[] nums, int k) {
		int len = nums.length;
		return kbig(nums,0,len-1,len-k);
	}
	
	
	//Ѱ�ҵ�kС��Ԫ��
	public static int kbig(int[] nums, int left , int right , int k ){
        
        System.out.println("left "+left + " right "+ right+" k "+k);
		if(left>right) return -1;
		
		int key = nums[left];
        int low = left; 
        int high = right;
        
        while(low < high){
            while(low < high && nums[high]>=key)
                high--;
            nums[low] = nums[high];
            while(low<high && nums[low]<=key)
                low++;
            nums[high] = nums[low];
        }
        nums[low] = key;
        //һ�˿��Ž���, lowλ�õ�Ԫ���Ѿ�������λ������ ,������lowС���Ҳ����low��
        
        if(low==k) return nums[low];

        if(low<k)
        	return kbig(nums,low+1,right,k);
        else return kbig(nums,left,low-1,k);
	}
	
	

}
