package com144.BinaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;



public class Solution2 {

	public static void main(String args[]){
		TreeNode root = new TreeNode(4);
		TreeNode l1 = new TreeNode(2);
		TreeNode r1 = new TreeNode(3);
		root.left = l1;
		root.right = r1;
		
		
		List<Integer> solu = preorderTraversal(root);
		System.out.println(solu);
	}
	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if(root==null)
			return list;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(root);
		
		while(!stack.isEmpty()){
			TreeNode temp = stack.pop();
			list.add(temp.val);
			if(temp.right!=null)
				stack.add(temp.right);
			if(temp.left!=null)
				stack.add(temp.left);
		}
		
		return list;

	}


}

