package com225.ImplementStackusingQueues;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

}

//使用队列实现栈
//You must use only standard operations of a queue -- 
//which means only push to back, peek/pop from front, size, and is empty operations are valid.
class MyStack {
	
	Queue<Integer> queue = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        queue.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        int num = queue.size();
        for(int i = 0 ; i < num-1 ; i++){
        	queue.add(queue.poll());
        }
        queue.poll();
    }

    // Get the top element.
    public int top() {
    	int num = queue.size();
        for(int i = 0 ; i < num-1 ; i++)
        	queue.add(queue.poll());
        
        int solu = queue.poll();
        queue.add(solu);
        return solu;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}