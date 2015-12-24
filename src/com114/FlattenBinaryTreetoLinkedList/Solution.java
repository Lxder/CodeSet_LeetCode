package com114.FlattenBinaryTreetoLinkedList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode l1 = new TreeNode(2);
		TreeNode r1 = new TreeNode(5);
		TreeNode l11 = new TreeNode(3);
		TreeNode l12 = new TreeNode(4);
		TreeNode r12 = new TreeNode(6);
		root.left = l1;
		root.right = r1;
		l1.left =l11;
		l1.right = l12; 
		r1.right = r12;
		flatten(r12);
		System.out.println(root.right.val);


	}

	public static void flatten(TreeNode root) {
		if(root==null) return;
		List<TreeNode> list = new ArrayList<TreeNode>();
		dfs(root,list);
		int len = list.size();
		for(int i = 0 ; i < len-1 ; i++){
			list.get(i).left = null;
			list.get(i).right = list.get(i+1);
		}
		root = list.get(0);
	}
	public static void dfs(TreeNode root,List<TreeNode> list){
		if(root!=null){
			//System.out.println(root.val);
			list.add(root);
			dfs(root.left,list);
			dfs(root.right,list);
			
		}
	}
	
//	public static void dfs2(TreeNode root){
//
//			System.out.println(root.val);
//			if(root.left!=null)
//				dfs(root.left);
//			if(root.right!=null)
//				dfs(root.right);
//
//	}

}
