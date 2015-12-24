package com151.ReverseWordsinaString;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "  the   sky is blue   ";
		System.out.println("|"+s.trim()+"|");
		System.out.println("|"+s+"|");
		System.out.println(reverseWords(s));
	}

	public static String reverseWords(String s) {
		String nstr =  s.trim();
		String[] arr =  nstr.split("\\s+");
		StringBuffer solu = new StringBuffer();
		int len = arr.length;
		for(int i = 0 ; i < len ; i++){
			StringBuffer curr = new StringBuffer(arr[i]);
			solu.append(curr.reverse()+" ");
		}
		solu.deleteCharAt(solu.length()-1);
		solu.reverse();
		return solu.toString();
	}

}
