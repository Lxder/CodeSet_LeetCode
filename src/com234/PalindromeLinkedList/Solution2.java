package com234.PalindromeLinkedList;




public class Solution2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n11 = new ListNode(1);
		ListNode n12 = new ListNode(1);
		ListNode n13 = new ListNode(2);
		ListNode n14 = new ListNode(1);
		ListNode n15 = new ListNode(1);
		n11.next = n12;
		n12.next = n13;
		n13.next = n14;
		n14.next = n15;
		n15.next = null;
		
		System.out.println(isPalindrome(n13));

	}

	public static boolean isPalindrome(ListNode head) {
		if(head ==null)
			return true;
		ListNode p = head;
		int len = 0 ;
		while(p!=null){
			len++;
			p=p.next;
		}		
		int loc = (len-1)/2;		
		p=head;
		while(loc !=0 ){
			p=p.next;
			loc--;
		}
		ListNode h = new ListNode(0); //后半部分的头

		ListNode q ;
		p=p.next;
		while(p!=null){ //先将后半部分逆置
			q = p.next;
			p.next = h.next;
			h.next = p ;
			p=q;
		}
			
		h = h.next;
		p=head;
		while(h!=null){
			if(h.val!=p.val)
				return false;
			h = h.next;
			p = p.next;
		}
		return true;
	}

}

