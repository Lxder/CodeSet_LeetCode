package com129.SumRoottoLeafNumbers;

import java.util.ArrayList;
import java.util.List;


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode l1 = new TreeNode(2);
		TreeNode r1 = new TreeNode(3);
		root.left = l1;
		root.right = r1;
		System.out.println(sumNumbers(null));

	}

	public static int sumNumbers(TreeNode root) {
		if(root==null) return 0;
		List<Integer> list = new ArrayList<Integer>();
		dfs(root,0,list);
		System.out.println(list);
		int sum = 0;
		for(int i : list){
			sum+=i;
		}
		return sum;
	}
	
	public static void dfs(TreeNode root , int sum , List<Integer> list){
		if(root.left==null&&root.right==null){
			list.add(sum*10+root.val);
			return;
		}
		if(root.left!=null){
			dfs(root.left,sum*10+root.val,list);
		}
		if(root.right!=null){
			dfs(root.right,sum*10+root.val,list);
		}
	}

}
