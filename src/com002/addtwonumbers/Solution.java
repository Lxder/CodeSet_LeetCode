package com002.addtwonumbers;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


//************************错误的**********************//
//************************错误的**********************//
//************************错误的**********************//
//************************错误的**********************//
//************************错误的**********************//
public class Solution {
	public static void main(String args[]){
		//2->8->8 + 3->7   ///882+73
		ListNode l11 = new ListNode(8); l11.next =null;
		ListNode l12 = new ListNode(8); l12.next=l11;
		ListNode l13 = new ListNode(2); l13.next = l12;
		
		ListNode l21 = new ListNode(1); l21.next =null;
		ListNode l22 = new ListNode(2); l22.next=l21;
		ListNode l23 = new ListNode(1); l23.next = l22;


		ListNode solu = addTwoNumbers(l13,l23);
		while(solu!=null){
			System.out.print(solu.val+",");
			solu=solu.next;
		}
		
	}
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		List<Integer> lsum = new LinkedList<Integer>(); 
		List<Integer> ltemp= new LinkedList<Integer>();
		ListNode solu = null;
		int sum=0;
		while(l1!=null&&l2!=null){
			sum = l1.val+l2.val;
			System.out.println("l1.val:"+l1.val+",l2.val:"+l2.val+",="+sum);
			lsum.add(sum%10);
			ltemp.add(sum/10);
			
			l1=l1.next;
			l2=l2.next;
			
			System.out.println("测试 sum"+sum%10);
			System.out.println("测试 sum"+sum/10);
		}		
		while(l1!=null){
			System.out.println("l1val是:"+l1.val);
			lsum.add(l1.val);
			ltemp.add(0);
			l1=l1.next;
		}

		while(l2!=null){
			System.out.println("l2val是:"+l2.val);
			lsum.add(l2.val);
			ltemp.add(0);
			l2=l2.next;
			
		}
		
//		Iterator<Integer> i1 = lsum.iterator();	
//		while(i1.hasNext()){
//			System.out.println("****"+i1.next());
//		}
//		Iterator i2 = ltemp.iterator();
//		while(i2.hasNext()){
//			System.out.println("===="+i2.next());
//		}
		
		
		Iterator<Integer> itrsum = lsum.iterator();
		Iterator<Integer> itrtemp = ltemp.iterator();		
		
		solu = new ListNode((int)itrsum.next()); 
		//System.out.println("当前值"+solu.val);		
		
		ListNode temp = solu;
		sum=0;
		if (itrsum.hasNext()){
			sum =(int)itrsum.next()+(int)itrtemp.next();

		}
		while(sum!=0|itrsum.hasNext()){
			System.out.println("sum"+sum);
			ListNode p = new ListNode(sum%10);
			temp.next=p;
			temp = p;
			
			if(itrsum.hasNext())
				sum = sum/10+(int)itrsum.next()+(int)itrtemp.next();
			else sum =sum/10;
			
		}
		int last = (int)itrtemp.next();
		if(last!=0){
			temp.next=new ListNode(last);
		}	

//		while(solu!=null){
//			System.out.print(solu.val);
//			solu=solu.next;
//		}
		
		
		return solu;
	}
}

