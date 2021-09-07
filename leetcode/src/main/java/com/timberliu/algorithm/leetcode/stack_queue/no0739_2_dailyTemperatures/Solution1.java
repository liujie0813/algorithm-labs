package com.timberliu.algorithm.leetcode.stack_queue.no0739_2_dailyTemperatures;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 739. 每日温度
 *
 *  单调栈：栈中存储下标，各个下标对应的温度列表中的温度依次递减。
 *         如果一个下标在单调栈里，则表示尚未找到下一次温度更高的向下表
 *
 * Created by liujie on 2021/3/31
 */

public class Solution1 {

    public static int[] dailyTemperatures(int[] T) {
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                Integer pop = stack.pop();
                res[pop] = i - pop;
            }
            stack.push(i);
        }
        return res;
    }

    public static int[] dailyTemperatures1(int[] T) {
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[T.length];
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/daily-temperatures/ -----");
        System.out.println("----- 1 -----");
        System.out.println(Arrays.toString(dailyTemperatures1(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));

    }
}
