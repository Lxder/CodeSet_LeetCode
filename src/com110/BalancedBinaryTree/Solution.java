package com110.BalancedBinaryTree;


public class Solution {

	public boolean isBalanced(TreeNode root) {
		if(root == null) return true;
		int solu = getDepth(root);
		if(solu==-1) 
			return false;
		return true;		
	}

	public int getDepth(TreeNode root) {
		if (root == null)
			return 0;
		int lheight = getDepth(root.left);
		int rheight = getDepth(root.right);
		
		//如果左子树或右子树不平衡，或者本身不平衡，返回-1；
		if(lheight==-1||rheight==-1||Math.abs(lheight-rheight)>1) 
			return -1;
		return 1+Math.max(lheight, rheight);
	}
}
