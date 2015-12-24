package com024.SwapNodesinPairs;




public class Solution {

	public static void main(String[] args) {
		ListNode n11 = new ListNode(1);
		ListNode n12 = new ListNode(3);
		ListNode n13 = new ListNode(5);
		ListNode n14 = new ListNode(7);
		ListNode n15 = new ListNode(9);
		n11.next = n12;
		n12.next = n13;
		n13.next = n14;
		n14.next = n15;
		n15.next = null;
		
		ListNode solu = swapPairs(n12);
		while(solu!=null){
			System.out.println(solu.val);
			solu=solu.next;
		}

	}
	
	public static ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null)
        	return head;
		
        ListNode pre = head;
        ListNode p = pre.next;
        int temp;
        while(p!=null){
			temp = pre.val;
			pre.val = p.val;
			p.val=temp;
			if(p.next==null)
				break;
			p = p.next.next;
			pre = pre.next.next;
		}
        return head;
    }

}
