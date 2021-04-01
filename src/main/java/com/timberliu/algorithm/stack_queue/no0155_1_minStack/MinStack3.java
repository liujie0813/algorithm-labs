package com.timberliu.algorithm.stack_queue.no0155_1_minStack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 155. 最小栈
 *
 *   不用辅助栈
 *     1. 栈中保存差值
 *     2. 可使用样例思考
 *        实际值  1  stack  -1   minVal:  1
 *               2         x
 *
 *        实际值  2  stack  1   minVal:   1
 *               1         x
 *
 * Created by liujie on 2021/3/24
 */

public class MinStack3 {

    private Deque<Long> stack;
    private int minVal = -1;

    public MinStack3() {
        stack = new LinkedList<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(0L);
            minVal = val;
        } else {
            stack.push((long) val - minVal);
            minVal = Math.min(val, minVal);
        }
    }

    public void pop() {
        Long diff = stack.pop();
        if (diff < 0) {
//            int res = minVal;
            minVal = minVal - diff.intValue();
//            return res;
        } else {
//            return minVal + diff;
        }
    }

    public int top() {
        if (stack.peek() < 0) {
            return minVal;
        } else {
            return stack.peek().intValue() + minVal;
        }
    }

    public int getMin() {
        return minVal;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/min-stack/ -----");
        System.out.println("----- 1 -----");
        MinStack3 minStack = new MinStack3();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        int top = minStack.top();
        System.out.println(top);
        minStack.pop();
        int min = minStack.getMin();
        System.out.println(min);
        minStack.pop();
        int min1 = minStack.getMin();
        System.out.println(min1);
        minStack.pop();
        minStack.push(2147483647);
        int top1 = minStack.top();
        System.out.println(top1);
        int min2 = minStack.getMin();
        System.out.println(min2);
        minStack.push(-2147483648);
        int top2 = minStack.top();
        System.out.println(top2);
        int min3 = minStack.getMin();
        System.out.println(min3);
        minStack.pop();
        int min4 = minStack.getMin();
        System.out.println(min4);
    }
}
