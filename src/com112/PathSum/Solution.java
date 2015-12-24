package com112.PathSum;


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(4);
		TreeNode l1 = new TreeNode(2);
		TreeNode r1 = new TreeNode(3);
		TreeNode rl = new TreeNode(6);
		root.left = l1;
		root.right = r1;
		r1.left=rl;
		System.out.println(hasPathSum(root,7));

	}

	public static boolean hasPathSum(TreeNode root, int sum) {
		if(root ==null )return false;
		
		if(sum==root.val&&root.left==null&&root.right==null)
			return true;
		
		boolean sl = false, sr = false ;
		if(root.left!=null)
			sl = hasPathSum(root.left,sum-root.val);
		if(root.right!=null)
			sr = hasPathSum(root.right,sum-root.val);
		return sl||sr;
		
	}

}
