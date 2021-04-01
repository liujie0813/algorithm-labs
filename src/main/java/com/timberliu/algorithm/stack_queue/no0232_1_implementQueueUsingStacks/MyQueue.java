package com.timberliu.algorithm.stack_queue.no0232_1_implementQueueUsingStacks;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 232. 用栈实现队列
 *
 * Created by liujie on 2021/3/24
 */

public class MyQueue {

    private Deque<Integer> firstStack;
    private Deque<Integer> secondStack;

    /** Initialize your data structure here. */
    public MyQueue() {
        firstStack = new LinkedList<>();
        secondStack = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        firstStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (secondStack.isEmpty()) {
            while (!firstStack.isEmpty()) {
                secondStack.push(firstStack.pop());
            }
        }
        return secondStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (secondStack.isEmpty()) {
            while (!firstStack.isEmpty()) {
                secondStack.push(firstStack.pop());
            }
        }
        return secondStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return firstStack.isEmpty() && secondStack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/implement-queue-using-stacks/ -----");
        System.out.println("----- 1 -----");
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        int peek1 = myQueue.peek();
        System.out.println(peek1);
        int pop1 = myQueue.pop();
        System.out.println(pop1);
        boolean empty1 = myQueue.empty();
        System.out.println(empty1);

    }
}