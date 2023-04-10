package com.timberliu.algorithm.leetcode.dp.sequence.string_edit_del_replace.no0583_2_deleteOperationForTwoStrings;

/**
 * 583. 两个字符串的删除操作
 *
 *  dp[i][j] 考虑 word1 中前 i 个字符，word2 中前 j 个字符，达到相同所需的最少删除次数
 *
 *  推导：
 *   如果 s[i-1] = t[j-1]，dp[i][j] = dp[i-1][j-1]
 *   如果 s[i-1] != t[j-1]
 *    1. 删 s[i-1]，dp[i][j] = dp[i-1][j] + 1
 *    2. 删 t[j-1]，dp[i][j] = dp[i][j-1] + 1
 *    3. 同时删 s[i-1] 和 t[j-1]，则 dp[i][j] = dp[i-1][j-1] + 2
 *
 *  初始化：
 *   dp[0][j] = j
 *   dp[i][0] = i
 *
 * @author Timber
 * @date 2021/10/25
 */
public class Solution2 {

	public int minDistance(String word1, String word2) {
		int n = word1.length(), m = word2.length();
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			dp[i][0] = i;
		}
		for (int i = 0; i <= m; i++) {
			dp[0][i] = i;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
				}
			}
		}
		return dp[n - 1][m - 1];
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/delete-operation-for-two-strings/ -----");
		System.out.println("----- 1 -----");
		Solution2 solution1 = new Solution2();
		int res = solution1.minDistance("sea", "eat");
		System.out.println(res);
	}

}
