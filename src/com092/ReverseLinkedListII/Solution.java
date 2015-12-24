package com092.ReverseLinkedListII;

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
		n15.next = null;

		
		ListNode solu = reverseBetween(n15,1,1);
		while(solu!=null){
			System.out.println(solu.val);
			solu = solu.next;
		}
		
	}

	public  static ListNode reverseBetween(ListNode head, int m, int n) {
		if(m==n||head==null) return head;
		
		
		
		ListNode h = new ListNode(0);
		h.next = head; //ǿ�м�һ��ͷ�ڵ�
		ListNode pre = h; // ��ǰҪͷ��Ľڵ��ǰһ���ڵ�
		ListNode q = null;		
		
		while(m>1){ //�ҵ�Ҫ���õĲ��ֵ�ǰһ���ڵ㣬��Ϊͷ���ͷ��
			pre = pre.next;
			m--;
			n--;
		} 		
		
		ListNode p = pre.next; //pre��һ���ڵ�		
		ListNode end = p;		
		while(n>0){			
			q = p.next;
			p.next = pre.next;
			pre.next = p ;
			p = q;
			n--;
		}
		end.next = q; //�����м�ͺ���Ĳ���		
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
