package com065.ValidNumber;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "1e.";
		System.out.println(isNumber(s));
	}

	public static boolean isNumber(String s) {
		String str = s.trim();
		int len = str.length();
		if(len==0) return false;
		char start = str.charAt(0);
		//������Ǹ��ţ����һλ���������� ���ߵ�
		boolean hase = false; //eֻ����1��
		boolean haspoi = false; //С����ֻ����1��
		if(start=='.') {
			haspoi = true;
			if(len>2){
				if(str.charAt(1)=='e') return false;
			}
			
		}
		else if(start!='-'&&(start-'0'>9 || start-'0'<0)) 
			return false; 
				
		
		for(int i = 1 ; i < len ;i++){
			char curr = str.charAt(i);
			if(curr=='.'){ 
				if(haspoi==true)  return false;
				else  {
					haspoi = true;
					if(i+1<len){
						curr = str.charAt(i+1);
						if(curr=='e') return false;
					}
				}
			}
			else if(curr=='e'){
				if(hase == true) return false;
				else {
					hase = true;
					if(i+1<len){
						curr = str.charAt(i+1);
						if(curr=='-')i++;
					}
				}
			}else if(curr-'0'>9||curr-'0'<0) return false;		
			
		}
		//������һλ��e����. ����false
		char end = str.charAt(len-1);
		if(end=='e'||end=='-') return false;
		if(len==1&&end=='.') return false;
		
		

		return true;
		
	}
}
