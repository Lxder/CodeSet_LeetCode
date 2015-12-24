package com117.PopulatingNextRightPointersinEachNodeII;

////////����ȷ�����е�����ʱ���޷�����
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
		link(root); //���ڵ�������ӽڵ��next

		//Ѱ�ҵ�ǰ�����нڵ�������ӽڵ��next��������
		TreeLinkNode curr = root.next;
		while (curr != null) {
			link(curr);
			curr = curr.next;
		}

		//�Ե�ǰ�ڵ�����ҽڵ�ݹ���д���
		connect(root.left);
		connect(root.right);
	}

	// helper function
	// link root node's left and right nodes
	public static void link(TreeLinkNode root) {
		if (root == null)
			return;

		if (root.left != null) { //�����ڵ����ڵ㲻�գ�������ڵ㼰����һ���ڵ�
			root.left.next = ( root.right != null ? root.right : getNext(root) );
		}

		if (root.right != null) {//�����ڵ���ҽڵ㲻�գ������ҽڵ㼰����һ���ڵ�
			root.right.next = getNext(root);
		}
	}

	// get the left most node at the next level
	// Ѱ�����ڽڵ�
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
