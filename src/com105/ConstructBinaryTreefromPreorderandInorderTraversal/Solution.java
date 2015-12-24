package com105.ConstructBinaryTreefromPreorderandInorderTraversal;

public class Solution {

	public static void main(String args[]){
		int[] preorder = {1,2,4,5,7,3,6,8,9,10};
		int[] inorder = {4,2,7,5,1,8,6,9,10,3};
		
		TreeNode root = buildTree(preorder,inorder);
		
		inorder(root);
		//System.out.println(root.val);
		//System.out.println(root.left.val);
	}
	public static void inorder(TreeNode root){
		if(root==null) return;
		inorder(root.left);
		System.out.println(root.val);
		inorder(root.right);
	}
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		TreeNode root = helper(preorder,0,inorder.length-1 , inorder , 0 , inorder.length-1);
		return root;
		
	}
	
	public static TreeNode helper(int[] preorder, int pstart, int pend , 
			int[] inorder, int istart , int iend){
		if(pstart>pend||istart>iend) return null;
		TreeNode root = new TreeNode(preorder[pstart]); //新建根节点		
		
		int i = istart;
		while(i <= iend){ //在中序中寻找根节点
			if(inorder[i]==preorder[pstart]){
				break;
			}
			else
				i++;
		}
		
		System.out.println(root.val+"最终根："+i);
		
		int n_istart = istart , n_iend = i-1;
		int n_pstart = pstart+1 , n_pend = n_pstart+n_iend-n_istart;
		
//		System.out.println(n_istart+" "+n_iend+" "+n_pstart+" "+n_pend);
//		System.out.println((i+1)+" "+iend+" "+(n_pend+1)+" "+(pend-1));
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		root.left = helper(preorder , n_pstart ,n_pend,inorder,n_istart,n_iend);
		root.right = helper(preorder,n_pend+1,pend,inorder,i+1,iend);
		
		return root;
	}
}
