package com023.MergekSortedLists;

public class Solution2 {

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
		
		
		
		ListNode[] lists =new ListNode[4];
		lists[0]=n11;
		lists[1]=null;
		lists[2]=n21;
		lists[3]=null;
		ListNode lmerge = mergeKLists(lists);

		while(lmerge!=null){
			System.out.println(lmerge.val);
			lmerge=lmerge.next;
		}
	}

	
	public static ListNode mergeKLists(ListNode[] lists) {
	    if(lists==null || lists.length==0)
	        return null;
	    return helper(lists,0,lists.length-1);
	}
	
	private static ListNode helper(ListNode[] lists, int l, int r){ //递归的进行归并
	    if(l<r){
	        int m = (l+r)/2;
	        return mergeTwoLists(helper(lists,l,m),helper(lists,m+1,r));
	    }
	    return lists[l];
	}
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode start1 = l1 ;
		ListNode start2 = l2 ;
		ListNode head = new ListNode(0);
		head.next = null;
		ListNode end = head;
		
		//尾插法
		while(start1!=null&&start2!=null){
			if(start1.val<start2.val){
				end.next = start1;
				end = end.next;
				start1 = start1.next;
			}else{
				end.next = start2;
				end = end.next;
				start2 = start2.next;
			}
			
		}
		if(start1!=null){
			end.next = start1;			
		}
		if(start2!=null){
			end.next = start2;
		}
		return head.next;
	}

}

