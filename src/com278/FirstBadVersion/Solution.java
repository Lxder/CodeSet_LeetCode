package com278.FirstBadVersion;

public class Solution {
	
	/* The isBadVersion API is defined in the parent class VersionControl.
    boolean isBadVersion(int version); */

//	public int firstBadVersion(int n) {
//		if(n==0) return 0;
//		int low = 1 ; 
//		int high = n;
//		int mid;
//		while(low<high){
//			mid = low+(high-low)/2;
//			if(isBadVersion(mid)==false){
//				low = mid +1;
//			}
//			else 
//				high = mid-1;
//		}
//		if(isBadVersion(low)==true) return low;
//		else return low+1;
//	}
	
	
	
	
	public static void main(String args[]){
		int[] arrs = new int[50000];
		arrs[49997] = 1;
		arrs[49998] = 1;
		arrs[49999] = 1;
		
		
		//int[] arrs = {-1,0,0,0,0,0,0,0,1,1,1};
		System.out.println(firstBadVersion(49999,arrs));
	}
	
	
	public  static int firstBadVersion(int n,int arrs[]) {
		
		int low = 1 ; 
		int high = n;
		int mid;
		while(low<high){
			mid = low+(high-low)/2;
			if(arrs[mid]==0){
				low = mid +1;
			}
			else 
				high = mid-1;
		}
		
		if(arrs[low]==1) return low;
		else return low+1;
	}
}


