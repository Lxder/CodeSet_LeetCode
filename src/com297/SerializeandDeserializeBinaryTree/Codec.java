package com297.SerializeandDeserializeBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Codec {

	public static void main(String args[]) {
		TreeNode root = new TreeNode(4);
		TreeNode l1 = new TreeNode(2);
		TreeNode r1 = new TreeNode(3);
		root.left = l1;
		root.right = r1;
		String str = serialize(root);
		System.out.println(str);
		TreeNode solu = deserialize(str);
		System.out.println(solu.val);
		System.out.println(solu.left.val);
	}

	// Encodes a tree to a single string.
	public static String serialize(TreeNode root) {
		if (root == null)
			return "*";
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		StringBuffer sb = new StringBuffer();

		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode curr = queue.poll();
			if (curr == null)
				sb.append("*,");
			else {
				sb.append(curr.val + ",");
				queue.add(curr.left);
				queue.add(curr.right);
			}
		}
		return sb.toString();
	}

	// Decodes your encoded data to tree.
	public static TreeNode deserialize(String data) {
		if(data.equals("*")) return null;
		String[] arrs = data.split(",");
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode root = new TreeNode(Integer.valueOf(arrs[0]));
		queue.add(root);
		for(int i = 1 ; i < arrs.length ; i+=2){
			TreeNode curr = queue.poll();
			if(arrs[i].equals("*")){
				curr.left=null;
			}else{
				TreeNode temp = new TreeNode(Integer.valueOf(arrs[i]));
				curr.left = temp;
				queue.add(temp);
			}
			
			if(arrs[i+1].equals("*")){
				curr.right  =null;
			}else{
				TreeNode temp = new TreeNode(Integer.valueOf(arrs[i+1]));
				curr.right = temp;
				queue.add(temp);
			}
			
		}
		return root;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));