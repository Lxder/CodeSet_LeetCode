package com083.RemoveDuplicatesfromSortedList;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode deleteDuplicates(ListNode head) {
		if(head==null)
			return null;
		ListNode pre = head;
		ListNode p = pre.next;
		while(p!=null){
			if(pre.val==p.val){
				pre.next = p.next;				
			}else{
				pre = pre.next;
			}
			p = p.next;
		}
		
		return head;
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
