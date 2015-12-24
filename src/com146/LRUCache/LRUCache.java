package com146.LRUCache;

import java.util.HashMap;

class DLinkedNode {
	int key;
	int value;
	DLinkedNode pre;
	DLinkedNode post;
}

public class LRUCache {

	public static void main(String args[]) {

		// get(2),set(2,6),get(1),set(1,5),set(1,2),get(1),get(2)
		LRUCache l = new LRUCache(2);
		System.out.println(l.get(2));
		l.set(2, 6);
		System.out.println(l.get(1));
		l.set(1, 5);
		l.set(1, 2);
		System.out.println(l.get(1));
		System.out.println(l.get(2));
	}

	private HashMap<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
	private int count;
	private int capacity;
	private DLinkedNode head, tail; // 头指针和尾指针

	public LRUCache(int capacity) {
		this.count = 0;
		this.capacity = capacity;

		head = new DLinkedNode();
		head.pre = null;

		tail = new DLinkedNode();
		tail.post = null;

		head.post = tail;
		tail.pre = head;
	}

	public int get(int key) {
		DLinkedNode node = cache.get(key);
		if (node == null) {
			return -1; // should raise exception here.
		}

		// move the accessed node to the head;
		this.moveToHead(node);
		return node.value;
	}

	public void set(int key, int value) {
		DLinkedNode node = cache.get(key);

		if (node == null) {
			DLinkedNode newNode = new DLinkedNode();
			newNode.key = key;
			newNode.value = value;

			this.cache.put(key, newNode);
			this.addNode(newNode);
			count++;

			if (count > capacity) {
				// pop the tail
				DLinkedNode tail = this.popTail(); // 删除链表元素				
				this.cache.remove(tail.key); // 删除value				
				--count;
			}
		} else {
			// update the value.
			node.value = value;
			this.moveToHead(node);
		}
	}

	/**
	 * Always add the new node right after head;
	 */
	private void addNode(DLinkedNode node) {
		node.pre = head;
		node.post = head.post;

		head.post.pre = node;
		head.post = node;
	}

	/**
	 * Remove an existing node from the linked list.
	 */
	private void removeNode(DLinkedNode node) {
		DLinkedNode pre = node.pre;
		DLinkedNode post = node.post;

		pre.post = post;
		post.pre = pre;
	}

	/**
	 * Move certain node in between to the head.
	 */
	private void moveToHead(DLinkedNode node) {
		this.removeNode(node);
		this.addNode(node);
	}

	// pop the current tail.
	private DLinkedNode popTail() {
		DLinkedNode res = tail.pre;
		this.removeNode(res);
		return res;
	}
}