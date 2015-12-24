package com019.RemoveNthNodeFromEndofList;



public class Solution {
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
	//先计算链表长度，然后将指针后移len-n
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null||head==null)
        	return null;
    	ListNode pstart = head;
        int len = 0;
        while(pstart!=null){
        	len++;
        	pstart = pstart.next;
        }
        System.out.println(len);
        int num = len - n;
        pstart = head;
        ListNode pre = head;
        System.out.println("向后移动的数量"+num);
        for(int i = 0; i < num ; i++){
        	pre = pstart;
        	pstart= pstart.next;
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