package com.timberliu.algorithm.leetcode.dp.sequence.string_edit_del_replace.no0072_3_editDistance;

/**
 * 72. 编辑距离
 *
 *  插入/删除/替换 最少转换次数
 *   a. horse -> ros
 *   b. intention -> execution
 *
 *  dp[i][j] 考虑 word1 中前 i 个字符，word2 中前 j 个字符，最少转换次数
 *
 *  推导：
 *   如果 s[i-1] = t[j-1]，则 dp[i][j] = dp[i-1][j-1]
 *   如果 s[i-1] != [j-1]
 *    1. 删除 s[i-1]，则 dp[i][j] = dp[i-1][j] + 1
 *    2. 删除 t[j-1]，则 dp[i][j] = dp[i][j-1] + 1（相当于 s 添加一个元素）
 *    3. 替换 s[i-1] 为 t[j-1]，则 dp[i][j] = dp[i-1][j-1] + 1
 *
 *  初始化
 *   dp[0][0] = 0
 *
 */

public class Solution1 {

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int res = solution.minDistance("intention", "execution");
        System.out.println(res);

    }

}