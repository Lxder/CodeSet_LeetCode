package com002.addtwonumbers;

public class SolutionS2 {

	public static void main(String[] args) {
		// 2->8->8 + 3->7 ///882+73
		ListNode l11 = new ListNode(8);
		l11.next = null;
		ListNode l12 = new ListNode(8);
		l12.next = l11;
		ListNode l13 = new ListNode(9);
		l13.next = l12;

		ListNode l21 = new ListNode(1);
		l21.next = null;
		// ListNode l22 = new ListNode(2); l22.next=l21;
		// ListNode l23 = new ListNode(1); l23.next = l22;

		ListNode solu = addTwoNumbers(l13, l21);
		System.out.println();
		while (solu != null) {
			System.out.print(solu.val + ",");
			solu = solu.next;
		}

	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode p1 = l1;
		ListNode p2 = l2;
		int temp = 0;
		ListNode head = new ListNode(0);
		ListNode p = head;
		while (p1 != null && p2 != null) {
			int cur = p1.val + p2.val + temp;
			ListNode tempNode = new ListNode(cur % 10);
			p.next = tempNode;
			temp = cur / 10;
			
			p1 = p1.next;
			p2 = p2.next;
			p = p.next;
		}
		while (p1 != null) {
			int cur = p1.val + temp;
			ListNode tempNode = new ListNode(cur % 10);
			p.next = tempNode;
			temp = cur / 10;
			
			p1=p1.next;
			p = p.next;
		}
		while (p2 != null) {
			int cur = p2.val + temp;
			ListNode tempNode = new ListNode(cur % 10);
			p.next = tempNode;
			temp = cur / 10;
			
			p2=p2.next;
			p = p.next;
		}
		if (temp != 0) {
			ListNode tempNode = new ListNode(temp);
			p.next = tempNode;
		}

		return head.next;

	}

}
