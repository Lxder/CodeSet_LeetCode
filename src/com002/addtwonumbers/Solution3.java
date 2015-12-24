package com002.addtwonumbers;


public class Solution3 {
	public static void main(String args[]){
		//2->8->8 + 3->7   ///882+73
		ListNode l11 = new ListNode(8); l11.next =null;
		ListNode l12 = new ListNode(8); l12.next=l11;
		ListNode l13 = new ListNode(2); l13.next = l12;
		
		ListNode l21 = new ListNode(1); l21.next =null;
		//ListNode l22 = new ListNode(2); l22.next=l21;
		//ListNode l23 = new ListNode(1); l23.next = l22;


		ListNode solu = addTwoNumbers(l13,l21);
		System.out.println();
		while(solu!=null){
			System.out.print(solu.val+",");
			solu=solu.next;
		}
		
	}
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode solu = new ListNode(0);
		ListNode temp = solu;

		int sum = 0;

		while(l1!=null&&l2!=null){
			sum  = sum + l1.val+l2.val;
			ListNode p = new ListNode(sum%10);
			temp.next=p;
			temp = p;			
			sum = sum/10;
			l1=l1.next;
			l2=l2.next;
		}
		while(l1!=null){
			sum  = sum + l1.val;
			ListNode p = new ListNode(sum%10);
			temp.next=p;
			temp = p;			
			sum = sum/10;	
			l1=l1.next;
		}
		while(l2!=null){
			sum  = sum + l2.val;
			ListNode p = new ListNode(sum%10);
			temp.next=p;
			temp = p;			
			sum = sum/10;	
			l2=l2.next;
		}
		if(sum !=0){
			ListNode p = new ListNode(sum);
			temp.next=p;
			temp = p;			
		}	
		return solu.next;
	}
}

