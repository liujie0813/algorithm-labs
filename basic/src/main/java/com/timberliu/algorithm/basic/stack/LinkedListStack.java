package com.timberliu.algorithm.basic.stack;

/**
 * 基于链表实现，采用头插法
 *
 * @author liujie
 * @date 2021/9/7
 */

public class LinkedListStack<E> implements Stack<E> {

	private class Node {
		public E e;
		public Node next;
		public Node(E e, Node next) {
			this.e = e;
			this.next = next;
		}
	}
	private Node head;

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public void push(E e) {
		head = new Node(e, head);
	}

	@Override
	public E pop() {
		if (isEmpty()) {
			return null;
		}
		Node res = head;
		head = head.next;
		return res.e;
	}

	@Override
	public E peek() {
		return head.e;
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new LinkedListStack<>();
		for (int i = 0; i < 5; i++) {
			stack.push(i);
		};
		System.out.println(stack.pop());
		System.out.println(stack.peek());
	}
}
