package com155.MinStack;

import java.util.Stack;

public class Solution {

}

class MinStack {
	Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minele = new Stack<Integer>();
	public void push(int x) {
        stack.push(x);
        if(minele.isEmpty()){
        	minele.add(x);
        }
        else if(minele.peek()<x)
        	minele.add(minele.peek());
        else minele.add(x);
    }

    public void pop() {
        stack.pop();
        minele.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minele.peek();
    }
}
