package com124.BinaryTreeMaximumPathSum;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solu = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		helper(root);
		return solu;
	}
	
	
	//µÝ¹éº¯Êý
	public int helper(TreeNode root){
		if(root==null) return 0;
		int ls = helper(root.left);
		int rs = helper(root.right);
		if(ls<0) ls = 0;
		if(rs<0) rs = 0;
		int curr = ls+rs+root.val;
		if(curr>solu) solu = curr;
		return root.val+Math.max(ls, rs);
	}
}
