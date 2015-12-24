package com257.BinaryTreePaths;

import java.util.ArrayList;
import java.util.List;



public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(4);
		TreeNode l1 = new TreeNode(2);
		TreeNode r1 = new TreeNode(5);
		TreeNode r2 = new TreeNode(6);
		root.left = l1;
		root.right = r1;
		r1.right = r2;
		List<String> solu = binaryTreePaths(r1);
		System.out.println(solu);
		
	}

	public static List<String> binaryTreePaths(TreeNode root) {
		List<String> solu = new ArrayList<String>();
		if(root==null) return solu;
		StringBuffer curr = new StringBuffer(String.valueOf(root.val)); //根节点加入
		helper(root,solu,curr);
		
		return solu;
	}
	
	
	public static void helper(TreeNode root, List<String> solu ,StringBuffer curr){
		if(root.left==null&&root.right==null){
			solu.add(curr.toString());
			return;
		}
		if(root.left!=null){
			StringBuffer newcurr = new StringBuffer(curr);
			newcurr.append("->"+String.valueOf(root.left.val));
			helper(root.left,solu,newcurr);
		}
		
		if(root.right!=null){
			StringBuffer newcurr = new StringBuffer(curr);
			newcurr.append("->"+String.valueOf(root.right.val));
			helper(root.right,solu,newcurr);
		}
	}

}
