package com032.LongestValidParentheses;

import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestValidParentheses3("()((())"));

	}

	public static int longestValidParentheses(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		int len = s.length();
		int currlen = 0;
		int maxlen = 0;
		char c ;
		for(int i = 0 ; i < len ; i++){
			c = s.charAt(i);
			if(c=='('){
				stack.add(currlen);
				currlen = 0; //ֻҪ�зָ��������ţ���ô��ǰ��εĳ��Ⱦ��Ǵ�0��ʼ���㡣����������ָ�����ô���Խ��������
			}
			else{
				if(stack.isEmpty())
					currlen = 0;
				else{
					currlen = currlen + stack.pop() + 2;
					if(currlen>maxlen)	maxlen = currlen;
				}
			}
		}
		return maxlen;
	}
	
	//ʹ��ջ
	public static int longestValidParentheses2(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		int len = s.length();
		int maxlen = 0;
		int left = -1 ; 

		for(int i = 0 ; i < len ; i++){
			if(s.charAt(i)=='('){
				stack.add(i);
			}
			else{
				if(stack.isEmpty()) left = i;
				else{
					stack.pop();
					if(stack.isEmpty()){
						maxlen = Math.max(maxlen, i-left); 
					}
					else{
						maxlen = Math.max(maxlen, i-stack.peek());
					}
				}
			}
		}
		return maxlen;
	}
	
	//DP,ʵ���Ϻ�ջ��ԭ����
	public static int longestValidParentheses3(String s) {
	    char[] S = s.toCharArray();
	    int[] V = new int[S.length];
	    int open = 0; //���������Ƿ�������Ŷ�
	    int max = 0;
	    for (int i=0; i<S.length; i++) {
	        if (S[i] == '(') open++;
	        if (S[i] == ')' && open > 0) { //��һ��ƥ�������
	        	V[i] = 2 + V[i-1]; 
	        	if(i-V[i] >= 0) {
	        		//���Ƿ��ܺ�ǰ��ĳ�����ӡ����i-V[i]λ���������ţ���V[i-V[i]]=0��Ӱ��.�����ǣ���ô���Խ����ȵ���
	        		V[i] += V[i-V[i]]; 
	        	  
	        	}
	            open--;
	        }
	        if (V[i] > max) max = V[i];
	    }
	    return max;
	}

}
