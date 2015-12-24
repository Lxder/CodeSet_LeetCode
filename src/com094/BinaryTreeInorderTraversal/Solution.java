package com094.BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if(root==null) return list;
		inorder(root,list);
		return list;
	}
	
	public static void inorder(TreeNode root, List<Integer> list){
		if(root!=null){
			inorder(root.left,list);
			list.add(root.val);
			inorder(root.right,list);
		}
	}
}
	