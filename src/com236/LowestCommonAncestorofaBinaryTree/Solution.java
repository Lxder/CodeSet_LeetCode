package com236.LowestCommonAncestorofaBinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		TreeNode l1 = new TreeNode(2);
		TreeNode l2 = new TreeNode(1);
		TreeNode r1 = new TreeNode(5);
		TreeNode r2 = new TreeNode(6);
		TreeNode r3 = new TreeNode(7);
		root.left = l1;
		l1.right = l2;
		root.right = r1;
		r1.right = r2;
		r1.left = r3;
		
//		//寻找路径
//		List<TreeNode> solu = findPath(root,r2);
//		System.out.println(solu);
		TreeNode solu = lowestCommonAncestor(root,r2,r3);
		System.out.println(solu.val);
		
	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null||root==p||root==q)
			return root;
		//寻找到达两个点的路径
		List<TreeNode> pathp = findPath(root,p); 
		List<TreeNode> pathq = findPath(root,q);
		
		int len = Math.min(pathp.size(),pathq.size());
		int i =0;
		for( ; i < len ; i++){
			System.out.println(pathp.get(i).val);
			if(pathp.get(i)!=pathq.get(i))
				break;
		}
		return pathp.get(i-1);
	}

	//寻找到达某个节点的路径 
	public static List<TreeNode> findPath(TreeNode root, TreeNode p) {
		List<TreeNode> ls = new ArrayList<TreeNode>();

		Stack<TreeNode> st = new Stack<TreeNode>();
		Stack<Boolean> flag = new Stack<Boolean>();
		st.push(root);
		flag.push(false);
		
		while (!st.isEmpty()) {			
			TreeNode temp = st.peek();
			ls.add(temp);
			if(temp==p){ //如果已经找到了这个点
				break;
			}			
			if(flag.pop()==true){
				st.pop();
				ls.remove(ls.size()-1); //因为又添加了一遍，所以要删除两遍
				ls.remove(ls.size()-1);
				continue;				
			}
			else flag.push(true);
			
			if (temp.right != null){
				st.push(temp.right);
				flag.push(false);
			}
			if (temp.left != null){
				st.push(temp.left);
				flag.push(false);
			}
		}		
		return ls;
	}
	
	

	// 先序遍历
	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> ls = new ArrayList<Integer>();
		if (root == null)
			return ls;
		Stack<TreeNode> st = new Stack<TreeNode>();	
		
		st.push(root);
		while (!st.isEmpty()) {
			TreeNode temp = st.pop();			
			ls.add(temp.val);
			if (temp.right != null){
				st.push(temp.right);
				
			}
			if (temp.left != null){
				st.push(temp.left);				
			}
			
		}
		return ls;
	}
	


}
