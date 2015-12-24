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
		
		ListNode pre = h; //ָ���±��е�ǰԪ�ص�ǰһ��
		ListNode p = h.next; //ָ���±��еĵ�ǰԪ��
		
		ListNode q = head.next; //���ڶ���Ԫ�ص������뵽�Ѿ��ź����������
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
			
			q=qnext; //������һ��Ԫ��
			
		}
		
		return h.next;
	}

}
