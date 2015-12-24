package com098.ValidateBinarySearchTree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(4);
		TreeNode l1 = new TreeNode(2);
		TreeNode r1 = new TreeNode(3);
		TreeNode r21 = new TreeNode(4);
		TreeNode r22 = new TreeNode(1);
		TreeNode r31 = new TreeNode(1);
		TreeNode r32 = new TreeNode(7);
		root.left = l1;
		root.right = r1;
		r1.left = r21;
		r1.right = r22;
		r21.left  =r31;
		//r21.right = r32;
		System.out.println(isValidBST2(r21));

	}

	//中序遍历为递增顺序的一定为二叉搜索树
	public static boolean isValidBST3(TreeNode root) {
		if(root==null) return true;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<Integer> list = new LinkedList<Integer>();
		TreeNode curr = root;
		while(!stack.isEmpty() || curr!=null){
			if(curr!=null){
				stack.add(curr);
				curr = curr.left;
			}else{
				curr = stack.pop();
				list.add(curr.val);
				curr = curr.right;
			}
		}

		int len = list.size();
		int pre = list.get(0);
		int c ; 
		
		for(int i = 1 ; i < len ; i++){
			c = list.get(i);
			if(pre>=c) return false;
			pre  = c;
		}
		return true;
	}
	
	
	public static boolean isValidBST2(TreeNode root) {
		if(root==null) return true;
		List<Integer> list = new LinkedList<Integer>();
		helper(root,list);
		
		
		Iterator<Integer> itr = list.iterator();
		int pre = itr.next();
		int c;
		while(itr.hasNext()){
			c = itr.next();
			if(pre>=c) return false;
			pre = c;
		}
		return true;
		
	}
	
	public static void helper(TreeNode root, List list){
		if(root == null) return;
		helper(root.left,list);
		list.add(root.val);
		helper(root.right,list);
	}
	
	
	
	TreeNode pre = null;  
    public boolean isValidBST(TreeNode root) {  
    	if (root != null) {  
            if (!isValidBST(root.left)) return false;
            if (pre != null && root.val <= pre.val) return false;
            pre = root;  
            return isValidBST(root.right);  
        }  
        return true;  
     }  

}
