package com199.BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(4);
		TreeNode l1 = new TreeNode(2);
		TreeNode r1 = new TreeNode(5);
		TreeNode r2 = new TreeNode(6);
		root.left = l1;
		root.right = r1;
		r1.left = r2;
		System.out.println(rightSideView(root));

	}

	//输出每一层最右侧的那一个
	public static List<Integer> rightSideView(TreeNode root) {
		List<Integer> solu = new ArrayList<Integer>();
		if(root==null) return solu;
		Queue<TreeNode> bfs = new LinkedList<TreeNode>();
		Queue<Integer> high = new LinkedList<Integer>();
		
		bfs.add(root);
		high.add(1);
		TreeNode top = null ;
		Integer h ;
		while(!bfs.isEmpty()){
			top = bfs.poll();
			h = high.poll();
			
			if(top.left!=null){
				bfs.add(top.left);
				high.add(h+1);
			}
			if(top.right!=null){
				bfs.add(top.right);
				high.add(h+1);
			}		
			if((!high.isEmpty())&&high.peek()>h) //如果下一个节点的高度大于最后一个出队的节点高度，说明最后一个出队的在最右侧
				solu.add(top.val);			
		}
		solu.add(top.val); //添加最后一个节点		
		return solu;
		
	}

}
