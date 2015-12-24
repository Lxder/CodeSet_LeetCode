package com047.PermutationsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution {
	public static void main(String args[]) {
		int[] nums = {3,3,0,3};
		List<List<Integer>> list = permute(nums);
		System.out.println(list);
		System.out.println(list.size());
	}


	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> solu = new ArrayList<List<Integer>>();
	    if(nums.length==0)
	        return solu;
	    Arrays.sort(nums);
	    int len = nums.length;
	    addlist(solu,nums,len);
	    if(nums.length==1)
	    	return solu;
	    
	    ///////////////����ȫ���е�����
	    int count = getCount(nums,len);
	    
	    ////////////////��ò�ͬ��ȫ����
	    while(count>0){
	    	count--;
	    	int ismal = len-2;
		    while(ismal>=0 && nums[ismal]>=nums[ismal+1])
		        ismal--; 	//1. ��ǰ�ҳ���һ�����ұ�����С�����ֵ����j
	
		    if(ismal==-1){ //����������鶼�ǵ����ģ��ͷ��ص�һ�����У�����Ϊ�ݼ����Ǹ�����
		        InvertArray(nums, 0,len-1);
		        addlist(solu,nums,len);
			    continue;
		    }
		    
		    int i_min = ismal+1;	//2. ��P[j]���ұߵ������У��ҳ����б�P[j]���������С������Pk(�Ҳ�Ϊ������)
		    
		    while(i_min<len&& nums[i_min]> nums[ismal]) 
		        i_min++;
		    i_min--;
		    Swap(nums,ismal,i_min);    //3. ����nums[ismal]��nums[i_min]        
		    InvertArray(nums, ismal+1,len-1); //4. ��ismal+1��len-1��Ԫ������
		   
		    addlist(solu,nums,len);
		    
	    }
	    return solu;
	}
	
	//��ý������
	public static int getCount(int[] nums,int len){
		int count = 1;
	    for(int i = len ; i >0 ; i--){
	    	count = count*i;
	    }
	    
	    int temp = 1;
	    for(int i = 0 ; i < len-1 ; i++){
	    	if(nums[i]==nums[i+1])
	    		temp ++ ;
	    	else{
	    		while(temp!=1){
	    			count = count/temp;
	    			temp--;
	    		}	    		
	    	}
	    }
	    
		while(temp!=1){//�������һ����ͬ
			count = count/temp;
			temp--;
		}
	    count--; //ԭʼ�������Ѿ��ӽ�ȥ��
	    return count;
	}
	
	public static void addlist(List<List<Integer>> solu , int[] nums,int len){
		List<Integer> list = new ArrayList<Integer>();		    
	    for(int i = 0 ; i < len ; i++){
	    	list.add(nums[i]);
	    }
	    solu.add(list);
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
