package com144.BinaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.List;



public class Solution {

	public static void main(String args[]){
		TreeNode root = new TreeNode(4);
		TreeNode l1 = new TreeNode(2);
		TreeNode r1 = new TreeNode(3);
		root.left = l1;
		root.right = r1;
		
		
		List<Integer> solu = preorderTraversal(root);
		System.out.println(solu);
	}
	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		preorder(list, root);
		return list;

	}

	public static void preorder(List<Integer> list, TreeNode root) {
		if (root != null) {
			list.add(root.val);
			preorder(list, root.left);
			preorder(list, root.right);
		}
	}
}
