package com224.BasicCalculator;

import java.util.Stack;


public class Solution {

	public static void main(String[] args) {
		String s ="(1+(4+((5+2)))-3)+(6+8)";
		System.out.println(calculate(s));

	}

	
	//首先需要将中序表达式转换为先序，然后利用栈计算	
	//需要两个栈，分别存放数字和运算符
	
	public static int calculate(String s) {
		int len = s.length();
		if (len==0) return 0;
		
		Stack<Integer> stacknum = new Stack<Integer>(); //数字栈
		Stack<Character> stackop = new Stack<Character>(); //运算符栈

		int i = 0 ;
		while(i < len){
			char currc = s.charAt(i);
			if(currc==' '){
				i++;
			}else if(currc=='('){
				i++;
				stackop.add('(');
			}else if(currc==')'){
				i++;
				//开始出栈并计算，直到遇到(为止
				while(stackop.peek()!='(')
					stacknum.add(helper(stacknum.pop(),stacknum.pop(),stackop.pop()));
				stackop.pop(); //把左括号出栈
			}else if(currc=='+'||currc=='-'){
				i++;				
				if(stackop.isEmpty()||stackop.peek()=='('){					
					stackop.add(currc);
					continue;
				}				
				stacknum.add(helper(stacknum.pop(),stacknum.pop(),stackop.pop()));				
				stackop.add(currc);
				
			}else{
				StringBuffer currsb = new StringBuffer();
				while(currc>='0'&& currc<='9'){
					currsb.append(currc);
					i++;
					if(i>=len) break;
					currc = s.charAt(i);
				}
				stacknum.add(Integer.valueOf(currsb.toString())); //数字入栈
			}
		}

		//将剩余数字相加
		while(!stackop.isEmpty()){
			if(stackop.peek()=='(')
				stackop.pop();
			else{				
				stacknum.add(helper(stacknum.pop(),	stacknum.pop(),	stackop.pop()));
			}			
		}
		return stacknum.peek();
	}
	
	public static int helper(int num1,int num2, char op){
		int res =0;
		switch (op){
		case '+': res = num1+num2; break;
		case '-': res = num2-num1; break;
		case '*': res = num1*num2; break;
		case '/': res = num2/num1; break;
		}
		return res;
		
	}

}