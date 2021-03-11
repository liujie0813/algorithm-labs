package com.timberliu.algorithm.linkedlist.no0707_2_designLinkedList;

/**
 * 设计链表
 *
 *   双链表实现
 *
 * Created by liujie on 2021/3/4
 */

public class MyLinkedList03 {

    private Node dummyHead;
    private Node dummyTail;
    private Integer size;

    private class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    public MyLinkedList03() {
        dummyHead = new Node(-1, null, null);
        dummyTail = new Node(-1, null, dummyHead);
        dummyHead.next = dummyTail;
        size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        if (index <= (size - 1) / 2) {
            Node cur = dummyHead.next;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            return cur.val;
        } else {
            Node cur = dummyTail.prev;
            for (int i = size - 1; i > index; i--) {
                cur = cur.prev;
            }
            return cur.val;
        }
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node nex = dummyHead.next;
        dummyHead.next = new Node(val, nex, dummyHead);
        nex.prev = dummyHead.next;
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node pre = dummyTail.prev;
        dummyTail.prev = new Node(val, dummyTail, pre);
        pre.next = dummyTail.prev;
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        if (index <= (size - 1) / 2) {
            Node prev = dummyHead;
            for (int i = 0; i < index; i++) {
                prev = prev.next;
            }
            Node nex = prev.next;
            prev.next = new Node(val, nex, prev);
            nex.prev = prev.next;
        } else {
            Node next = dummyTail;
            for (int i = size; i > index; i--) {
                next = next.prev;
            }
            Node pre = next.prev;
            next.prev = new Node(val, next, pre);
            pre.next = next.prev;
        }
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index <  0 || index >= size) {
            return;
        }
        if (index <= (size - 1) / 2) {
            Node pre = dummyHead;
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            pre.next = pre.next.next;
            pre.next.prev = pre;
        } else {
            Node nex = dummyTail;
            for (int i = size - 1; i > index; i--) {
                nex = nex.prev;
            }
            nex.prev = nex.prev.prev;
            nex.prev.next = nex;
        }
        size--;
    }

    @Override
    public String toString() {
        Node cur = dummyHead.next;
        StringBuilder sb = new StringBuilder();
        while (cur != dummyTail) {
            sb.append(cur.val).append(" -> ");
            cur = cur.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MyLinkedList03 linkedList = new MyLinkedList03();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        System.out.println(linkedList.toString());
        System.out.println(linkedList.get(1));

        linkedList.addAtIndex(2, 2);
        System.out.println(linkedList.toString());
        System.out.println(linkedList.get(0));

        linkedList.deleteAtIndex(2);
        System.out.println(linkedList.toString());
        System.out.println(linkedList.get(5));
    }
}
