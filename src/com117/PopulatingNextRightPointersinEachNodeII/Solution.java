package com117.PopulatingNextRightPointersinEachNodeII;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//注意！！！！！！！！！！！不满足题目中常量空间的要求
public class Solution {
	
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
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		Queue<Integer> hqueue = new LinkedList<Integer>();
		int height = 1 ; 
		queue.add(root);
		hqueue.add(height);
		
		TreeLinkNode temp ;
		int htemp;
		while(!queue.isEmpty()){
			temp = queue.poll();
			htemp = hqueue.poll();
			if(hqueue.isEmpty()||htemp!=hqueue.peek())
				temp.next = null;
			else
				temp.next = queue.peek();
			if(temp.left!=null){
				queue.add(temp.left);
				hqueue.add(htemp+1);
			}
			if(temp.right!=null){
				queue.add(temp.right);
				hqueue.add(htemp+1);
			}
		}
	}
}

