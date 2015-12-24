package com108.ConvertSortedArraytoBinarySearchTree;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {};
		TreeNode tree = sortedArrayToBST(nums);
		System.out.println(tree.val);
	}

	public static TreeNode sortedArrayToBST(int[] nums) {
		int end = nums.length-1;
		if(end==-1) return null;
		return buildTree(nums,0,end);
	}
	
	public static TreeNode buildTree(int[] nums, int start , int end){
		if(start<=end){
			int mid = (start+end)/2;
			TreeNode t = new TreeNode(nums[mid]);
			t.left = buildTree(nums,start,mid-1);
			t.right = buildTree(nums,mid+1,end);
			return t;
		}
		else return null;
	}

}
