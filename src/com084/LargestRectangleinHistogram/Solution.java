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
			}else{ //�����б�height[i]��ĵĶ���ջ����height[i]����
				int count = 0; //��¼��ջ����
				while((!stack.isEmpty()) && stack.peek()>height[i]){
					count++;
					solu = Math.max(solu, count*stack.pop());
				}
				
				while(count!=0){
					count--;
					stack.push(height[i]); //��height[i]�����ջ��Ԫ��
				}
				stack.push(height[i]);//����ǰ��Ԫ����ӽ�ȥ
			}
		}
		
		//�������һ��Ԫ��
		int count = 0;
		while(!stack.isEmpty()){
			count++;
			solu = Math.max(solu,count*stack.pop());
		}
		
		return solu;
		
		
	}
}
