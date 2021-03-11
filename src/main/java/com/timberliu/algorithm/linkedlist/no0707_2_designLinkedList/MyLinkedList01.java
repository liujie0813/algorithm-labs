package com.timberliu.algorithm.linkedlist.no0707_2_designLinkedList;

/**
 * 设计链表
 *
 *   单链表实现
 *
 * Created by liujie on 2021/3/4
 */

public class MyLinkedList01 {

    private Node dummyHead;
    private Node tail;

    private class Node {
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public MyLinkedList01() {
        dummyHead = new Node(-1, null);
        tail = dummyHead;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0) {
            return -1;
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index && cur != null; i++) {
            cur = cur.next;
        }
        if (cur == null) {
            return -1;
        }
        return cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        dummyHead.next = new Node(val, dummyHead.next);
        if (dummyHead == tail) {
            tail = tail.next;
        }
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        tail.next = new Node(val, null);
        tail = tail.next;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            if (prev == null) {
                return;
            }
            prev = prev.next;
        }
        prev.next = new Node(val, prev.next);
        if (prev == tail) {
            tail = tail.next;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        Node prev = dummyHead;
        for (int i = 0; i < index && prev.next != null; i++) {
            prev = prev.next;
        }
        if (prev.next == null) {
            return;
        }
        prev.next = prev.next.next;
        if (prev.next == null) {
            tail = prev;
        }
    }

    @Override
    public String toString() {
        Node cur = dummyHead.next;
        StringBuilder sb = new StringBuilder();
        while (cur != null) {
            sb.append(cur.val).append(" -> ");
            cur = cur.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MyLinkedList01 linkedList = new MyLinkedList01();
        linkedList.addAtHead(7);
        linkedList.addAtTail(7);
        linkedList.addAtHead(9);
        linkedList.addAtTail(8);
        linkedList.addAtHead(6);
        linkedList.addAtHead(0);
        System.out.println(linkedList.toString());
        int i2 = linkedList.get(5);
        System.out.println(i2);
        linkedList.addAtHead(0);
        int i = linkedList.get(2);
        System.out.println(i);
        int i1 = linkedList.get(5);
        System.out.println(i1);
        linkedList.addAtTail(4);
        System.out.println(linkedList.toString());
    }
}
