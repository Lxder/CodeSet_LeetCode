package com230.KthSmallestElementinaBST;

import java.util.Stack;



public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(2);
		TreeNode l1 = new TreeNode(3);
		TreeNode r1 = new TreeNode(4);
		root.left = l1;
		root.right = r1;
		System.out.println("第K大的元素是："+kthSmallest(root,0));
	}

	//根据二叉搜索树的性质，采用中根遍历则的到的是递增序列。因此可以从小到大找到第K个元素
	public static int kthSmallest(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode temp = root ; 
				
		while(temp!=null||!stack.isEmpty()){
			if(temp!=null){	//左子树入栈
				stack.add(temp);
				temp = temp.left;
			}else{ 
				k--;
				if(k<=0){
					break;
				}
				temp = stack.pop();		
				temp = temp .right;
			}
		}

//		while(temp!=null||!stack.isEmpty()){
//			while(temp!=null){ 	//左子树入栈
//				stack.add(temp);
//				temp = temp.left;
//			}
//			temp = stack.pop();
//			System.out.println(temp.val);
//			temp = temp.right;
//		}
		
		return  stack.peek().val;
	}
	
	
	
}
