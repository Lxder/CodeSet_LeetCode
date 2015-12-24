package com006.ZigZagConversion;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = convert("PAYPALISHIRING",3);
//		String str = convert("ABC",1);
		System.out.println(str);

	}

	public static String convert(String s, int numRows) {
		List<Character>[] csolu = new ArrayList[numRows];
		for(int i = 0 ; i <numRows ; i++){
			csolu[i] = new ArrayList<Character>();
		}
		char c ;
		int index = 0;
		int len = s.length();
		int trow = 0;
		while (index<len) {
			for(trow = 0 ; trow<numRows&&index<len ; trow++){
					c = s.charAt(index);
					csolu[trow].add(c);
					index++;					
			}
			for(trow = numRows - 2 ; trow>0&&index<len ; trow--){
					c = s.charAt(index);
					csolu[trow].add(c);
					index++;
			}
		}
		
		trow = 0;
		StringBuffer sb = new StringBuffer();
		while(trow<numRows){
			for(Object cb : csolu[trow]){
				sb.append(cb);
			}
			trow++;
		}
		return sb.toString();
	}

}
