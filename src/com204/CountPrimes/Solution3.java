package com204.CountPrimes;


public class Solution3 {

	public static void main(String args[]){
		System.out.println("�����"+countPrimes(5000000));
	}
	public static int countPrimes(int n) {		
		boolean notPrime[] = new boolean[n + 2];
	    notPrime[0] = notPrime[1] = true;
	    for (int i = 2; i * i < n; i++) {
	      if (!notPrime[i]) {
	        int c = i * i; //ע�� inner loop��i��ʼ, ��iС�Ļ�����ǰ�ͱ�check��.��һ���Ǳ�iС�����ı�����
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
//    	  //ע�� inner loop��i��ʼ, ��iС�Ļ�����ǰ�ͱ�check��.
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
