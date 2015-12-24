package com145.BinaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;



public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode l1 = new TreeNode(2);
		TreeNode r1 = new TreeNode(3);
		root.left = l1;
		root.right = r1;
		System.out.println(postorderTraversal2(root));

	}
	
	public static List<Integer> postorderTraversal2(TreeNode root) {
	    ArrayList<Integer> solu = new ArrayList<Integer>();
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    TreeNode curr = root; //指向当前要访问的节点
	    TreeNode pre = null; //指向前一个被访问的节点
	    while(curr!=null||!stack.isEmpty()){
	        while(curr!=null){
	            stack.push(curr);
	            curr = curr.left;
	        }
	        curr = stack.peek();
	        //如果当前节点的右节点已被访问或者为空，则访问该节点
	        if(curr.right==null || curr.right==pre){
	            solu.add(curr.val);
	            pre = curr;
	            stack.pop();
	            curr = null;
	        }else{ //否则，访问该节点的右孩子
	            curr = curr.right;
	        }
	    }
	    return solu;        
	}

	public static List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		postorder(root,list);
		return list;
	}
	
	public static void postorder(TreeNode root, List<Integer> list){
		if(root!=null){
			postorder(root.left,list);
			postorder(root.right,list);
			list.add(root.val);
		}
	} 

}
