package com303.RangeSumQuery_Immutable;
public class NumArray {
	
	public static void main(String args[]){
		int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
		NumArray numArray = new NumArray(nums);
		System.out.println(numArray.sumRange(0, 2));
		System.out.println(numArray.sumRange(2,5));
		System.out.println(numArray.sumRange(0,0));
	}
	int[] sum ;
    public NumArray(int[] nums) {
        sum = new int[nums.length+1];
        if(nums.length<=0) return;
        sum[0] = 0;
        for(int i = 0 ;i < nums.length ; i++){
        	
        	sum[i+1] = sum[i]+nums[i];
        }
        for(int i = 0 ; i < sum.length ; i++){
        	System.out.print(sum[i]+" ");
        }
        System.out.println();
    }

    public int sumRange(int i, int j) {
        return sum[j+1] - sum[i];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);