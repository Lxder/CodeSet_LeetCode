package com104.MaximumDepthofBinaryTree;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxDepth(TreeNode root) {
		
		if(root==null) return 0;
		int lheight = 1+maxDepth(root.left);
		int rheight = 1+maxDepth(root.right);
		return Math.max(lheight, rheight);
	}

}
