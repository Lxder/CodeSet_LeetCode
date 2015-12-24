package com276.hindex2;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] citations = {0,0,1,2,3,4};//,5,6,7,9,11};
		System.out.println(hIndex(citations));

	}

	public static  int hIndex(int[] citations) {
		int len = citations.length;
		if (len==0) return 0;
		int low = 0 ; 
		int high = len-1;
		int count = 0 ;
		int mid = 0 ;
		while(low<=high){
			mid = ( low+high ) /2;
			count = len - mid;
			if(count == citations[mid])
				return count;
			else if(count>citations[mid])
				low = mid+1;
			else high = mid-1;
		}
		
		if(count < citations[mid])
			return count;
		
		return count-1;
	}

}
