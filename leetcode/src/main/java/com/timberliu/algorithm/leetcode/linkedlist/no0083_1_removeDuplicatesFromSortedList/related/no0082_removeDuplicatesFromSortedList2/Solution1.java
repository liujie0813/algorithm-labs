package com.timberliu.algorithm.leetcode.linkedlist.no0083_1_removeDuplicatesFromSortedList.related.no0082_removeDuplicatesFromSortedList2;

import com.timberliu.algorithm.leetcode.linkedlist.ListNode;

/**
 * 82. 删除排序链表中的重复元素
 *
 *   时间复杂度：O(n)
 *   空间复杂度：O(1)
 *
 *   原理？
 *     1. 当前 cur 和下一个 cur.next 不相等，且没有重复元素（cur == prev.next）
 *        prev 指向下一个继续判断
 *     2. 当前 cur 和下一个 cur.next 不相等，且有重复元素（cur == prev.next）
 *        跳过所有重复的元素 [prev.next, cur]，让 prev.next 指向 cur.next
 *
 * Created by liujie on 2021/3/11
 */

public class Solution1 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1, head);
        ListNode prev = dummyHead;
        while (prev.next != null) {
            ListNode cur = prev.next;
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            // cur == prev.next 没有重复
            // cur.val != cur.next.val
            if (cur == prev.next) {
                prev = prev.next;
            // cur != prev.next 有重复
            // cur.next == null || cur.val != cur.next.val
            } else {
                prev.next = cur.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/ -----");
        System.out.println("----- 1 -----");
        Solution1 solution1 = new Solution1();
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(3, l1);
        ListNode l3 = new ListNode(2, l2);
        ListNode l4 = new ListNode(1, l3);
        ListNode l5 = new ListNode(1, l4);
        ListNode head1 = solution1.deleteDuplicates(l5);
        System.out.println(head1);

        System.out.println("----- 2 -----");
        ListNode l8 = new ListNode(1);
        ListNode l9 = new ListNode(1, l8);
        ListNode l10 = new ListNode(1, l9);
        ListNode head2 = solution1.deleteDuplicates(l10);
        System.out.println(head2);
    }
}
