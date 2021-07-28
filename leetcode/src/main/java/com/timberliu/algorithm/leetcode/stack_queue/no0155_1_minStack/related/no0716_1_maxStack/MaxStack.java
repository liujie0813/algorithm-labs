package com.timberliu.algorithm.leetcode.stack_queue.no0155_1_minStack.related.no0716_1_maxStack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 716. 最大栈
 *
 *   两个链表实现
 *     1. popMax 方法时间复杂度为 O(n)，其他为 O(1)
 *     2. 空间复杂度为 O(n)
 *
 * Created by liujie on 2021/3/25
 */

public class MaxStack {

    private Deque<Integer> stack;
    private Deque<Integer> maxStack;

    public MaxStack() {
        stack = new LinkedList<>();
        maxStack = new LinkedList<>();
        maxStack.push(Integer.MIN_VALUE);
    }

    public void push(int x) {
        stack.push(x);
        maxStack.push(Math.max(stack.peek(), x));
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    /**
     * 需要额外空间
     *  1. 弹出所有不等于 max 的数，压入到 tmp 中
     *  2. 真正弹出 max 最大值
     *  3. 将 tmp 中的值再次压回栈中
     *
     * @return
     */
    public int popMax() {
        int res = peekMax();
        Deque<Integer> tmp = new LinkedList<>();
        while (top() != res) {
            tmp.push(pop());
        }
        pop();
        while (!tmp.isEmpty()) {
            push(tmp.pop());
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/max-stack/ -----");
        MaxStack stk = new MaxStack();
        stk.push(5);   // [5] - 5 既是栈顶元素，也是最大元素
        stk.push(1);   // [5, 1] - 栈顶元素是 1，最大元素是 5
        stk.push(5);   // [5, 1, 5] - 5 既是栈顶元素，也是最大元素
        stk.top();     // 返回 5，[5, 1, 5] - 栈没有改变
        stk.popMax();  // 返回 5，[5, 1] - 栈发生改变，栈顶元素不再是最大元素
        stk.top();     // 返回 1，[5, 1] - 栈没有改变
        stk.peekMax(); // 返回 5，[5, 1] - 栈没有改变
        stk.pop();     // 返回 1，[5] - 此操作后，5 既是栈顶元素，也是最大元素
        stk.top();
    }

}
