package com019.RemoveNthNodeFromEndofList;


public class Solution2 {
	public static void main(String args[]){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		ListNode l =removeNthFromEnd(n4,1);
		while(l!=null){
			System.out.print(l.val);
			l=l.next;
		}
	}
	//先将end指针向后移动n位，然后在将所有指针同时后移，直到end=null
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null||head==null)
        	return null;
    	ListNode pstart = head;
    	ListNode pre = head;
    	ListNode pend = head;
    	for(int i = 0; i < n ; i++){
        	pend = pend.next;
        }
    	while(pend!=null){
    		pre = pstart;
        	pstart= pstart.next;
        	pend = pend.next;
    	}
    	
        if(pstart.next ==null){
        	pre.next =null;
        	return head;
        }        			
        pstart.val=pstart.next.val;
        pstart.next = pstart.next.next;
        return head;
    }
}