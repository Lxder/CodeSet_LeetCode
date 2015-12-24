package com241.DifferentWaystoAddParentheses;

import java.util.ArrayList;
import java.util.List;

//错误的方法！！！！！！！！！！！！！！！！！！！！！！
//注意 这种方法不行 例如 (2*3)-(4*5)
// 先算(2*3) 和先算(4*5)两种情况不能分开

//注意  12*5 这种情况，第一个数字占用了两个字符,下面的程序默认是1个字符的

public class Solution {

	public static void main(String args[]){

		System.out.println(diffWaysToCompute("2*3-4*5"));
	}

	public static List<Integer> diffWaysToCompute(String input) {
		List<Integer> solu = new ArrayList<Integer>();
		
		List<String> list = new ArrayList<String>();

		int len = input.length();
		for(int i = 0 ; i < len ; i++){
			list.add(input.substring(i, i+1));
		}
		
		helper(solu,list);
		return solu;
	}
	
	public static void helper(List<Integer> solu,List<String> list){
		if(list.size()==1){
			solu.add(Integer.parseInt(list.get(0)));
			return;
		}
		int len = list.size();
		for(int i = 1 ; i < len ; i = i+2){
			int ele = operation(list.get(i-1),list.get(i+1),list.get(i));
			List<String> currlist = new ArrayList<String>();
			currlist.addAll(list);
			currlist.remove(i-1);
			currlist.remove(i-1);
			currlist.remove(i-1);
			currlist.add(i-1,String.valueOf(ele));
			helper(solu,currlist);
			System.out.println("=======");
		}		
	}
	
	public static int operation(String a , String b , String oper){
		System.out.println(a+" "+oper+" "+b);
		if(oper.equals("+"))
			return Integer.parseInt(a) + Integer.parseInt(b);
		else if(oper.equals("-"))
			return Integer.parseInt(a) - Integer.parseInt(b);
		else
			return Integer.parseInt(a) * Integer.parseInt(b);
		
		
		
		
	}

}
