package com001.twosum;

import java.util.Arrays;

class Pair implements Comparable<Pair>{  
	public int number;
    public int idx;  
    public Pair(int number, int idx){  
        this.number = number;  
        this.idx = idx;  
    }
    public int compareTo(Pair other){  
        return this.number - other.number;  
    }
}  

public class Solution {  

	public static void main(String[] args) {
		int[] nums = {-1,-2,-3,-4,-5};
		int[] solu = twoSum(nums,-8);
		System.out.println(" "+solu[0]+" "+solu[1]);

	}
    public static int[] twoSum(int[] numbers, int target) {  
        int n = numbers.length;  
        Pair[] pairs = new Pair[n];  
        for(int i = 0; i < n; ++i){  
            pairs[i] = new Pair(numbers[i], i + 1);  
        }  
        Arrays.sort(pairs);
        int [] result = new int[2];  
        int begin = 0;  
        int end = n - 1;  
        while(begin < end){  
            if(pairs[begin].number + pairs[end].number < target){  
                begin++;  
            }  
            else if (pairs[begin].number + pairs[end].number > target){  
                end--;  
            }  
            else{  
                if(pairs[begin].idx > pairs[end].idx){  
                    result[0] = pairs[end].idx;  
                    result[1] = pairs[begin].idx;  
                }else{  
                result[0] = pairs[begin].idx;  
                result[1] = pairs[end].idx;  
                }  
                break;  
            }  
        }  
        return result;  
    }  
}  



