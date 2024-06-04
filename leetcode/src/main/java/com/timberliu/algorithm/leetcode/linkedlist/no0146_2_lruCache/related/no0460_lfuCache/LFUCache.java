package com.timberliu.algorithm.leetcode.linkedlist.no0146_2_lruCache.related.no0460_lfuCache;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liujie
 * @date 2024/6/4
 */

public class LFUCache {

	private Map<Integer, Node> dataMap;
	private Map<Integer, DoublyLinkedList> frequencyMap;
	private int capacity;
	private int minFrequency;

	public LFUCache(int capacity) {
		this.dataMap = new HashMap<>();
		this.frequencyMap = new HashMap<>();
		this.capacity = capacity;
	}

	public int get(int key) {
		Node node = dataMap.get(key);
		if (node == null) {
			return -1;
		}
		incrFrequency(node);
		return node.value;
	}

	public void put(int key, int value) {
		Node node = dataMap.get(key);
		if (node != null) {
			node.value = value;
			incrFrequency(node);
		} else {
			if (dataMap.size() == capacity) {
				DoublyLinkedList doublyLinkedList = frequencyMap.get(minFrequency);
				dataMap.remove(doublyLinkedList.head.prev.key);
				doublyLinkedList.delete(doublyLinkedList.head.prev);
			}
			node = new Node(key, value);
			dataMap.put(key, node);
			DoublyLinkedList doublyLinkedList = frequencyMap.get(1);
			if (doublyLinkedList == null) {
				doublyLinkedList = new DoublyLinkedList();
				frequencyMap.put(1, doublyLinkedList);
			}
			doublyLinkedList.headInsert(node);
			minFrequency = 1;
		}
	}

	private void incrFrequency(Node node) {
		// 旧链表
		DoublyLinkedList doublyLinkedList = frequencyMap.get(node.frequency);
		doublyLinkedList.delete(node);
		if (doublyLinkedList.isEmpty() && minFrequency == node.frequency) {
			minFrequency++;
		}
		// 新链表
		node.frequency++;
		doublyLinkedList = frequencyMap.get(node.frequency);
		if (doublyLinkedList == null) {
			doublyLinkedList = new DoublyLinkedList();
			frequencyMap.put(node.frequency, doublyLinkedList);
		}
		doublyLinkedList.headInsert(node);
	}

	static class Node {
		private int key, value;
		private Node prev, next;
		private int frequency;
		private Node() {}
		private Node(int key, int value) {
			this.key = key;
			this.value = value;
			this.frequency = 1;
		}
	}

	static class DoublyLinkedList {
		Node head;
		DoublyLinkedList() {
			head = new Node();
			head.next = head;
			head.prev = head;
		}
		public void headInsert(Node node) {
			node.next = head.next;
			node.next.prev = node;
			head.next = node;
			node.prev = head;
		}
		public void delete(Node node) {
			node.prev.next = node.next;
			node.next.prev = node.prev;
		}
		public boolean isEmpty() {
			return head.next == head;
		}
	}

	public static void main(String[] args) {
		LFUCache lfuCache = new LFUCache(2);
		lfuCache.put(1, 1);
		lfuCache.put(2, 2);
		System.out.println(lfuCache.get(1));
		lfuCache.put(3, 3);
		System.out.println(lfuCache.get(2));
		System.out.println(lfuCache.get(3));
		lfuCache.put(4, 4);
		System.out.println(lfuCache.get(1));
		System.out.println(lfuCache.get(3));
		System.out.println(lfuCache.get(4));
	}

}
