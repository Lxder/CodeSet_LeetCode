package com222.CountCompleteTreeNodes;

import java.util.Stack;



public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode l1 = new TreeNode(2);
		TreeNode r1 = new TreeNode(3);
		TreeNode l11 = new TreeNode(4);
		TreeNode l12 = new TreeNode(5);
		
				
		TreeNode r11 = new TreeNode(6);
		
		
		root.left = l1;
		root.right = r1;
		
		l1.left = l11 ;
		l1.right = l12;
		
		r1.left = r11;
		System.out.println(countNodes(root));
	}

	public static int countNodes(TreeNode root){
		if(root==null) return 0;
		int hl = getlefth(root);
		int hr = getrighth(root);
		if(hl==hr) 
			return (2<<(hl-1))-1;
		else 
			return countNodes(root.left)+countNodes(root.right)+1;
	}
	
	public static int getlefth(TreeNode root){
		int h = 0 ;
		TreeNode currnode =  root;
		
		while(currnode!=null){
			currnode= currnode.left;
			h++;
		}
		return h;
	}
	
	public static int getrighth(TreeNode root){
		int h = 0 ;
		TreeNode currnode =  root;
		
		while(currnode!=null){
			currnode= currnode.right;
			h++;
		}
		return h;
	}
	
	
	//---不可行，暴力搜索一遍 会超时
	public static int countNodes2(TreeNode root) {
		TreeNode currnode = root;
		int sumnum = 0;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		currnode = root;
		while(!stack.isEmpty()||currnode!=null){			
			if(currnode!=null){				
				sumnum++;
				stack.add(currnode);				
				currnode = currnode.left;
				
			}else{
				currnode = stack.pop();					
				currnode = currnode.right;

			}
		}

		return sumnum;
	}
	
	
}
