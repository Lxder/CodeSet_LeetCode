package com204.CountPrimes;


public class Solution3 {

	public static void main(String args[]){
		System.out.println("结果："+countPrimes(5000000));
	}
	public static int countPrimes(int n) {		
		boolean notPrime[] = new boolean[n + 2];
	    notPrime[0] = notPrime[1] = true;
	    for (int i = 2; i * i < n; i++) {
	      if (!notPrime[i]) {
	        int c = i * i; //注意 inner loop从i开始, 比i小的会在以前就被check过.（一定是比i小的数的倍数）
	        while (c < n) { 
	          notPrime[c] = true;
	          c += i;
	        }
	      }
	    }
	    int ans = 0;
	    for (int i = 0; i < n; i++) {
	      if (!notPrime[i])
	        ans ++;
	    }
	    return ans;
	}
}

//
//public static int countPrimes(int n) {		
//	boolean notPrime[] = new boolean[n + 2];
//    notPrime[0] = notPrime[1] = true;
//    for (int i = 2; i * i < n; i++) {
//      if (!notPrime[i]) {
//    	  //注意 inner loop从i开始, 比i小的会在以前就被check过.
//    	  for(int j = i ; i*j<n ; j++){
//    		  notPrime[j*i] = true;
//    	  }	        
//      }
//    }
//    int ans = 0;
//    for (int i = 0; i < n; i++) {
//      if (!notPrime[i])
//        ans ++;
//    }
//    return ans;
//}
