package com114.FlattenBinaryTreetoLinkedList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class Solution2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode l1 = new TreeNode(2);
		TreeNode r1 = new TreeNode(5);
		TreeNode l11 = new TreeNode(3);
		TreeNode l12 = new TreeNode(4);
		TreeNode r12 = new TreeNode(6);
		root.left = l1;
		root.right = r1;
		l1.left =l11;
		l1.right = l12; 
		r1.right = r12;
		flatten(root);
		System.out.println(root.right.val);


	}

	public static void flatten(TreeNode root) {
		if(root==null) return;
		flatten(root.left); 	//展开左子树
		flatten(root.right);	//展开右子树
		
		//左右子树均展开后，将左子树连在右侧，将右子树连在左子树最后一个节点之后
		TreeNode temp = root.right;
		root.right = root.left;
		root.left = null;
		while(root.right!=null){
			root = root.right;
		}
		
		//将原先已经展开的右子树连接到后面
		root.right = temp;
	}


}
