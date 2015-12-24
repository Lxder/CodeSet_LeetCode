package com100.SameTree;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		
		if(p==null&&q==null) return true;
		if(p!=null&&q!=null){
			if(p.val==q.val){
				boolean lsolu = isSameTree(p.left,q.left);
				boolean rsolu = isSameTree(p.right,q.right);
				return lsolu&&rsolu;				
			}
			else return false;
		}		
		
		return false;
	}

}
