package com006.ZigZagConversion;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = convert("PAYPALISHIRING",3);
//		String str = convert("ABC",1);
		System.out.println(str);

	}

	public static String convert(String s, int numRows) {
		List[] csolu = new ArrayList[numRows];
		for(int i = 0 ; i <numRows ; i++){
			csolu[i] = new ArrayList();
		}
		char c ;
		int index = 0;
		int len = s.length();
		int flag = 1;
		int trow = 0;
		while (index<len) {
			if (flag == 1) {
				if (trow < numRows) {
					c = s.charAt(index);
					csolu[trow].add(c);
					index++;					
					trow++;
					
				} else {
					trow=numRows-2;
					flag = 0;
				}
			}else{
				if (trow > 0 ) {
					c = s.charAt(index);
					csolu[trow].add(c);
					index++;					
					trow--;
					
				} else {
					trow = 0;
					flag = 1;
				}
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
