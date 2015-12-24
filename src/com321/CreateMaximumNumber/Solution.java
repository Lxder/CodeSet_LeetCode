package com321.CreateMaximumNumber;
public class Solution {
	public static void main(String args[]){
		int[] nums1 = {8,9};
		int[] nums2 = {3,9};
		Solution s = new Solution();
		int[] solu = s.maxNumber(nums1, nums2, 3);
		for(int i = 0 ; i < solu.length ; i++){
			System.out.println(solu[i]);
		}
	}
	
	
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
    	int[] solu = new int[k];
    	int len1 = nums1.length;
		int len2 = nums2.length;
    	int st1 = 0, st2 = 0 ;
    	int imax1 = 0 , imax2 = 0;
    	int ed1 = Math.min(len1-1,len1 - k + (len2-st2));
		int ed2 = Math.min(len2-1,len2 - k + (len1-st1));
    	for(int i = 0 ; i < k ; i++){
    		int left = k-i; //剩余需要添加的数字数量
    		int tempmax = 0;   		
    		
    		for(int j = st1 ; j <= ed1 ; j++){
    			if(nums1[j]>tempmax){
    				tempmax = nums1[j];
    				imax1 = j;
    			}
    		}
    		for(int j = st2 ; j <= ed2 ; j++){
    			if(nums2[j] > tempmax){
    				tempmax = nums2[j];
    				imax2 = j;
    			}
    		}
    		if(len1>0&&nums1[imax1] == tempmax){
    			st1 = imax1 + 1;
    		}else{
    			st2 = imax2 + 1;
    		}
    		solu[i] = tempmax;
    		left --;
    		ed1 = len1 - left + (len2-st2);
    		ed2 = len2 - left + (len1-st1);
    		if(ed1>=len1) ed1 = len1-1;
    		if(ed2>=len2) ed2 = len2-1;
//    		System.out.println(len1);
//    		System.out.println(len2);
//    		System.out.println("剩余："+left);
//    		System.out.println(st1+" "+st2+" : "+ed1+" "+ed2);
    	}
    	return solu;
    }
}