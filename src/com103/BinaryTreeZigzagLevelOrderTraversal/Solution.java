package com103.BinaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


//采用双队列
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(4);
		TreeNode l1 = new TreeNode(2);
		TreeNode r1 = new TreeNode(3);
		TreeNode r21 = new TreeNode(5);
		TreeNode r22 = new TreeNode(6);
		TreeNode r31 = new TreeNode(7);
		TreeNode r32 = new TreeNode(8);
		root.left = l1;
		root.right = r1;
		r1.left = r21;
		r1.right = r22;
		r21.left  =r31;
		r21.right = r32;
		
		List<List<Integer>>  solu = zigzagLevelOrder(root);
		System.out.println(solu);

	}

	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> solu = new ArrayList<List<Integer>>();
		if(root==null) return solu;
		
		Queue<TreeNode> elemq = new LinkedList<TreeNode>();
		Queue<Integer> highq = new LinkedList<Integer>();
		TreeNode currNode ;
		int currh = 1;
		int preh =1;
		
		int h = 1;
		elemq.add(root);
		highq.add(h);
		
		List<Integer> list = new ArrayList<Integer>();
		
		while(!elemq.isEmpty()){
			currNode = elemq.poll();
			currh = highq.poll();
			
			if(currh==preh){
				list.add(currNode.val);
			}else{
				
				if(currh%2==1){
					Collections.reverse(list);
					System.out.println(list);
				}
				solu.add(new ArrayList(list));
				list = new ArrayList<Integer>();
				list.add(currNode.val);
				preh = currh;
			}
			
			if(currNode.left!=null){
				elemq.add(currNode.left);
				highq.add(currh+1);
			}
			if(currNode.right!=null){
				elemq.add(currNode.right);
				highq.add(currh+1);
			}
		}
		if(currh%2==0){
			Collections.reverse(list);
		}
		
		solu.add(list);
		return solu;
		
	}

}
