package com106.ConstructBinaryTreefromInorderandPostorderTraversal;

public class Solution {

	public static void main(String args[]){
		int[] inorder = {4,2,7,5,1,8,6,9,10,3};
		int[] postorder = {4,7,5,2,8,10,9,6,3,1};
		TreeNode root = buildTree(inorder,postorder);
		
		inorder(root);
		//System.out.println(root.val);
		//System.out.println(root.left.val);
	}
	public static void inorder(TreeNode root){
		if(root==null) return;
		
		System.out.println(root.val);
		inorder(root.left);
		inorder(root.right);
	}
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		TreeNode root = helper(inorder,0,inorder.length-1 , postorder , 0 , inorder.length-1);
		return root;
		
	}
	
	public static TreeNode helper(int[] inorder, int istart, int iend , 
			int[] postorder, int pstart , int pend){
		if(istart>iend||pstart>pend) return null;
		TreeNode root = new TreeNode(postorder[pend]); //新建根节点		
		
		int i = istart;
		while(i <= iend){ //在中序中寻找根节点
			if(inorder[i]==postorder[pend]){
				break;
			}
			else
				i++;
		}
		
		System.out.println(root.val+"最终根："+i);
		
		int n_istart = istart , n_iend = i-1;
		int n_pstart = pstart , n_pend = pstart+n_iend-n_istart;
		
//		System.out.println(n_istart+" "+n_iend+" "+n_pstart+" "+n_pend);
//		System.out.println((i+1)+" "+iend+" "+(n_pend+1)+" "+(pend-1));
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		root.left = helper(inorder,n_istart,n_iend,postorder , n_pstart ,n_pend);
		root.right = helper(inorder,i+1,iend,postorder,n_pend+1,pend-1);
		
		return root;
	}
}
