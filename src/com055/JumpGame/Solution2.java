package com055.JumpGame;

public class Solution2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,0,0};
		System.out.println(canJump3(nums));
	}

	//ֻ���ں���0��ʱ��ſ��ܵ����������ˣ�������0ʱ�����β鿴0֮ǰ��Ԫ�أ����Ƿ�������0
	public static boolean canJump(int[] nums) {
		if(nums ==null) return false;
		if(nums.length==1) return true;		
		int end = nums.length-1; //����λ��helper
		
		int i=0;
		int j ;
		while(i<end){
			for(; i < end ; i++){
				if(nums[i]==0) 
					break;
				else if(nums[i]+i>=end) 
					return true;
			}		
			if(i==end) return true;			
			
			for(j = i-1 ; j >= 0 ; j--){
				if(nums[j]+j>i) break;
			}
			if(j==-1) return false;
			i++;
		}
		
		return true;
	}
	
	//ֻ���ں���0��ʱ��ſ��ܵ����������ˣ�������0ʱ�����β鿴0֮ǰ��Ԫ�أ����Ƿ�������0
	public static boolean canJump2(int[] nums) {
		if(nums ==null||nums[0]==0&&nums.length!=1) return false;
		if(nums.length==1) return true;		
		int end = nums.length; //����λ��helper
		
		for(int i = 1 ; i < end ;i++){
			nums[i] = Math.max(nums[i], nums[i-1]-1); //����Ϊÿ��Ԫ����Զ����ǰ����
			if(nums[i]==0&&i<end-1) return false ;
		}		
		return true;
	}
	
	
	//�Ӻ���ǰ����last�ܲ����Ƶ���ͷ
	public static boolean canJump3(int[] nums) {
		if(nums ==null||nums[0]==0&&nums.length!=1) return false;
		int len = nums.length;
		int last = len-1;
		for(int i = len-2 ; i >=0 ; i--){
			if(nums[i]+i>=last) last = i;
		}
		return last<=0;
	}
	

}
