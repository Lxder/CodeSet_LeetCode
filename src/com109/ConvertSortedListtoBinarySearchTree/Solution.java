package com109.ConvertSortedListtoBinarySearchTree;

import java.util.ArrayList;


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
 
	public TreeNode sortedListToBST(ListNode head) {
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		
		ListNode p ;		

		for(p=head ; p!=null ; p = p.next){
			list.add(new TreeNode(p.val));
		}
		return buildTree(list,0,list.size()-1);
		
	}
	
	
	public static TreeNode buildTree(ArrayList<TreeNode> list, int start , int end){
		if(start<=end){
			int mid = (start+end)/2;
			TreeNode t = list.get(mid);
			t.left = buildTree(list,start,mid-1);
			t.right = buildTree(list,mid+1,end);
			return t;
		}
		else return null;
	}

}
