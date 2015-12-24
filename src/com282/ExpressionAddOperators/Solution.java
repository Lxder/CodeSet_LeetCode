package com282.ExpressionAddOperators;

import java.util.ArrayList;
import java.util.List;


public class Solution {

	int i=1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> solu = addOperators("2147483647",2147483647);
		System.out.println(solu);
	}
	
	public static List<String> addOperators(String num, int target) {
		List<String> solustr = new ArrayList<String>();
		int len = num.length();
		for(int i= 1 ; i <= len  ;i++ ){
			String first = num.substring(0,i);		
			String currstr = first;	
			if(i>1 && currstr.charAt(0)=='0') break; 
			long currnum = Long.valueOf(currstr);
			helper(num.substring(i),target,solustr,currstr,currnum,currnum);
		}
		return solustr;
	}
	
	public static void helper(String num, long target,
			List<String> solustr , String currstr,long currsolu,long multed){
		if(num.length()==0){
			if (target==currsolu){
				solustr.add(currstr);
			}	
			return;
			
		}
		int len = num.length();
		for(int i = 1 ; i <= len ; i++){
			String s = num.substring(0,i);
			if(i>1 && s.charAt(0)=='0') break; 
			//System.out.println(currsolu+" "+(currsolu*Integer.valueOf(s)));
			long currnum = Integer.valueOf(s);
			helper(num.substring(i),target,solustr,currstr+"+"+s,currsolu+currnum,currnum);
			helper(num.substring(i),target,solustr,currstr+"-"+s,currsolu-currnum,-currnum);
			helper(num.substring(i),target,solustr,currstr+"*"+s,currsolu-multed+multed*currnum,multed*currnum);
		}
	}

}
