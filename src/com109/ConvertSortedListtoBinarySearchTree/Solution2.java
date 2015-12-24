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
		}//�������slow������һ���ֵ�ͷ��
		
		
		if(temp!=null) //�������и��������
			temp.next = null;
		else head = null;
		
		TreeNode root = new TreeNode(slow.val);
		root.left = sortedListToBST(head);
		root.right = sortedListToBST(slow.next);
		return root;
		
	}


}
