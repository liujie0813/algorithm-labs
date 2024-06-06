package com.timberliu.algorithm.leetcode.linkedlist.no0146_2_lruCache;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存
 *
 * @author liujie
 * @date 2024/6/4
 */

public class LRUCache {

	static class Node {
		private int key, value;
		private Node prev, next;
		private Node() {}
		private Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	private Map<Integer, Node> map;
	private Node head;
	private int capacity;

	public LRUCache(int capacity) {
		this.map = new HashMap<>();
		this.capacity = capacity;
		this.head = new Node(-1, -1);
		head.next = head;
		head.prev = head;
	}

	public int get(int key) {
		Node node = map.get(key);
		if (node == null) {
			return -1;
		}
		delete(node);
		headInsert(node);
		return node.value;
	}

	public void put(int key, int value) {
		Node node = map.get(key);
		if (node == null) {
			node = new Node(key, value);
			map.put(key, node);
		} else {
			delete(node);
			node.value = value;
		}
		headInsert(node);
		if (map.size() > capacity) {
			Node tmp = head.prev;
			delete(tmp);
			map.remove(tmp.key);
		}
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
		LRUCache lruCache = new LRUCache(2);
		lruCache.put(1, 1);
		lruCache.put(2, 2);
		System.out.println(lruCache.get(1));
		lruCache.put(3, 3);
		System.out.println(lruCache.get(2));
		lruCache.put(4, 4);
		System.out.println(lruCache.get(1));
		System.out.println(lruCache.get(3));
		System.out.println(lruCache.get(4));
	}

}
