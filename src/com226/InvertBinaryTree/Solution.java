package com226.InvertBinaryTree;

public class Solution {
	public static void main(String args[]){
		TreeNode root = new TreeNode(4);
		TreeNode l1 = new TreeNode(2);
		TreeNode r1 = new TreeNode(3);
		root.left = l1;
		root.right = r1;
		TreeNode solu =invertTree(root);
		System.out.println(solu.val);
		System.out.println(solu.left.val);
		System.out.println(solu.right.val);
	}
	
	public static TreeNode invertTree(TreeNode root) {
		if(root != null){
			invertTree(root.left);
			invertTree(root.right);
			TreeNode temp = root.left;
			root.left = root.right;
			root.right = temp;			
			return root;
		}
		return null;
		
	}
}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
