package com173.BinarySearchTreeIterator;

import java.util.Stack;



public class BSTIterator {

	public static void main(String args[]){
		TreeNode root = new TreeNode(4);
		TreeNode l1 = new TreeNode(2);
		TreeNode l22 = new TreeNode(3);
		TreeNode r1 = new TreeNode(6);
		TreeNode r21 = new TreeNode(5);
		TreeNode r22 = new TreeNode(7);
		TreeNode r32 = new TreeNode(8);
		
		root.left = l1;
		root.right = r1;
		
		l1.right = l22;
		r1.right=r22;
		r1.left = r21;
		r22.right = r32;
		
		BSTIterator itr = new BSTIterator(root);
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}
	
	Stack<TreeNode> stack = new Stack<TreeNode>();
	
	public BSTIterator(TreeNode root) {
		if(root!=null){
			
			stack.add(root);
			TreeNode currNode = root.left;
			while(currNode!=null){
				stack.add(currNode);
				currNode = currNode.left;
			}
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		if(!stack.isEmpty())
			return true;
		return false;
		
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode topNode = stack.pop();
		if(topNode.right!=null){
			stack.add(topNode.right);			
			TreeNode curr = topNode.right.left;
			while(curr!=null){
				stack.add(curr);
				curr = curr.left;				
			}
		}		
		return topNode.val;
	}
}
