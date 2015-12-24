package com234.PalindromeLinkedList;

import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isPalindrome(ListNode head) {
		if(head ==null)
			return true;
		ListNode p = head;
		Stack<Integer> stack = new Stack();
		while(p!=null){
			stack.add(p.val);
			p=p.next;
		}
		int num = (stack.size()-1)/2;
		
		p = head;
		for(int i = 0 ; i <= num ; i++){
			if(stack.pop()!=p.val)
				return false;
			p=p.next;
		}
		return true;

	}

}

