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
				currlen = 0; //只要有分隔开的括号，那么当前这段的长度就是从0开始计算。如果能消除分隔，那么可以将长度相加
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
	
	//使用栈
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
	
	//DP,实质上和栈的原理差不多
	public static int longestValidParentheses3(String s) {
	    char[] S = s.toCharArray();
	    int[] V = new int[S.length];
	    int open = 0; //看左括号是否比右括号多
	    int max = 0;
	    for (int i=0; i<S.length; i++) {
	        if (S[i] == '(') open++;
	        if (S[i] == ')' && open > 0) { //有一对匹配的括号
	        	V[i] = 2 + V[i-1]; 
	        	if(i-V[i] >= 0) {
	        		//看是否能和前面的长度相加。如果i-V[i]位置是左括号，则V[i-V[i]]=0不影响.若不是，那么可以将长度叠加
	        		V[i] += V[i-V[i]]; 
	        	  
	        	}
	            open--;
	        }
	        if (V[i] > max) max = V[i];
	    }
	    return max;
	}

}
