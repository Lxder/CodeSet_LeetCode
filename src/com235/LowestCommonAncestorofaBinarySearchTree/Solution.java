package com235.LowestCommonAncestorofaBinarySearchTree;

import java.util.ArrayList;
import java.util.List;


public class Solution {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		TreeNode l1 = new TreeNode(2);
		TreeNode r1 = new TreeNode(5);
		TreeNode r2 = new TreeNode(6);
		root.left = l1;
		root.right = r1;
		r1.right = r2;
		TreeNode t = lowestCommonAncestor(root,r1,r2);
		System.out.println(t.val);
		
	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		List<Integer> pathp = findPath(root,p);
		List<Integer> pathq = findPath(root,q);
		System.out.println(pathp);
		System.out.println(pathq);
		int len = Math.min(pathp.size(),pathq.size());
		int i = 0;
		for(i= 0 ; i < len ; i++){
			if(pathp.get(i)!=pathq.get(i))
				break;
		}
		int posi = pathp.get(i-1);

		TreeNode temp = root ; 
		while(temp.val!=posi){
			if(p.val<temp.val){
				temp = temp.left;
			}else{
				temp=temp.right;
			}
		}
		return temp;
		
	}
	
	public static List<Integer> findPath(TreeNode root , TreeNode p ){
		TreeNode temp = root ;
		List<Integer> list = new ArrayList<Integer>();
		while(temp!=p){
			if(p.val<temp.val){
				list.add(temp.val);
				temp = temp.left;
			}else{
				list.add(temp.val);
				temp=temp.right;
			}
		}
		list.add(temp.val);
		return list;
	}
}
