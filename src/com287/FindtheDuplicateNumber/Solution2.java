package com287.FindtheDuplicateNumber;

public class Solution2 {
	public static void main(String args[]){
		int[] nums = {1,3,4,7,2,6,5,4};
		System.out.println(findDuplicate(nums));
	}
	

	
	//等同于寻找循环链表的头部
    public static int findDuplicate(int[] nums) {
    	int slow = 0;
    	int fast = 0;
    	while(true){
    		slow = nums[slow];
    		fast = nums[nums[fast]];
    		if(slow==fast)
    			break;
    	}//先找到一个相交位置
    	
    	//令一个指针从头开始,两个指针同时后移，
    	//再次相交（两个元素相等）的位置就是头部，这个元素就是重复元素
    	fast = 0 ;
    	while(true){
    		slow = nums[slow];
    		fast = nums[fast];
    		if(slow==fast)break;
    	}
    	return slow;
        
    }
}