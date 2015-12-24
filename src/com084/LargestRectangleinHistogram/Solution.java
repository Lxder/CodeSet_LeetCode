package com084.LargestRectangleinHistogram;

import java.util.Stack;

public class Solution {

	public int largestRectangleArea(int[] height) {
		int solu = 0 ;
		int len = height.length ;
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0 ; i < len ; i++){
			if(stack.isEmpty() || stack.peek()<height[i]){
				stack.push(height[i]);
			}else{ //将所有比height[i]大的的都出栈，用height[i]代替
				int count = 0; //记录出栈次数
				while((!stack.isEmpty()) && stack.peek()>height[i]){
					count++;
					solu = Math.max(solu, count*stack.pop());
				}
				
				while(count!=0){
					count--;
					stack.push(height[i]); //用height[i]代替出栈的元素
				}
				stack.push(height[i]);//将当前的元素添加进去
			}
		}
		
		//处理最后一个元素
		int count = 0;
		while(!stack.isEmpty()){
			count++;
			solu = Math.max(solu,count*stack.pop());
		}
		
		return solu;
		
		
	}
}
