package com.timberliu.algorithm.leetcode.stack_queue.no0020_1_validParentheses;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 20. 有效的括号
 *
 * Created by liujie on 2021/3/26
 */

public class Solution1 {

    public static boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        int i = 0;
        for (; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(' || cur == '[' || cur == '{') {
                stack.push(cur);
            } else if (!stack.isEmpty()){
                Character pop = stack.pop();
                if (!(pop == '(' && cur == ')') &&
                        !(pop == '[' && cur == ']') &&
                        !(pop == '{' && cur == '}')) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return stack.isEmpty() && i == s.length();
    }

    public static boolean isValid1(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(') {
                stack.push(')');
            } else if (cur == '[') {
                stack.push(']');
            } else if (cur == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || cur != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/valid-parentheses/ -----");
        System.out.println("----- 1 -----");
        System.out.println(isValid("()"));

        System.out.println("----- 2 -----");
        System.out.println(isValid("()[]{}"));

        System.out.println("----- 3 -----");
        System.out.println(isValid("(]"));

        System.out.println("----- 4 -----");
        System.out.println(isValid("([)]"));

        System.out.println("----- 5 -----");
        System.out.println(isValid("{[]}"));

    }
}
