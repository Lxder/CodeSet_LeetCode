package com203.RemoveLinkedListElements;




public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ListNode n11 = new ListNode(1);
		ListNode n12 = new ListNode(1);
		ListNode n13 = new ListNode(2);
		ListNode n14 = new ListNode(2);
		ListNode n15 = new ListNode(1);
		n11.next = n12;
		n12.next = n13;
		n13.next = n14;
		n14.next = n15;
		n15.next = null;
		
		ListNode list = removeElements(n11,1);
		while(list!=null){
			System.out.println(list.val);
			list=list.next;
		}

	}

	public static ListNode removeElements(ListNode head, int val) {
        if(head==null) return null;
        while(head!=null&&head.val==val)
        	head=head.next;
        ListNode p = head;

        while(p!=null&&p.next!=null){
        	if(p.next.val==val)
        		p.next =p.next.next;
        	else
        		p=p.next;
        }
        return head;
    }
}
