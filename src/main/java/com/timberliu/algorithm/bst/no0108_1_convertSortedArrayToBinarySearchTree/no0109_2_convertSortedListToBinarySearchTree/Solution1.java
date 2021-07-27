package com.timberliu.algorithm.bst.no0108_1_convertSortedArrayToBinarySearchTree.no0109_2_convertSortedListToBinarySearchTree;

import com.timberliu.algorithm.linkedlist.ListNode;
import com.timberliu.algorithm.tree.TreeNode;

/**
 *
 * 109. 有序链表转换二叉搜索树
 *
 *  有序链表 -> 中序 构造
 *
 * Created by liujie on 2021/7/27
 */

public class Solution1 {

    public static TreeNode sortedListToBST(ListNode head) {
        int length = 0;
        globalHead = head;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return buildTree(0, length - 1);
    }

    private static ListNode globalHead;

    private static TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode();
        root.left = buildTree(left, mid - 1);
        root.val = globalHead.val;
        globalHead = globalHead.next;
        root.right = buildTree(mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/ -----");
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(5, node1);
        ListNode node3 = new ListNode(0, node2);
        ListNode node4 = new ListNode(-3, node3);
        ListNode node5 = new ListNode(-10, node4);
        TreeNode treeNode1 = sortedListToBST(node5);
        System.out.println(treeNode1);


    }
}
