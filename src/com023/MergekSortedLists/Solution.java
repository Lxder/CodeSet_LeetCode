package com023.MergekSortedLists;



public class Solution {

	public static void main(String[] args) {
		ListNode n11 = new ListNode(1);
		ListNode n12 = new ListNode(3);
		ListNode n13 = new ListNode(5);
		ListNode n14 = new ListNode(7);
		ListNode n15 = new ListNode(7);
		n11.next = n12;
		n12.next = n13;
		n13.next = n14;
		n14.next = n15;
		n15.next = null;
		
		
		ListNode n21 = new ListNode(2);
		ListNode n22 = new ListNode(4);
		ListNode n23 = new ListNode(6);
		ListNode n24 = new ListNode(6);
		ListNode n25 = new ListNode(10);
		n21.next = n22;
		n22.next = n23;
		n23.next = n24;
		n24.next = n25;
		n25.next = null;
		
		ListNode[] lists =new ListNode[2];
		lists[0]=n11;
		lists[1]=n21;
		ListNode lmerge = mergeKLists(lists);

		while(lmerge!=null){
			System.out.println(lmerge.val);
			lmerge=lmerge.next;
		}
	}

	public static ListNode mergeKLists(ListNode[] lists) {
		int len = lists.length;
		ListNode[] startarr = new ListNode[len];
		for(int i = 0 ; i < len ; i++){
			startarr[i] = lists[i];

		}
		
		ListNode head = new ListNode(Integer.MIN_VALUE);
		head.next = null;
		ListNode p = head; //当前指针
		ListNode pre = head; // 前一个指针
		ListNode temp = null; 
		
		for(int i = 0 ; i < len ; i++){
			p=head;
			pre = head;
			while(startarr[i]!=null&&p!=null){
				if(startarr[i].val>p.val){
					pre = p;
					p = p.next;
				}else{ //将元素插入到前面的链表中
					temp = startarr[i].next;
					startarr[i].next= p;
					pre.next=startarr[i];
					startarr[i]=temp;
					p=pre.next;
					
				}
			}
			
			if(p==null){ //如果p已经到头了，将当前链表剩下的元素直接连在p后面
				pre.next = startarr[i];
			}
		}				
		return head.next;
	}

}


