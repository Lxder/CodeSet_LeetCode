package com115.DistinctSubsequences;


//����ķ���������������������������������������������������������
//�ڵݹ�Ĺ����ж����
public class Solution {
	public static void main(String args[]){
		String S = "aab", T = "ab" ; 
		System.out.println("�����ǣ�"+helper(S,T));

	}
//	public int numDistinct(String s, String t) {
//		
//	}
	
	

	
	public static int helper(String s, String t){
		int count = 0;

		if(t.equals("")) {
			System.out.print(s+"-"+t+":");
			System.out.println("ƥ��ɹ�������������������");
			return 1;
		}			
		else if(s.equals("")){
			System.out.print(s+"-"+t+":");
			System.out.println("ƥ��ʧ�ܣ�����������������");
			return 0;
		}
		
		for(int i = 0 ; i < s.length()-t.length()+1; i++){		
			System.out.print("i:"+i+","+"slen:"+s.length()+",tlen:"+t.length()+","+"s[i]:"+s.charAt(i)+",t[0]:"+t.charAt(0));
			if(s.charAt(i)==t.charAt(0)){
				System.out.println("�Ǻ� "+s.substring(i+1)+" "+t.substring(1));
				count = count+helper(s.substring(i+1),t.substring(1));
			}
			else{
				System.out.println("���˸�ȥ "+s.substring(i+1)+" "+t);
				count = count+helper(s.substring(i+1),t);
			}
		}		
		return count;
	}
}
