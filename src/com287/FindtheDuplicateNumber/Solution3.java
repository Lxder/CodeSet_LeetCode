package com287.FindtheDuplicateNumber;

public class Solution3 {
	public static void main(String args[]){
		int[] nums = {1,3,4,7,2,6,5,4};
		System.out.println(findDuplicate(nums));
	}
	

    public static int findDuplicate(int[] nums) {
    	int low = 1 ; 
    	int high = nums.length;
    	while(low<high){
    		int mid = low+(high-low)/2;
    		int count = 0;
    		for(int i = 0 ; i < nums.length ; i++){
    			if(nums[i]<=mid) count++;
    		}
    		if(count>mid)
    			high = mid ;
    		else low = mid+1;
    		
    	}
    	return low;
        
    }
}