package com307.RangeSumQueryMutable;

//错误！！！！大数据超时！！！！！！！！！！！！！！！！！！！！！！！！！！！
public class NumArray2 {
	public static void main(String args[]){
		
		int[] nums = {1, 3, 5};
		NumArray2 n = new NumArray2(nums);
		
		System.out.println(n.sumRange(0, 2));
		n.update(1, 2);
		System.out.println(n.sumRange(0, 2));
	}
	
	int[] arr;
	int[] sum ;
	int currmax = 0; //保存准确部分和的下一个位置
    public NumArray2(int[] nums) {
    	int len = nums.length;
    	arr = new int[len];
    	sum = new int[len+1];
    	sum[0]=0;
    	currmax = len;
    	
        for(int i = 0 ; i < len ; i++){
        	arr[i] = nums[i];
        	sum[i+1] = sum[i] + arr[i];
        }
    }

    void update(int i, int val) {
        arr[i] = val;        
        if(i<currmax)
        	currmax = i;
    }

    public int sumRange(int i, int j) {
        if(j<currmax) return sum[j+1]-sum[i];
        else {        	
        	for(int k = currmax ; k<=j ;k++){
        		sum[k+1] = sum[k]+arr[k];
        	}
        	currmax = j;        	
        	return sum[j+1]-sum[i];
        }
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);