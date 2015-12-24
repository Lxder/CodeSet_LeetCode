package com113.PathSumII;

import java.util.ArrayList;
import java.util.List;


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(4);
		TreeNode l1 = new TreeNode(2);
		TreeNode r1 = new TreeNode(1);
		TreeNode rl = new TreeNode(1);
		root.left = l1;
		root.right = r1;
		r1.left=rl;
		System.out.println(pathSum(root,6));

	}

	
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		
		List<List<Integer>> solu = new ArrayList<List<Integer>>();
		if(root ==null)return solu; 
		helper( root,  sum ,  solu ,new ArrayList<Integer>());
		return solu;
	}
	
	public static void helper(TreeNode root, int sum , List<List<Integer>> solu ,List<Integer> curr ){

		if(sum==root.val&&root.left==null&&root.right==null){
			curr.add(root.val);
			solu.add(curr);
		}
		else{ 
			if(root.left!=null){
				List<Integer> temp = new ArrayList<Integer>(curr);
				temp.add(root.val);
				helper(root.left,sum-root.val,solu,temp);
				
			}
			if(root.right!=null){
				List<Integer> temp = new ArrayList<Integer>(curr);
				temp.add(root.val);
				helper(root.right,sum-root.val,solu,temp);
			}
		}
	}

}
