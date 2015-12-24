package com142.LinkedListCycleII;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n11 = new ListNode(1);
		ListNode n12 = new ListNode(2);
		ListNode n13 = new ListNode(3);
		ListNode n14 = new ListNode(4);
		ListNode n15 = new ListNode(5);
		n11.next = n12;
		n12.next = n13;
		n13.next = n14;
		n14.next = n15;
		n15.next = n11;
		System.out.println(detectCycle(n11).val);
	}

	public static ListNode detectCycle(ListNode head) {
		if (head == null)
			return null;
		ListNode p1 = head;
		ListNode p2 = head.next;
		while (p2 != null && p2.next != null) {
			if (p1 != p2) {
				p1 = p1.next;
				p2 = p2.next.next;
			}else{
				break;
			}
		}
		System.out.println(p1.val+" "+p2.val);
		if(p1==p2){
			p1=p1.next;
			ListNode start = head;
			while(start!=p1){
				System.out.println(start.val);
				start = start.next;
				p1 = p1.next;
			}
			return p1;
		}
		return null;
	}

//	public static ListNode detectCycle(ListNode head) {
//		if (head == null)
//			return null;
//		ListNode p1 = head;
//		ListNode p2 = head;
//		do{
//			if (p1 != p2) {
//				p1 = p1.next;
//				p2 = p2.next.next;
//			}else{
//				break;
//			}
//		} while(p2 != null && p2.next != null); 
//		System.out.println(p1.val+" "+p2.val); //首次相交的位置
//		if(p1==p2){
//			//p1=p1.next;
//			ListNode start = head;
//			while(start!=p1){
//				System.out.println(start.val);
//				start = start.next;
//				p1 = p1.next;
//			}
//			return p1;
//		}
//		return null;
//	}

}
