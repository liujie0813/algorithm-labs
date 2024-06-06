package com.timberliu.algorithm.leetcode.linkedlist.no0146_2_lruCache;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存
 *
 * @author liujie
 * @date 2024/6/4
 */

public class LRUWithExpireCache {

	static class Node {
		private int key, value;
		private Node prev, next;
		private long timestamp;
		private Node() {}
		private Node(int key, int value, long timestamp) {
			this.key = key;
			this.value = value;
			this.timestamp = timestamp;
		}
	}

	private Map<Integer, Node> map;
	private Node head;
	private int capacity;

	public LRUWithExpireCache(int capacity) {
		this.map = new HashMap<>();
		this.capacity = capacity;
		this.head = new Node(-1, -1, -1);
		head.next = head;
		head.prev = head;
	}

	public int get(int key) {
		Node node = map.get(key);
		if (node == null) {
			return -1;
		}
		if (System.currentTimeMillis() < node.timestamp) {
			delete(node);
			headInsert(node);
			return node.value;
		} else {
			map.remove(node.key);
			delete(node);
			return -1;
		}
	}

	public void put(int key, int value, int expire) {
		Node node = map.get(key);
		if (node == null) {
			if (map.size() == capacity) {
				// 找一个过期元素
				Node cur = head.next;
				Node expireNode = null;
				while (cur != head) {
					if (cur.timestamp > System.currentTimeMillis()) {
						expireNode = cur;
						break;
					}
					cur = cur.next;
				}
				// 如果找到过期元素，则删除
				if (expireNode != null) {
					map.remove(expireNode.key);
					delete(expireNode);
				} else {
					// 否则删除末尾元素
					map.remove(head.prev.key);
					delete(head.prev);
				}
			}
			long millis = System.currentTimeMillis();
			node = new Node(key, value, millis + expire);
			map.put(key, node);
		} else {
			delete(node);
			node.value = value;
		}
		headInsert(node);
	}
	
	private void headInsert(Node node) {
		node.next = head.next;
		node.next.prev = node;
		head.next = node;
		node.prev = head;
	}

	private void delete(Node node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

	public static void main(String[] args) {
		LRUWithExpireCache lruCache = new LRUWithExpireCache(2);
		lruCache.put(1, 1, 10);
		lruCache.put(2, 2, 10);
		System.out.println(lruCache.get(1));
		lruCache.put(3, 3, 10);
		System.out.println(lruCache.get(2));
		lruCache.put(4, 4, 0);
		System.out.println(lruCache.get(1));
		System.out.println(lruCache.get(3));
		System.out.println(lruCache.get(4));
	}

}
