package com082.RemoveDuplicatesfromSortedListII;



public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n11 = new ListNode(1);
		ListNode n12 = new ListNode(1);
		ListNode n13 = new ListNode(1);
		ListNode n14 = new ListNode(2);
		ListNode n15 = new ListNode(2);
		n11.next = n12;
		n12.next = n13;
		n13.next = n14;
		n14.next = n15;
		n15.next = null;
		System.out.println(deleteDuplicates(n11));

	}

	public static ListNode deleteDuplicates(ListNode head) {
		if(head==null) return null;
		ListNode h = new ListNode(0); //新建一个头节点
		h.next = head;
		ListNode pre = h; 
		ListNode p = head;
		ListNode q = p.next;
		while(q!=null){
			if(p.val!=q.val){
				pre = p;
				p = q ;
				q=q.next;
			}
			else{
				while(q!=null && p.val == q.val){
					p = q;
					q = q.next;
				}
				pre.next = q;
				p = q ;
				if(q!=null)
					q = q.next;
			}
		}
		return h.next;
	}

}
