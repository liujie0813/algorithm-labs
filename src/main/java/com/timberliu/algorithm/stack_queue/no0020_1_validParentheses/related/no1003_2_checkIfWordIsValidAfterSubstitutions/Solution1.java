package com.timberliu.algorithm.stack_queue.no0020_1_validParentheses.related.no1003_2_checkIfWordIsValidAfterSubstitutions;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1003. 检查替换后的词是否有效
 *
 * Created by liujie on 2021/3/26
 */

public class Solution1 {

    public static boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == 'a' || cur == 'b') {
                stack.push(cur);
            } else {
                if (stack.size() < 2) {
                    return false;
                }
                if ('b' != stack.pop() || 'a' != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/check-if-word-is-valid-after-substitutions/ -----");
        System.out.println("----- 1 -----");
        System.out.println(isValid("aabcbc"));

        System.out.println("----- 2 -----");
        System.out.println(isValid("abcabcababcc"));

        System.out.println("----- 3 -----");
        System.out.println(isValid("abccba"));

        System.out.println("----- 4 -----");
        System.out.println(isValid("cababc"));

        System.out.println("----- 5 -----");
        System.out.println(isValid(""));
    }
}
