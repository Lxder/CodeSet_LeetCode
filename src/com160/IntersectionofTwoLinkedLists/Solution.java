package com160.IntersectionofTwoLinkedLists;


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
		
		
		ListNode n21 = new ListNode(2);
		ListNode n22 = new ListNode(4);
		ListNode n23 = new ListNode(6);
		ListNode n24 = new ListNode(6);
		ListNode n25 = new ListNode(10);
		n21.next = n22;
		n22.next = n23;
		n23.next = n24;
		n24.next = n25;
		n25.next = null;
		System.out.println(getIntersectionNode(n11,n15));

	}

	public  static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA==null||headB==null) return null;
		
		ListNode pa = headA;
		ListNode pb = headB;
		int lena = 0;
		int lenb = 0;
		while(pa!=null) { pa = pa.next ; lena++;}
		while(pb!=null) { pb = pb.next ; lenb++;}
		pa = headA;
		pb = headB;
		if(lena<lenb){ //始终保持pa指向长的那一个
			int templen = lena ;lena = lenb ; lenb = templen;
			ListNode tempp = pa ; pa = pb ; pb = tempp;
		}
		int diff = lena - lenb;

		while(diff!=0) { pa = pa.next; diff--;}
		while(pa!=null){
			if(pa==pb) return pa;
			else { pa=pa.next ; pb=pb.next ;}
		}
		return null;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}
