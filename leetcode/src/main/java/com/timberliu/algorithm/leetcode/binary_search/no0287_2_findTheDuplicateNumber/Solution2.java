package com.timberliu.algorithm.leetcode.binary_search.no0287_2_findTheDuplicateNumber;

/**
 * 287. 寻找重复数
 *
 *   时间复杂度：O(n)
 *   空间复杂度：O(1)
 *
 *   原理？
 *     1. 如何构造链表
 *         slow、fast：值表示当前元素，也表示指向的元素的下标
 *            例如 1 3 4 2 2
 *            构造链表为 1 -> 3 -> 2 -> 4
 *     2. 按照寻找环形链表入口节点 计算
 *
 * Created by liujie on 2021/3/18
 */

public class Solution2 {

    public static int findDuplicate1(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/find-the-duplicate-number/ -----");
        System.out.println("----- 1 -----");
        System.out.println(findDuplicate1(new int[]{1,3,4,2,2}));

        System.out.println("----- 2 -----");
        System.out.println(findDuplicate1(new int[]{3,1,3,4,2}));

        System.out.println("----- 3 -----");
        System.out.println(findDuplicate1(new int[]{1,1}));

        System.out.println("----- 4 -----");
        System.out.println(findDuplicate1(new int[]{1,1,2}));
    }
}
