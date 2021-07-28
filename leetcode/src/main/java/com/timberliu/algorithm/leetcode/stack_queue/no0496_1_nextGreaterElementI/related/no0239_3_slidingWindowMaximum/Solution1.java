package com.timberliu.algorithm.leetcode.stack_queue.no0496_1_nextGreaterElementI.related.no0239_3_slidingWindowMaximum;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 239. 滑动窗口最大值
 *
 *   双端队列 单调递减
 *     1. 队列存放下标，可以计算元素是否过期
 *
 * Created by liujie on 2021/3/31
 */

public class Solution1 {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            // 维护队列单调递减
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
            // 由于队列递减，这里只需要判断队首元素是否过期 如果是则移出
            if (i - queue.peekFirst() > k - 1) {
                queue.pollFirst();
            }
            // 从第 k-1 个元素开始 统计最大值
            if (i >= k - 1) {
                res[i - k + 1] = nums[queue.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/sliding-window-maximum/ -----");
        System.out.println("----- 1 -----");
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));

        System.out.println("----- 2 -----");
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1}, 1)));

        System.out.println("----- 3 -----");
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1,-1}, 1)));

        System.out.println("----- 4 -----");
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{9,11}, 2)));

        System.out.println("----- 5 -----");
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{4,-2}, 2)));
    }
}
