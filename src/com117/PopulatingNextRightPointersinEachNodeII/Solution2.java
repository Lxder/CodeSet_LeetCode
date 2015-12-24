package com117.PopulatingNextRightPointersinEachNodeII;


////////不正确，运行到最后的时候无法结束
public class Solution2 {

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
		findNextNodeNextLev(r1, r12);

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
		if (null == root)
			return;
		TreeLinkNode start;
		TreeLinkNode curNode;
		TreeLinkNode nextNode;
		while (root != null) {
			start = findStartNodeNextLev(root);
			curNode = start;
			nextNode = findNextNodeNextLev(root, start);
			while (nextNode != null) {
				curNode.next = nextNode;
				curNode = nextNode;
				nextNode = findNextNodeNextLev(root, curNode);
			}
			root = start;
		}
	}

	// 寻找下一个节点 curr是上层的节点，node是要求next的节点
	public static TreeLinkNode findNextNodeNextLev(TreeLinkNode cur,
			TreeLinkNode curNextLev) {
		if (cur.left == curNextLev && cur.right != null) {
			return cur.right;
		} else {
			while (cur.next != null) {
				cur = cur.next;
				if (cur.left != null && cur.left != curNextLev)
					return cur.left;
				if (cur.right != null && cur.right != curNextLev)
					return cur.right;
			}
		}
		return null;

	}

	// 寻找下一层的第一个节点
	public static TreeLinkNode findStartNodeNextLev(TreeLinkNode node) {
		if (null == node)
			return null;
		if (node.left != null)
			return node.left;
		return findNextNodeNextLev(node, node.left);
	}

//	// 寻找下一层的第一个节点
//	public static TreeLinkNode findStartNodeNextLev(TreeLinkNode root) {
//		while (root != null) {
//			if (root.left != null)
//				return root.left;
//			else if (root.right != null)
//				return root.right;
//			else
//				root = root.next;
//		}
//		return null;
//	}
	
}
