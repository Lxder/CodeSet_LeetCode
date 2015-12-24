package com315.CountofSmallerNumbersAfterSelf;

import java.util.Arrays;
import java.util.List;

//�����߶���,����solution
public class Solution3 {
	
	public static void main(String args[]){
		int[] nums = {5,2,6,1};
		Solution3 s = new Solution3(); 
		System.out.println(s.countSmaller(nums));
	}
	
	
	private void add(int[] bit, int i, int val) {//���߶�������
        for (; i < bit.length; i += i & -i) 
        	bit[i] += val;        
    }

    private int query(int[] bit, int i) { //���߶������ ��1��i
        int ans = 0;
        for (; i > 0; i -= i & -i) 
        	ans += bit[i];
        return ans;
    }
    
    public List<Integer> countSmaller(int[] nums) {
        int[] tmp = nums.clone();
        Arrays.sort(tmp);
        for (int i = 0; i < nums.length; i++) 
        	nums[i] = Arrays.binarySearch(tmp, nums[i]) + 1;
        int[] bit = new int[nums.length + 1];
        Integer[] ans = new Integer[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] = query(bit, nums[i] - 1);
            add(bit, nums[i], 1);
        }
        return Arrays.asList(ans);
    }
}