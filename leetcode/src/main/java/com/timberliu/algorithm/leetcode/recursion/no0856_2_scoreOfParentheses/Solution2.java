package com.timberliu.algorithm.leetcode.recursion.no0856_2_scoreOfParentheses;

/**
 * 856. 括号的分数
 *
 * Created by liujie on 2021/4/1
 */

public class Solution2 {

    public static int scoreOfParentheses(String str) {
        int ans = 0, bal = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                bal++;
            } else {
                bal--;
                if (str.charAt(i - 1) == '(') {
                    // 1 << x  ====  2^x
                    ans += 1 << bal;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/score-of-parentheses/ -----");
        System.out.println("----- 1 -----");
        System.out.println(scoreOfParentheses("()"));

        System.out.println("----- 2 -----");
        System.out.println(scoreOfParentheses("(())"));

        System.out.println("----- 3 -----");
        System.out.println(scoreOfParentheses("()()"));

        System.out.println("----- 4 -----");
        System.out.println(scoreOfParentheses("(()(()))"));

    }
}
