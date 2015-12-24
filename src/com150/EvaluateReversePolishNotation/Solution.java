package com150.EvaluateReversePolishNotation;

import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] tokens = {"4", "13", "5", "/", "+"};
		System.out.println(evalRPN(tokens));

	}

	public static int evalRPN(String[] tokens) {
		
		Stack<Integer> numbers = new Stack<Integer>();
		int len = tokens.length;
		if(tokens==null||len==0) return 0;
		int n1;
		int n2;
		for(int i = 0 ; i < len ; i++){
			switch (tokens[i]){
			case "+":numbers.add(numbers.pop()+numbers.pop()); break;
			case "-":numbers.add(-(numbers.pop()-numbers.pop()));break;
			case "*":numbers.add(numbers.pop()*numbers.pop());break;
			case "/":n1 = numbers.pop();n2=numbers.pop();numbers.add(n2/n1);break;
			default: numbers.add(Integer.valueOf(tokens[i]));		
			}			
		}
		return numbers.peek();
	}

}
