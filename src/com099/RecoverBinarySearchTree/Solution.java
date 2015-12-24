package com099.RecoverBinarySearchTree;

import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode root = new TreeNode(4);
		TreeNode l1 = new TreeNode(2);
		TreeNode r1 = new TreeNode(3);
		TreeNode r21 = new TreeNode(5);
		TreeNode r22 = new TreeNode(6);
		TreeNode r31 = new TreeNode(7);
		TreeNode r32 = new TreeNode(8);
		root.left = l1;
		root.right = r1;
		r1.left = r21;
		r1.right = r22;
		r21.left  =r31;
		r21.right = r32;
		recoverTree(root);
		
	}

	
	static TreeNode firstele = null;
	static TreeNode secondele = null;
	static TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);
	
	//采用先序遍历，找到第一个不符合顺序要求的
	public static void recoverTree(TreeNode root) {
		helper(root);
		int temp = firstele.val;
		firstele.val = secondele.val;
		secondele.val = temp;
	}
	
	//中序遍历的思想
	public static void helper(TreeNode root){
		if(root==null) return ;
		helper(root.left);
		
		//寻找第一个不符合顺序要求的
		if(firstele == null && prevElement.val >= root.val){
			firstele = prevElement;
		}		
		//寻找第二个不符合顺序要求的
		if(firstele != null && prevElement.val >= root.val){
			secondele = root;
		}
		prevElement = root;		
		helper(root.right);
	}
	
	
	
	
	
	//---复习-----------------中序遍历
	public static void inorder(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		TreeNode temp = root ; 
		
		while(temp!=null||!stack.isEmpty()){
			if(temp!=null){
				stack.push(temp);
				temp = temp.left;
			}else{
				temp = stack.pop();
				System.out.println(temp.val);
				temp = temp.right;
			}
		}
		
		
	}
	
	

}
