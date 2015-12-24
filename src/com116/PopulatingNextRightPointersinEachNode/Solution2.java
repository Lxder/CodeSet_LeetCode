package com116.PopulatingNextRightPointersinEachNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Solution2 {
	
	public static void main(String args[]){
		TreeLinkNode root = new TreeLinkNode(0);
		TreeLinkNode l1 = new TreeLinkNode(1);
		TreeLinkNode r1 = new TreeLinkNode(2);
		TreeLinkNode l11 = new TreeLinkNode(3);
		TreeLinkNode l12 = new TreeLinkNode(4);
		TreeLinkNode r11 = new TreeLinkNode(5);
		TreeLinkNode r12 = new TreeLinkNode(6);
		
		root.left = l1;
		root.right = r1;
		l1.left = l11;
		l1.right = l12;
		r1.left = r11;
		r1.right = r12;
		
		connect(root);
		System.out.println(root.next);
		System.out.println(l1.next.val);
		System.out.println(r1.next);
		System.out.println(l11.next.val);
		System.out.println(l12.next.val);
		System.out.println(r11.next.val);
		System.out.println(r12.next);
	}
	public static void connect(TreeLinkNode root) {
		if(root==null) return;
		TreeLinkNode temp = root;
		TreeLinkNode curr ;
		while(temp.left!=null){
			curr = temp;
			while(curr!=null){
				curr.left.next = curr.right;
				if(curr.next!=null){
					curr.right.next = curr.next.left;
				}
				curr = curr.next;
			}
			temp = temp.left;
		
		}
	}
}

