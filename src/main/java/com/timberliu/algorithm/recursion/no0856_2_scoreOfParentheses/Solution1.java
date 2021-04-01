package com.timberliu.algorithm.recursion.no0856_2_scoreOfParentheses;

/**
 * 856. 括号的分数
 *
 * Created by liujie on 2021/4/1
 */

public class Solution1 {

    public static int scoreOfParentheses(String str) {
        return doScoreOfParentheses(str, 0, str.length());
    }

    private static int doScoreOfParentheses(String str, int left, int right) {
        int ans = 0, bal = 0;
        // 遍历 left 到 right
        for (int i = left; i < right; i++) {
            bal += str.charAt(i) == '(' ? 1 : -1;
            if (bal == 0) {
                // () 出现同样次数
                // 字符为 () 直接 +1
                if (i - left == 1) {
                    ans += 1;
                // 其他，2 * xxx
                } else {
                    ans += 2 * doScoreOfParentheses(str, left + 1, i);
                }
                // 处理过之后 更新left
                left = i + 1;
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
