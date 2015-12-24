package com206.ReverseLinkedList;




public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n11 = new ListNode(1);
		ListNode n12 = new ListNode(1);
		ListNode n13 = new ListNode(2);
		ListNode n14 = new ListNode(1);
		ListNode n15 = new ListNode(1);
		n11.next = n12;
		n12.next = n13;
		n13.next = n14;
		n14.next = n15;
		n15.next = null;
		
		System.out.println(reverseList(n13));
	}

	public static ListNode reverseList(ListNode head) {

		if(head==null||head.next==null)
			return head;
		ListNode h = new ListNode(0); //新建一个头
		ListNode p = head; //当前要头插的节点
		ListNode q ; 	//指向p的下一个节点

		while(p!=null){ //逆置
			q = p.next;
			p.next = h.next;
			h.next = p ;
			p=q;
		}
		
		return h.next;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
