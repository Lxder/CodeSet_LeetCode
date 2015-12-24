package com275.hindex;


public class Solution2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] citations = {0,10,1,2,3,4,5,6,7,9,11};
		System.out.println(hIndex(citations));
		
		
		int[] arr = {0,3,1,4,2,6,5};

	}

	public static void sory(int[] arr){
		int len = arr.length;
		int[] countarr = new int[len+1];
		for(int i = 0 ; i < len ; i++){
			countarr[arr[i]]++;
		}
		for(int i = 0 ; i < len ; i++){
			countarr[i+1] = countarr[i]+countarr[i+1];
			System.out.println(countarr[i+1]);
		}
		
	}
	
	
	public static int hIndex(int[] citations) {
		int len = citations.length;
		if (len==0) return 0;
		
		int[] countarr = new int[len+1];
		for(int i = 0 ; i < len;  i++){
			if(citations[i]>=len) countarr[len]++;
			else
				countarr[citations[i]]++;
		}

		if(countarr[len]>=len) return len;
		for(int i = len-1 ; i >=0 ; i--){
			countarr[i] = countarr[i]+countarr[i+1];
			if(countarr[i]>=i) return i;
		}
		return 0;
	}

}
