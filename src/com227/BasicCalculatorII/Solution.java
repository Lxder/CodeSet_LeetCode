package com227.BasicCalculatorII;

import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s ="100000000/1/2/3/4/5/6/7/8/9/10";
		System.out.println(calculate(s));
//		for(int i = 0 ; i < s.length() ; i++){
//			char c = s.charAt(i);
//			if(c==' ')
//				System.out.println("啊啊");
//		}
	}

	
	//首先需要将中序表达式转换为先序，然后利用栈计算
	
	//需要两个栈，分别存放数字和运算符
	
	public static int calculate(String s) {
		int len = s.length();
		if (len==0) return 0;
		
		Stack<Integer> stacknum = new Stack<Integer>(); //数字栈
		Stack<Character> stackop = new Stack<Character>(); //运算符栈
		StringBuffer sb_midstr = new StringBuffer(); 
		
		int i = 0 ;
		while(i < len){
			char currc = s.charAt(i);
			if(currc==' '){
				i++;
				continue; //忽略空字符串
			
			}else if(currc=='+'||currc=='-'){
				i++;
				System.out.println("出现加减");
				
				if(stackop.isEmpty()){
					stackop.add(currc);
					continue;
				}
				while(!stackop.isEmpty()){
					sb_midstr.append(" "+stackop.peek());
					stacknum.add(helper(stacknum.pop(),stacknum.pop(),stackop.pop()));
					
				}
				stackop.add(currc);
				
			}else if(currc=='*'||currc=='/'){
				while(!stackop.isEmpty()&&(stackop.peek()=='*'||stackop.peek()=='/')){
					sb_midstr.append(" "+stackop.peek());
					stacknum.add(helper(stacknum.pop(),stacknum.pop(),stackop.pop()));
				}
					
				stackop.add(currc);
				i++;
				System.out.println("出现乘除");
			}
			
			else{
				StringBuffer currsb = new StringBuffer();
				while(currc>='0'&& currc<='9'){
					currsb.append(currc);
					i++;
					if(i>=len) break;
					currc = s.charAt(i);
				}
				System.out.println("数字："+currsb.toString());
				
				stacknum.add(Integer.valueOf(currsb.toString())); //数字入栈
				sb_midstr.append(" "+currsb.toString());
			}
		}
		while(!stackop.isEmpty()){
			sb_midstr.append(" "+stackop.pop());
			//stacknum.add(helper(stacknum.pop(),stacknum.pop(),stackop.pop()));
			
		}
		System.out.println(sb_midstr);
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
