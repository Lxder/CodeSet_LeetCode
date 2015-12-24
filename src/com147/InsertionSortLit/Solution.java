package com147.InsertionSortLit;



public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n11 = new ListNode(9);
		ListNode n12 = new ListNode(7);
		ListNode n13 = new ListNode(6);
		ListNode n14 = new ListNode(7);
		ListNode n15 = new ListNode(3);
		n11.next = n12;
		n12.next = n13;
		n13.next = n14;
		n14.next = n15;
		n15.next = null;
		

		ListNode solu =	insertionSortList(n11);
		while(solu!=null){
			System.out.println(solu.val);
			solu = solu.next;
		}
	}

	public static ListNode insertionSortList(ListNode head) {
		if(head==null) return head;
		ListNode h = new ListNode(0);
		h.next = head;
		
		ListNode pre = h; //指向新表中当前元素的前一个
		ListNode p = h.next; //指向新表中的当前元素
		
		ListNode q = head.next; //将第二个元素到最后插入到已经排好序的链表中
		p.next = null;
		ListNode qnext ;
		while(q!=null){
			
			pre = h ; 
			p = h.next;
			while(p!=null&&p.val<q.val){
				pre = p ;
				p = p.next;
			}
			qnext = q.next;
			q.next = p;
			pre.next = q;
			
			q=qnext; //处理下一个元素
			
		}
		
		return h.next;
	}

}
