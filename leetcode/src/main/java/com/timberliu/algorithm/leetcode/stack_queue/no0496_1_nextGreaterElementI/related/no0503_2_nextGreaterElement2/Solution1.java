package com.timberliu.algorithm.leetcode.stack_queue.no0496_1_nextGreaterElementI.related.no0503_2_nextGreaterElement2;

import java.util.*;

/**
 * 503. 下一个更大元素 II
 *
 *   单调栈：始终维持栈内元素单调递减
 *
 *   具体:
 *     1. 遍历数组
 *     2. 如果栈为空，则将当前元素放入栈内
 *        如果栈不为空，则需要判断栈顶元素和当前元素的大小
 *           如果栈顶元素 小于 当前元素，说明当前元素 是前面元素的 下一个更大元素，则逐个弹出栈顶元素，更新结果
 *              直到栈顶元素 大于等于 当前元素为止（元素相等也不是下一个更大元素）
 *           如果栈顶元素 大于等于 当前元素，则把当前元素入栈
 *
 * Created by liujie on 2021/3/26
 */

public class Solution1 {

    public static int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);
        for (int i = 0; i < 2 * len; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % len]) {
                res[stack.pop()] = nums[i % len];
            }
            stack.push(i % len);
        }
        return res;
    }

    public static int[] nextGreaterElements1(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        int len = nums.length;
        int[] res = new int[len];
        for (int i = 2 * len - 1; i >= 0 ; i--) {
            while (!stack.isEmpty() && nums[i % len] >= stack.peek()) {
                stack.pop();
            }
            res[i % len] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % len]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/next-greater-element-ii/ -----");
        System.out.println("----- 1 -----");
        System.out.println(Arrays.toString(nextGreaterElements1(new int[]{1,2,1})));

    }
}
