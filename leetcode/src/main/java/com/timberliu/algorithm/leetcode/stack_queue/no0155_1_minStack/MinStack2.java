package com.timberliu.algorithm.leetcode.stack_queue.no0155_1_minStack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 155. 最小栈
 *
 * Created by liujie on 2021/3/24
 */

public class MinStack2 {

    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public MinStack2() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        if (val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.peek() <= minStack.peek()) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/min-stack/ -----");
        System.out.println("----- 1 -----");
        MinStack2 minStack = new MinStack2();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.push(-3);
        int min = minStack.getMin();
        System.out.println(min);
        minStack.pop();
        int top = minStack.top();
        System.out.println(top);
        int min1 = minStack.getMin();
        System.out.println(min1);
    }
}
