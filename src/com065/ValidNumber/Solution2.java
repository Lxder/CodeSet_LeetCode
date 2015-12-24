package com065.ValidNumber;

public class Solution2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "3.3e5.2";
		System.out.println(isNumber(s));

	}

	public static boolean isNumber(String s) {
		String str = s.trim();
		int len = str.length();
		if(len==0) return false;
		String[] nums = str.split("e");
		int nlen = nums.length;
		if(nlen>2) return false;
		if(str.charAt(len-1)=='e'||str.charAt(0)=='e') return false;
		
		if(isnum(nums[0])==false) return false;
		if(nlen==2&&isint(nums[1])==false) return false;

		return true;
		
	}
	
	public static boolean isnum(String str){
		int len = str.length();
		char start = str.charAt(0);
		//如果不是负号，则第一位必须是数字 或者点
		boolean haspoi = false; //小数点只能有1个
		boolean flag = false; //必须要有一个数字
		if(start=='.') {
			haspoi = true;			
		}else if(start-'0'<=9 && start-'0'>=0){ 
			flag = true;
		}else if(start!='-'&&start!='+') 
			return false; 				
		
		for(int i = 1 ; i < len ;i++){
			char curr = str.charAt(i);
			if(curr=='.'){ 
				if(haspoi==true)  return false;
				else haspoi = true;
			}
			else if(curr-'0'>9||curr-'0'<0) return false;
			if(curr-'0'<=9&&curr-'0'>=0) flag = true;
			
		}
		//如果最后一位是 . 返回false
		char end = str.charAt(len-1);
		if(end=='-'||end=='+') return false;
		if(len==1&&end=='.') return false;		
		if(flag==false) return false;
		
		return true;
	}
	
	public static boolean isint(String str){
		int len = str.length();
		char start = str.charAt(0);
		//如果不是负号，则第一位必须是数字 或者点
		boolean flag = false; //必须要有一个数字
		if(start-'0'<=9 && start-'0'>=0){ 
			flag = true;
		}else if(start!='-'&&start!='+'&&(start-'0'>9 || start-'0'<0)) 
			return false; 				
		for(int i = 1 ; i < len ;i++){
			char curr = str.charAt(i);
			if(curr-'0'>9||curr-'0'<0) return false;
			if(curr-'0'<=9&&curr-'0'>=0) flag = true;			
		}

		char end = str.charAt(len-1);
		if(end=='-'||end=='+') return false;
		if(flag==false) return false;		
		return true;
	}
}
