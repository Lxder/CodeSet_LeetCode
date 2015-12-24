package com236.LowestCommonAncestorofaBinaryTree;


public class Solution2 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		TreeNode l1 = new TreeNode(2);
		TreeNode l2 = new TreeNode(1);
		TreeNode r1 = new TreeNode(5);
		TreeNode r2 = new TreeNode(6);
		root.left = l1;
		l1.right = l2;
		root.right = r1;
		r1.right = r2;
		
//		//Ñ°ÕÒÂ·¾¶
//		List<TreeNode> solu = findPath(root,r2);
//		System.out.println(solu);
		TreeNode solu = lowestCommonAncestor(r1,r2,r1);
		System.out.println(solu.val);
		
	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null||root==p||root==q)
			return root;
		TreeNode left = lowestCommonAncestor(root.left,p,q);
		TreeNode right = lowestCommonAncestor(root.right,p,q);
		if(left != null && right != null) return root;
		return left!=null ? left : right;
	}
	


}
