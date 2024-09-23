package com.timberliu.algorithm.leetcode.dp.sequence.no0097_2_isInterleave;

/**
 * 97. 交错字符串
 *
 * dp[i][j] 表示考虑 s1 中前 i 个字符、s2 中前 j 个字符，是否能构成 s3 中前 i+j 个字符
 *
 *  若 s1[i] == s3[i + j], dp[i][j] = dp[i - 1][j]
 *  若 s2[j] == s3[i + j], dp[i][j] = dp[i][j - 1]
 *
 * dp[0][0] = true
 * dp[0][j]
 * dp[i][0]
 *
 * @author liujie
 * @date 2024/9/20
 */

public class Solution1 {

	public boolean isInterleave(String s1, String s2, String s3) {
		int m = s1.length(), n = s2.length();
		if (m + n != s3.length()) {
			return false;
		}
		boolean[][] dp = new boolean[m + 1][n + 1];
		dp[0][0] = true;
		// 只看 s1
		for (int i = 1; i <= m; i++) {
			dp[i][0] = s1.charAt(i - 1) == s3.charAt(i - 1);
			if (!dp[i][0]) {
				break;
			}
		}
		// 只看 s2
		for (int j = 1; j <= n; j++) {
			dp[0][j] = s2.charAt(j - 1) == s3.charAt(j - 1);
			if (!dp[0][j]) {
				break;
			}
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				char a = s1.charAt(i - 1);
				char b = s2.charAt(j - 1);
				char c = s3.charAt(i + j - 1);
				if (a == c || b == c) {
					dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
				}
			}
		}
		return dp[m][n];
	}

	public static void main(String[] args) {
		Solution1 solution1 = new Solution1();
		System.out.println(solution1.isInterleave("aabcc", "dbbca", "aadbbcbcac"));

		System.out.println(solution1.isInterleave("aabcc", "dbbca", "aadbbbaccc"));

	}

}
