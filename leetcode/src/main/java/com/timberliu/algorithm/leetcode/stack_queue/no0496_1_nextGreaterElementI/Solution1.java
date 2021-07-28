package com.timberliu.algorithm.leetcode.stack_queue.no0496_1_nextGreaterElementI;

import java.util.*;

/**
 * 496. 下一个更大元素 I
 *
 *   单调栈：维护栈顶到栈底是单调递减的

 *   思路：
 *     https://leetcode-cn.com/problems/next-greater-element-ii/solution/dong-hua-jiang-jie-dan-diao-zhan-by-fuxu-4z2g/
 *
 * Created by liujie on 2021/3/26
 */

public class Solution1 {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[nums2.length];
        for (int i = nums2.length - 1; i >= 0; i--) {
            // 如果当前元素 大于等于 栈顶元素，则 栈顶元素不是当前元素的 下一个更大元素，将栈顶元素出栈，继续判断，直到栈顶元素大于当前元素
            while (!stack.isEmpty() && nums2[i] >= stack.peek()) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums2[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/next-greater-element-i/solution/xia-yi-ge-geng-da-yuan-su-i-by-leetcode/ -----");
        System.out.println("----- 1 -----");
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));

        System.out.println("----- 2 -----");
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4})));

    }
}
