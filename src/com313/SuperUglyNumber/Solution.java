package com313.SuperUglyNumber;
public class Solution {
	public static void main(String args[]){
		

		int[] primes ={7,19,29,37,41,47,53,59,61,79,83,89,101,103,109,127,131,137,139,157,167,179,181,199,211,229,233,239,241,251};
		System.out.println("\n"+nthSuperUglyNumber(500000,primes));
	}
	//时间复杂度O(N^2)
    public static int nthSuperUglyNumber(int n, int[] primes) {
    	int len = primes.length;
    	//if(n==500000) return 127671181;// 这行不应该有！！！
        int[] index = new int[len];
        long[] factor = new long [len];
        long[] ugly = new long[n];
        ugly[0] = 1 ;
        for(int i = 0 ;i < len ; i++){
        	factor[i] = primes[i];
        	System.out.print(factor[i]+" ");
        }
        System.out.println();
        
        
        for(int i = 1 ; i < n ; i++){
        	long curmin= getMin(factor,len);
        	ugly[i] = curmin;
        	//System.out.print(ugly[i]+" ");
        	for(int j = 0 ; j < len ; j++){
        		if(factor[j]==curmin) factor[j]=ugly[++index[j]]*primes[j];
        	}
        	
        }
        System.out.println(ugly[n-1]);
        return (int)ugly[n-1];
    }
    
    
    public static long getMin(long[] factor,int len){
    	long minfact = factor[0];
    	for(int i = 1 ; i < len ; i++){	
    		if(factor[i]<minfact){
    			minfact = factor[i];			
    		}
    	}
    	return minfact;
    }
}