package com021.MergeTwoSortedLists;



public class Solution {

	public static void main(String[] args) {
		ListNode n11 = new ListNode(1);
		ListNode n12 = new ListNode(3);
		ListNode n13 = new ListNode(5);
		ListNode n14 = new ListNode(5);
		ListNode n15 = new ListNode(5);
		n11.next = n12;
		n12.next = n13;
		n13.next = n14;
		n14.next = n15;
		n15.next = null;
		
		
		ListNode n21 = new ListNode(2);
		ListNode n22 = new ListNode(4);
		ListNode n23 = new ListNode(6);
		ListNode n24 = new ListNode(8);
		ListNode n25 = new ListNode(10);
		n21.next = n22;
		n22.next = n23;
		n23.next = n24;
		n24.next = n25;
		n25.next = null;
		
		ListNode lmerge = mergeTwoLists(n11,n21);
		while(lmerge!=null){
			System.out.println(lmerge.val);
			lmerge=lmerge.next;
		}
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode start1 = l1 ;
		ListNode start2 = l2 ;
		ListNode head = new ListNode(0);
		head.next = null;
		ListNode end = head;
		
		//β�巨
		while(start1!=null&&start2!=null){
			if(start1.val<start2.val){
				end.next = start1;
				end = end.next;
				start1 = start1.next;
			}else{
				end.next = start2;
				end = end.next;
				start2 = start2.next;
			}
			
		}
		if(start1!=null){
			end.next = start1;
			end = end.next;
			start1 = start1.next;
		}
		if(start2!=null){
			end.next = start2;
			end = end.next;
			start2 = start2.next;
		}
		return head.next;
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
