package com111.MinimumDepthofBinaryTree;



public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(4);
		TreeNode l1 = new TreeNode(2);
		TreeNode r1 = new TreeNode(3);
		root.left = l1;
		root.right = r1;
		System.out.println(minDepth(l1));
	}

	public static int minDepth(TreeNode root) {
		if(root==null) return 0;
		else return findMinDepth(root);
	}
	public static int findMinDepth(TreeNode root){
		if(root.left==null&&root.right==null)
			return 1;
		else {
			int lheight = Integer.MAX_VALUE;
			int rheight = Integer.MAX_VALUE;
			if(root.right!=null)
				rheight = 1 + minDepth(root.right);
			if(root.left!= null)
				lheight = 1 + minDepth(root.left); 
			return Math.min(lheight, rheight);
		}
	}

}
