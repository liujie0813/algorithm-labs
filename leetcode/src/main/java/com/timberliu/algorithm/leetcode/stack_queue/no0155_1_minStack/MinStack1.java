package com.timberliu.algorithm.leetcode.stack_queue.no0155_1_minStack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 155. 最小栈
 *
 * Created by liujie on 2021/3/24
 */

public class MinStack1 {

    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public MinStack1() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        minStack.push(Math.min(minStack.peek(), val));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
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
        MinStack1 minStack = new MinStack1();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
