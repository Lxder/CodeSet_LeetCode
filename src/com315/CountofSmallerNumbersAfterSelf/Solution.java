package com315.CountofSmallerNumbersAfterSelf;

import java.util.Arrays;
import java.util.List;

public class Solution {
	
	public static void main(String args[]){
		int[] nums = {5,2,6,1};
		Solution s = new Solution();
		System.out.println(s.countSmaller(nums));
	}
	
	public List<Integer> countSmaller(int[] nums) {
	    int len = nums.length;
		int[] tmp = nums.clone();
	    int[] i_nums = new int[len]; //����numsÿһ��Ԫ��������������е��±�
	    Arrays.sort(tmp);
	    for (int i = 0; i < len; i++) {
	        i_nums[i] = Arrays.binarySearch(tmp, nums[i]);
	    }
	    int[] bit = new int[len]; //�������ֵĽ��
	    Integer[] ans = new Integer[len]; //�������ս��
	    for (int i = len - 1; i >= 0; i--) {
	        ans[i] = bit[i_nums[i]]; //�����ұ߿�ʼ������
	        for(int j = i_nums[i]+1 ; j < bit.length ; j++){
	        	bit[j] ++ ; 
	        	//j��nums[i]����������±�λ�ú�һ����ʼ��bit[j]++,
	        	//��Ϊ������±����Ҳ������һ�������������ִ�
	        	//ע�⣺��λ���ұߵĶ�Ҫ����1���Ѿ��������˵�������û��Ӱ�죬��Ϊ����Ѿ������ˣ�
	        }	        
	    }
	    
	    return Arrays.asList(ans);
	}
}