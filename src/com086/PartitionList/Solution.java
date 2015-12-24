package com086.PartitionList;



public class Solution {
	
	public static void main(String args[]){
		ListNode n11 = new ListNode(1);
		ListNode n12 = new ListNode(5);
		ListNode n13 = new ListNode(3);
		ListNode n14 = new ListNode(7);
		ListNode n15 = new ListNode(2);
		n11.next = n12;
		n12.next = n13;
		n13.next = n14;
		n14.next = n15;
		n15.next = null;
		
		
		
		ListNode p = partition(n11,4);
		while(p!=null){
			System.out.println(p.val);
			p=p.next;
		}
	}
	public  static ListNode partition(ListNode head, int x) {
		ListNode start1 = new ListNode(0); 	//前半部分
		ListNode start2 = new ListNode(0); 	//后半部分
		ListNode ps1 = start1;
		ListNode ps2 = start2;
		
		ListNode p = head ; //遍历每个节点的变量
		while(p!=null){
			if(p.val<x){
				ps1.next = p ;				
				ps1 = ps1.next;
			}else{
				ps2.next = p ; 
				ps2 = ps2.next;
			}
			p = p.next;
		}
		ps2.next = null;
		
		ps1.next = start2.next;
		return start1.next;
		
	}
}
