package com097.InterleavingString;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub"aabaac", "aadaaeaaf", "aadaaeaabaafaac"

		String s1 = "aabaac";
		String s2 = "aadaaeaaf";

		String s3 = "aadaaeaabaafaac";
		System.out.println(isInterleave(s1,s2,s3));

	}

	public static boolean isInterleave(String s1, String s2, String s3) {
		int len1 = s1.length();
		int len2 = s2.length();
		if(s3.length()!=len1+len2) return false;
		
		if(len1==0) return s2.equals(s3);
		if(len2==0) return s1.equals(s3);
		
		int[][] dynarr = new int[len2+1][len1+1];
		dynarr[0][0]=1;
		for(int i = 1 ; i <= len1 ; i++){
			if(s1.charAt(i-1)==s3.charAt(i-1)&&dynarr[0][i-1]==1)
				dynarr[0][i] = 1;
		}
		
		for(int i = 1 ; i <= len2 ; i++){
			if(s2.charAt(i-1)==s3.charAt(i-1)&&dynarr[i-1][0]==1)
				dynarr[i][0] = 1;
		}
		
		for(int i = 1 ; i <= len2 ; i++){
			for(int j = 1 ; j <= len1 ; j++){
				if((dynarr[i-1][j]==1&&s2.charAt(i-1)==s3.charAt(i+j-1))||
					(dynarr[i][j-1]==1&&s1.charAt(j-1)==s3.charAt(i+j-1)))
						
					dynarr[i][j]=1;
			}
		}
		
		for(int i = 0  ; i <= len2 ;i++){
			for(int j = 0 ; j <= len1 ; j++){
				System.out.print(dynarr[i][j]+" ");
			}
			System.out.println();
		}
		if(dynarr[len2][len1]==1) return true;
		else return false;
		
		
		
	}

}
