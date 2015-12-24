package com071.SimplifyPath;

import java.util.Stack;

public class Solution {

	public static void main(String args[]){
		Solution so = new Solution();
		String str = "/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///";
		String solu = so.simplifyPath(str);
		System.out.println(solu);
	}
	
	public String simplifyPath(String path) {
		
		Stack<String> stack = new Stack<String>();
		String[] arrs = path.split("/+|\\s+");
		
		int len = arrs.length;
		System.out.println("³¤¶È£º"+len);
		if(len==0) return "/";
		for(int i = 1 ; i< len  ; i++){
			System.out.println(i+":"+arrs[i]);
			if(arrs[i].equals("."))
				continue;
			if(arrs[i].equals("..")){
				if(stack.isEmpty()) continue;
				stack.pop();
			}
			else
				stack.push(arrs[i]);
		}
		
		if(stack.isEmpty()) return "/";
		
		StringBuffer sb = new StringBuffer();

		while(!stack.isEmpty()){				
			sb.insert(0, "/"+stack.pop());
		}
		return sb.toString();
	}

}
