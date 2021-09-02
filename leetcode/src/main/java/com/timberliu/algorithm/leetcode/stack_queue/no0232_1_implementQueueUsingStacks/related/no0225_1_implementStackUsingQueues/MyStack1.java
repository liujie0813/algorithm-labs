package com.timberliu.algorithm.leetcode.stack_queue.no0232_1_implementQueueUsingStacks.related.no0225_1_implementStackUsingQueues;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by liujie on 2021/3/25
 */

public class MyStack1 {

    private Deque<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack1() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        int n = queue.size();
        queue.offer(x);
        for (int i = 0; i < n; i++) {
            queue.offer(queue.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("https://leetcode-cn.com/problems/implement-stack-using-queues/");
        System.out.println("----- 1 -----");
        MyStack1 myStack = new MyStack1();
        myStack.push(1);
        myStack.push(2);
        int top = myStack.top();
        System.out.println(top);
        int pop = myStack.pop();
        System.out.println(pop);
        boolean empty = myStack.empty();
        System.out.println(empty);
    }
}