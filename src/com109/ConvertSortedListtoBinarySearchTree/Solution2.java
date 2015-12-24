package com109.ConvertSortedListtoBinarySearchTree;



public class Solution2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode sortedListToBST(ListNode head) {
		if(head==null) return null;
		ListNode fast = head ;
		ListNode slow = head ; 
		ListNode temp = null;
		while(fast.next!=null && fast.next.next!=null){
			fast = fast.next.next;
			temp = slow;
			slow = slow.next;
		}//遍历完后slow就是下一部分的头部
		
		
		if(temp!=null) //将链表切割成两部分
			temp.next = null;
		else head = null;
		
		TreeNode root = new TreeNode(slow.val);
		root.left = sortedListToBST(head);
		root.right = sortedListToBST(slow.next);
		return root;
		
	}


}
