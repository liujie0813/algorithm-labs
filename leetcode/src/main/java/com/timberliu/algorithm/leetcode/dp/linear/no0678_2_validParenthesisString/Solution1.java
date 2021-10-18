package com.timberliu.algorithm.leetcode.dp.linear.no0678_2_validParenthesisString;

/**
 * 678. 有效的括号字符串
 *
 *  f[i][j]：考虑前 i 个字符中左括号个数为 j 情况下，是否可以形成合法括号序列
 *
 *  其实 f[0][0] = true
 *
 *  转移方程：
 *     1. 当前字符为 (：f[i][j] = f[i-1][j-1]
 *     2. 当前字符为 )：f[i][j] = f[i-1][j+1]
 *     3. 当前字符为 *：f[i][j] = f[i-1][j-1] | f[i-1][j+1] | f[i-1][j]
 *
 *     假设前 5 个字符中，左括号数有 3 个：
 *       1. 当前字符为 (，那么前 4 个字符中，左括号会少一个，左括号即 2 个
 *       2. 当前字符为 )，那么前 4 个字符中，需要多一个左括号来消除这个右括号，左括号即 4 个
 *       3. 当前字符为 *
 *
 * @author liujie
 * @date 2021/10/18
 */

public class Solution1 {

	public static boolean checkValidString(String s) {
		int n = s.length();
		boolean[][] dp = new boolean[n + 1][n + 1];
		dp[0][0] = true;
		for (int i = 1; i <= n; i++) {
			char u = s.charAt(i - 1);
			for (int j = 0; j <= i; j++) {
				if (u == '(') {
					if (j > 0) {
						dp[i][j] = dp[i - 1][j - 1];
					}
				} else if (u == ')') {
					if (j < i) {
						dp[i][j] = dp[i - 1][j + 1];
					}
				} else {
					dp[i][j] = dp[i - 1][j];
					if (j > 0) {
						dp[i][j] |= dp[i - 1][j - 1];
					}
					if (j < i) {
						dp[i][j] |= dp[i - 1][j + 1];
					}
				}
			}
		}
		return dp[n][0];
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/valid-parenthesis-string/ -----");
		System.out.println("----- 1 -----");
		System.out.println(checkValidString("()"));

		System.out.println("----- 2 -----");
		System.out.println(checkValidString("(*)"));

		System.out.println("----- 3 -----");
		System.out.println(checkValidString("(*))"));

		System.out.println("----- 4 -----");
		System.out.println(checkValidString("(((**)"));

		System.out.println("----- 5 -----");
		System.out.println(checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));

	}

}
