package com117.PopulatingNextRightPointersinEachNodeII;

////////不正确，运行到最后的时候无法结束
public class Solution3 {

	public static void main(String args[]) {
		TreeLinkNode root = new TreeLinkNode(0);
		TreeLinkNode l1 = new TreeLinkNode(1);
		TreeLinkNode r1 = new TreeLinkNode(2);
		TreeLinkNode l11 = new TreeLinkNode(3);
		TreeLinkNode l12 = new TreeLinkNode(4);
		TreeLinkNode r11 = new TreeLinkNode(5);
		TreeLinkNode r12 = new TreeLinkNode(6);

		root.left = l1;
		root.right = r1;
		l1.left = l11;
		l1.right = l12;
		r1.left = r11;
		r1.right = r12;


		connect(root);
		System.out.println(root.next);
		System.out.println(l1.next.val);
		System.out.println(r1.next);
		System.out.println(l11.next.val);
		System.out.println(l12.next.val);
		System.out.println(r11.next.val);
		System.out.println(r12.next);
	}

	public static void connect(TreeLinkNode root) {
		if (root == null)
			return;

		// link root's child nodes
		link(root); //跟节点的左右子节点的next

		//寻找当前层所有节点的左右子节点的next，并连接
		TreeLinkNode curr = root.next;
		while (curr != null) {
			link(curr);
			curr = curr.next;
		}

		//对当前节点的左右节点递归进行处理
		connect(root.left);
		connect(root.right);
	}

	// helper function
	// link root node's left and right nodes
	public static void link(TreeLinkNode root) {
		if (root == null)
			return;

		if (root.left != null) { //若跟节点的左节点不空，连接左节点及其下一个节点
			root.left.next = ( root.right != null ? root.right : getNext(root) );
		}

		if (root.right != null) {//若跟节点的右节点不空，连接右节点及其下一个节点
			root.right.next = getNext(root);
		}
	}

	// get the left most node at the next level
	// 寻找相邻节点
	public static TreeLinkNode getNext(TreeLinkNode node) {
		TreeLinkNode next = node.next;

		while (next != null) {
			if (next.left != null)
				return next.left;
			if (next.right != null)
				return next.right;
			next = next.next;
		}

		return null;
	}

}
