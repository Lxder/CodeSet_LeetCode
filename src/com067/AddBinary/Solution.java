package com067.AddBinary;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addBinary("1010","1011"));
	}

	public  static String addBinary(String a, String b) {
		StringBuffer sb = new StringBuffer();
		int lena = a.length();
		int lenb = b.length();
		int indexa = lena-1;
		int indexb = lenb-1;
		int tag = 0;
		int vala , valb , sum;
		while(indexa>=0 && indexb >=0){
			vala = Integer.valueOf(a.substring(indexa,indexa+1));
			valb = Integer.valueOf(b.substring(indexb,indexb+1));
			sum = vala + valb +tag;
			if(sum==0) { sb.append("0"); tag = 0;}
			else if(sum==1) { sb.append("1"); tag = 0; }
			else if(sum==2) { sb.append("0") ; tag = 1 ; }
			else{ sb.append(1) ; tag = 1;}
			indexa-- ; 
			indexb--;
		}
		while(indexa >=0 ){
			vala = Integer.valueOf(a.substring(indexa,indexa+1));
			sum = vala + tag;
			if(sum==0) { sb.append("0"); tag = 0;}
			else if(sum==1) { sb.append("1"); tag = 0;}
			else  { sb.append("0") ; tag = 1 ; }
			indexa-- ;
		}
		while(indexb >=0 ){
			valb = Integer.valueOf(b.substring(indexb,indexb+1));
			sum = valb + tag;
			if(sum==0) { sb.append("0"); tag = 0;}
			else if(sum==1) { sb.append("1"); tag = 0;}
			else  { sb.append("0") ; tag = 1 ; }
			indexb-- ;
		}
		if(tag==1)
			sb.append("1");
		
		return sb.reverse().toString();
		
		
	}

	
	//不能处理过长的二进制数
//	public  static String addBinary(String a, String b) {
//		int value1 = Integer.valueOf(a, 2);
//		int value2 = Integer.valueOf(b, 2);
//		int sum = value1 + value2;
//
//		return Integer.toBinaryString(sum);
//	}

}
