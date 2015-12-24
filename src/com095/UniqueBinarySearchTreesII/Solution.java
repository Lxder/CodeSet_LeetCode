package com095.UniqueBinarySearchTreesII;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<TreeNode> generateTrees(int n) {
		return generateTrees(1,n);
    }
	
	public List<TreeNode> generateTrees(int start,int end){             
	    List<TreeNode> trees = new ArrayList<TreeNode>();
	    if(start>end){  trees.add(null); return trees;}

	    for(int rootValue=start;rootValue<=end;rootValue++){
	        List<TreeNode> leftSubTrees=generateTrees(start,rootValue-1); //左子树
	        List<TreeNode> rightSubTrees=generateTrees(rootValue+1,end);  //右子树

	        for(TreeNode leftSubTree:leftSubTrees){  
	            for(TreeNode rightSubTree:rightSubTrees){ //对于每一个左子树和右子树，连接到根上
	                TreeNode root=new TreeNode(rootValue);
	                root.left=leftSubTree;
	                root.right=rightSubTree;
	                trees.add(root); //添加到集合中
	            }
	        }
	    }
	    return trees;
	}
	
}
