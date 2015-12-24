package com002.addtwonumbers;

import java.util.LinkedList;
import java.util.List;

public class Solution2 {
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
		List<Integer> list1 = new LinkedList<Integer>(); 
		List<Integer> list2= new LinkedList<Integer>();
		ListNode solu = null;
		while(l1!=null){
			list1.add(l1.val);
			l1=l1.next;
		}
		while(l2!=null){
			list2.add(l2.val);
			l2=l2.next;
		}
		
		Integer[] arr1 = (Integer[])list1.toArray(new Integer[list1.size()]);
		Integer[] arr2 = (Integer[])list2.toArray(new Integer[list2.size()]);

		solu = new ListNode(0);
		ListNode temp = solu;
		
		int len = Math.min(arr1.length, arr2.length);
		int sum = 0;
		int i ;
		for(i = 0 ; i <len ; i++){
			sum  = sum + arr1[i]+arr2[i];
			ListNode p = new ListNode(sum%10);
			temp.next=p;
			temp = p;			
			sum = sum/10;			
		}
		while(i<arr1.length){
			sum  = sum + arr1[i];
			ListNode p = new ListNode(sum%10);
			temp.next=p;
			temp = p;			
			sum = sum/10;	
			i++;
		}
		while(i<arr2.length){
			sum  = sum + arr2[i];
			ListNode p = new ListNode(sum%10);
			temp.next=p;
			temp = p;			
			sum = sum/10;	
			i++;
		}
		if(sum !=0){
			ListNode p = new ListNode(sum);
			temp.next=p;
			temp = p;			
		}	
		return solu.next;
	}
}

