package com282.ExpressionAddOperators;

import java.util.ArrayList;
import java.util.List;


public class Solution2 {

	int i=1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> solu = addOperators("3456237490",9191);
		System.out.println(solu);
	}
	
	public static List<String> addOperators(String num, int target) {
		List<String> solustr = new ArrayList<String>();
		helper(num.substring(0),target,solustr,"",1,1);		
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
			System.out.println(currsolu+" "+(currsolu*Long.valueOf(s)));
			
			long currnum = Long.valueOf(s);
			if(currstr.length()==0)
				helper(num.substring(i),target,solustr,s,currnum,currnum);
			else{
				helper(num.substring(i),target,solustr,currstr+"+"+s,currsolu+currnum,currnum);
				helper(num.substring(i),target,solustr,currstr+"-"+s,currsolu-currnum,-currnum);
				helper(num.substring(i),target,solustr,currstr+"*"+s,currsolu-multed+multed*currnum,multed*currnum);
			}
		}
	}

}
