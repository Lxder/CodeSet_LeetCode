package com224.BasicCalculator;

import java.util.Stack;


public class Solution {

	public static void main(String[] args) {
		String s ="(1+(4+((5+2)))-3)+(6+8)";
		System.out.println(calculate(s));

	}

	
	//������Ҫ��������ʽת��Ϊ����Ȼ������ջ����	
	//��Ҫ����ջ���ֱ������ֺ������
	
	public static int calculate(String s) {
		int len = s.length();
		if (len==0) return 0;
		
		Stack<Integer> stacknum = new Stack<Integer>(); //����ջ
		Stack<Character> stackop = new Stack<Character>(); //�����ջ

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
				//��ʼ��ջ�����㣬ֱ������(Ϊֹ
				while(stackop.peek()!='(')
					stacknum.add(helper(stacknum.pop(),stacknum.pop(),stackop.pop()));
				stackop.pop(); //�������ų�ջ
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
				stacknum.add(Integer.valueOf(currsb.toString())); //������ջ
			}
		}

		//��ʣ���������
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