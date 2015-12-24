package com235.LowestCommonAncestorofaBinarySearchTree;

public class Solution2 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		TreeNode l1 = new TreeNode(2);
		TreeNode r1 = new TreeNode(5);
		TreeNode r2 = new TreeNode(6);
		root.left = l1;
		root.right = r1;
		r1.right = r2;
		TreeNode t = lowestCommonAncestor(root,r1,r2);
		System.out.println(t.val);
		
	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		//if(root==null||p==null||q==null) return null;
		if(p.val<root.val&&q.val<root.val){
			return lowestCommonAncestor(root.left,p,q);
		}else if(p.val>root.val&&q.val>root.val){
			return lowestCommonAncestor(root.right,p,q);
		}else return root;

		
	}
	
	
}
