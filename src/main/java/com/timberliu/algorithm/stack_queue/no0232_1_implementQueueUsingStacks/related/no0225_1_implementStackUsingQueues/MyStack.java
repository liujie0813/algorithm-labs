package com.timberliu.algorithm.stack_queue.no0232_1_implementQueueUsingStacks.related.no0225_1_implementStackUsingQueues;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by liujie on 2021/3/25
 */

public class MyStack {

    private Deque<Integer> firstQueue;
    private Deque<Integer> secondQueue;

    /** Initialize your data structure here. */
    public MyStack() {
        firstQueue = new LinkedList<>();
        secondQueue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        firstQueue.offer(x);
        while (!secondQueue.isEmpty()) {
            firstQueue.offer(secondQueue.poll());
        }
        Deque<Integer> tmp = firstQueue;
        firstQueue = secondQueue;
        secondQueue = tmp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return secondQueue.poll();
    }

    /** Get the top element. */
    public int top() {
        return secondQueue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return secondQueue.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("https://leetcode-cn.com/problems/implement-stack-using-queues/");
        System.out.println("----- 1 -----");
        MyStack myStack = new MyStack();
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