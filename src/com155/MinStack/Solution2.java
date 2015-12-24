package com155.MinStack;

import java.util.Stack;

public class Solution2 {
	public static void main(String args[]) {
		MinStack2 s2 = new MinStack2();
		s2.push(6);System.out.print(s2.getMin()+" "); System.out.println(s2.top());
		s2.push(2);System.out.print(s2.getMin()+" ");System.out.println(s2.top());
		s2.push(3);System.out.print(s2.getMin()+" ");System.out.println(s2.top());
		s2.push(-2);System.out.print(s2.getMin()+" ");System.out.println(s2.top());
		s2.push(1);System.out.print(s2.getMin()+" ");System.out.println(s2.top());
		s2.push(5);System.out.print(s2.getMin()+" ");System.out.println(s2.top());
		
		System.out.println("===========");System.out.println(s2.top());
		s2.pop();System.out.print(s2.getMin()); System.out.println(s2.top());
		s2.pop();System.out.print(s2.getMin());System.out.println(s2.top());
		s2.pop();System.out.print(s2.getMin());System.out.println(s2.top());
		s2.pop();System.out.print(s2.getMin());System.out.println(s2.top()); 
		s2.pop();System.out.print(s2.getMin());System.out.println(s2.top());
	}
}

class MinStack2 {
	Stack<Integer> stack = new Stack<Integer>();
	int min;

	public void push(int x) {
		if (stack.empty()) {
			stack.add(x);
			min = x;
		} else {
			if (x < min) {
				stack.add(x - min);
				min = x;
			} else {
				stack.add(x);
			}
		}
	}

	public void pop() {
		if (stack.peek() < min) {
			min = min - stack.peek();
		}
		stack.pop();
	}

	public int top() {
		int temp;
		if (stack.peek() < min) {
			temp = min;
		} else
			temp = stack.peek();
		return temp;
	}

	public int getMin() {
		return min;
	}
}
