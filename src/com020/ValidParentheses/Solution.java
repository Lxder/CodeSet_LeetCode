package com020.ValidParentheses;

import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		System.out.println(isValid("{}[]()"));
		System.out.println(isValid("}"));
		System.out.println(isValid("["));

	}

	public static boolean isValid(String s) {
		Stack pstack = new Stack();
		int len = s.length();
		char c ;
		for(int i = 0 ; i < len ; i++){
			c = s.charAt(i);
			System.out.print(c);
			if(c=='('||c=='['||c=='{')
				pstack.push(c);
			else{
				if(pstack.empty()){return false;} //如果读取到的不是三种左括号，但是栈已经空了,那么一定没办法匹配
				switch (c){
				case ')': { 
					if ((char)pstack.pop()!='(') return false;
					else break;
				}
				case ']': {
					if ((char)pstack.pop()!='[') return false;
					else break;
				}
				case '}': {
					if ((char)pstack.pop()!='{') return false;
					else break;
				}
				}

			}
		}
		if(pstack.empty())	return true;
		else return false;
	}
}
