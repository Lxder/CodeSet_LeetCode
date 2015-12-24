package com148.SortList;



public class Solution {
	public static void main(String args[]){

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
		ListNode solu = sortList(n14);
		while(solu!=null){
			System.out.println(solu.val);
			solu = solu.next;
		}

	}	
	
	
	//对链表进行排序，采用归并排序
	public static ListNode sortList(ListNode head) {
		if(head == null||head.next == null)
			return head;
		ListNode fast = head.next; //注意fast初始就要比slow快，因为后半部分是从slow.next开始的，而不是slow
		ListNode slow = head;
		while(fast!=null &&  fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		
		ListNode sh = sortList(slow.next);
		slow.next  = null;
		return merge(sortList(head),sh);

    }

	//将两部分合并
	public static ListNode merge(ListNode h1, ListNode h2) { //合并两个部分
		ListNode head = new ListNode(0);
		ListNode p = head;
		while(h1!=null&&h2!=null){
			if(h1.val<h2.val){
				p.next = h1;
				h1 = h1.next;
			}else{
				p.next = h2;
				h2 = h2.next;
			}
			p = p.next;
		}
		if(h1!=null){
			p.next = h1;
		}
		if(h2!=null){
			p.next = h2;
		}
		return head.next;
    }
	
}

/*
* public class ListNode {
*     int val;
*     ListNode next;
*     ListNode(int x) { val = x; }
* }
*/