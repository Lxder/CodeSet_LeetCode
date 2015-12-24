package com107.BinaryTreeLevelOrderTraversalII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(4);
		TreeNode l1 = new TreeNode(2);
		TreeNode r1 = new TreeNode(3);
		root.left = l1;
		root.right = r1;
		List<List<Integer>>  solu = levelOrder(root);
		System.out.println(solu);
		

	}

	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> solu = new ArrayList<List<Integer>>();
		if(root==null) return solu;
        Queue<TreeNode> queue = new LinkedList();
        Queue<Integer> hqueue = new LinkedList();
        int height = 1;
        queue.add(root);
        hqueue.add(1);
        
        List list = new ArrayList();
        while(!queue.isEmpty()){
        	TreeNode temp = queue.peek();
        	int h = hqueue.peek();
        	
        	
        	if(height == h){
        		list.add(temp.val);
        	}else{
        		solu.add(list);
        		list = new ArrayList();
        		height++;
        		continue;
        	}
        	
        	temp = queue.poll();
        	h = hqueue.poll();
        	
        	
        	//将左右子节点插入
        	if(temp.left!=null){
        		queue.add(temp.left);
        		hqueue.add(h+1);
        	}
        	if(temp.right!=null){
        		queue.add(temp.right);
        		hqueue.add(h+1);
        	}
        }
        solu.add(list);
        
        List<List<Integer>> solurev = new ArrayList<List<Integer>>();
        int len = solu.size();
        for(int i = len - 1 ; i >=0 ; i--){
        	solurev.add(solu.get(i));
        }
        return solurev;
        
    }
}
