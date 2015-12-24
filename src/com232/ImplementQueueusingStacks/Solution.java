package com232.ImplementQueueusingStacks;

import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

//使用栈实现队列
//You must use only standard operations of a stack -- 
//which means only push to top, peek/pop from top, size, and is empty operations are valid.
class MyQueue {
    // Push element x to the back of queue.
	Stack<Integer> A = new Stack<Integer>();
	Stack<Integer> B = new Stack<Integer>();
	
	public void push(int x) {
		A.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(!B.isEmpty())
        	B.pop();
        else{
        	while(!A.isEmpty()){
        		B.push(A.pop());
        	}
        	B.pop();
        }
    }

    // Get the front element.
    public int peek() {
    	if(!B.isEmpty())
        	return B.peek();
        else{
        	while(!A.isEmpty()){
        		B.push(A.pop());
        	}
        	return B.peek();
        }
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return A.isEmpty()&&B.isEmpty();
    }
}