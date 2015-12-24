package com287.FindtheDuplicateNumber;

public class Solution2 {
	public static void main(String args[]){
		int[] nums = {1,3,4,7,2,6,5,4};
		System.out.println(findDuplicate(nums));
	}
	

	
	//��ͬ��Ѱ��ѭ�������ͷ��
    public static int findDuplicate(int[] nums) {
    	int slow = 0;
    	int fast = 0;
    	while(true){
    		slow = nums[slow];
    		fast = nums[nums[fast]];
    		if(slow==fast)
    			break;
    	}//���ҵ�һ���ཻλ��
    	
    	//��һ��ָ���ͷ��ʼ,����ָ��ͬʱ���ƣ�
    	//�ٴ��ཻ������Ԫ����ȣ���λ�þ���ͷ�������Ԫ�ؾ����ظ�Ԫ��
    	fast = 0 ;
    	while(true){
    		slow = nums[slow];
    		fast = nums[fast];
    		if(slow==fast)break;
    	}
    	return slow;
        
    }
}