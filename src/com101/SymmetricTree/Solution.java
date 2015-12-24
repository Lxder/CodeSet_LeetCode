package com101.SymmetricTree;


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(4);
		TreeNode l1 = new TreeNode(2);
		TreeNode r1 = new TreeNode(2);
		root.left = l1;
		root.right = r1;
		System.out.println(isSymmetric(root));
	}

	public static boolean isSymmetric(TreeNode root) {
		if(root==null) return true;
		return isSame(root.left , root.right);
			
		
	}
	
	public static boolean isSame(TreeNode p , TreeNode q){
		if(p==null&&q==null) return true;
		if(p==null||q==null) return false;
		else{
			if(p.val==q.val){
				boolean same1 = isSame(p.left , q.right);
				boolean same2 = isSame(p.right , q.left);
				return same1&&same2;
			}
			return false;
		}
	}
	
	
	
	//另一种方法：将整个树左右互换，然后比较互换后的树和原来的树是不是一样

}
