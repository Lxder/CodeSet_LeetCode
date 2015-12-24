package com061.RotateList;



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
		ListNode solu = rotateRight(n13,2);
		while(solu!=null){
			System.out.println(solu.val);
			solu = solu.next;
		}
		
	}

	public static ListNode rotateRight(ListNode head, int k) {
		if(head==null||head.next==null)
			return head;
		
		int len = 0;
		ListNode p =head;
		ListNode end = head; //顺便找到链表尾部
		while(p!=null){ //计算链表长度
			len++;
			end = p;
			p=p.next;
		}
		k = k%len;
		if(k==0)
			return head;

		
		
		int remain = len - k;
		
		System.out.println("长度剩余"+remain);

		ListNode pre = head;
		p = head;
		while(remain != 0){
			pre = p ;
			p = p.next;
			remain --;
		}


		pre.next = null;
		end.next = head;

		head = p ;
		return head;
	}
}
