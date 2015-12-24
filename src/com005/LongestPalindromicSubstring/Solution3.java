package com005.LongestPalindromicSubstring;

public class Solution3 {

	public static void main(String[] args) {
		//String str = longestPalindrome("bb");
		String str = longestPalindrome("ababccbaaaaeceaa");
		//String str = longestPalindrome("abcba");
		System.out.println("������Ӵ�Ϊ��" + str);

	}

	public static String longestPalindrome(String s) {
		int len = s.length();
		StringBuffer sb = new StringBuffer();
		sb.append("*");  //ͷ����һ��*
		sb.append("#");
		for(int i = 0  ; i <len ;i++){
			sb.append(s.charAt(i));
			sb.append("#");
		}
		sb.append("^");		//β���Ӹ�^,ע��Ҫ��ͷ����ͬ
		String str = sb.toString(); 
		int sblen = str.length()-2; 
		int[] p = new int[sblen];
		int id = 0 ;
		int maxlen = 0;
		int maxid = 0;
		for(int i=2;i<sblen;i++){
			if(p[id]+id>i)
				p[i]=Math.min(p[2*id-i],p[id]+id-i);  
			else p[i]=1;
			
			while(str.charAt(i-p[i]) == str.charAt(i+p[i])){
				p[i]++;
			}
			if(id+p[id]<i+p[i])
				id=i;  
			if(maxlen<p[i]){
				maxlen=p[i];
				maxid =i;
			}
	    }  
		StringBuffer solu = new StringBuffer();
		for(int i = maxid-maxlen+2 ; i <maxid+maxlen ; i+=2){
			solu.append(str.charAt(i));
		}		
		return solu.toString();
		
	}
}
