package com141.LinkedListCycle;


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n11 = new ListNode(1);
		ListNode n12 = new ListNode(3);
		ListNode n13 = new ListNode(5);
		ListNode n14 = new ListNode(7);
		ListNode n15 = new ListNode(7);
		n11.next = n12;
		n12.next = n13;
		n13.next = n14;
		n14.next = n15;
		n15.next = null;
		System.out.println(hasCycle(n11));
	}

	public static boolean hasCycle(ListNode head) {
		if(head==null) return false;
		ListNode p1 = head;
		ListNode p2 = head.next;
		while(p2!=null&&p2.next!=null){ //不需要判断p1，因为p2比p1快
			if(p1!=p2){
				p1 = p1.next;
				p2 = p2.next.next;
			}else
				return true;
		}
		return false;
	}

}
