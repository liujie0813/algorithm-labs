package com.timberliu.algorithm.leetcode.dp.sequence.string_edit_del_replace.no0392_1_isSubsequence;

/**
 * 392. 判断子序列

 *  dp[i][j] 考虑 s 中前 i 个字符，t 中前 j 个字符，相同子序列的长度
 *
 *  推导：
 *   如果 s[i - 1] = t[j - 1]，dp[i][j] = dp[i-1][j-1] + 1
 *   如果 s[i - 1] != t[j - 1]，dp[i][j] = dp[i][j-1]
 *
 *  与 1143 不同的是
 *   1143. 不等时可以删除 s 或 t 中的字符，dp[i][j] = max(dp[i][j-1], dp[i-1][j])
 *   392. 不等时只删除 t 中的字符，dp[i][j] = dp[i][j-1]
 */

public class Solution1 {

    public boolean isSubsequence(String s, String t) {
    	int m = s.length(), n = t.length();
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = dp[i][j - 1];
				}
			}
		}
		return dp[m][n] == s.length();
    }

    public static void main(String[] args) {
		Solution1 solution1 = new Solution1();
		boolean subsequence = solution1.isSubsequence("abc", "ahbgdc");
		System.out.println(subsequence);
	}

}