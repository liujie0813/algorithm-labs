package com.timberliu.algorithm.leetcode.dp.sequence.sub_sequence_two.no1035_2_uncrossedLines;

/**
 * 1035. 不相交的线
 *
 *   状态定义：f[i][j] 考虑 nums1 的前 i 个字符，nums2 的前 j 个字符，最长公共子序列的长度
 *
 *     状态定义只是考虑前 i 个字符和前 j 个字符，并不是 一定要包含第 i 个或第 j 个字符
 *
 *    1. 不包含 s1[i]，不包含 s2[j]： f[i][j] = f[i - 1][j - 1]
 *    2. 包含 s1[i]，包含 s2[j]：如果 s1[i] == s2[j]，f[i][j] = f[i - 1][j - 1] + 1
 *    3. 不包含 s1[i]，包含 s2[j]：
 *         f[i - 1][j] 是表示 必然不包含 s1[i]，但可能包含 s2[j]
 *         由于求最大值，只需要确保 不漏 即可，这里直接使用 f[i][j] = f[i][j - 1]
 *    4. 包含 s1[i]，不包含 s2[j]：
 *         同 3，直接使用 f[i][j] = f[i - 1][j]
 *
 *    由于 1 被 3、4 所包含，状态转移方程：
 *      f[i][j] = { max(f[i - 1][j]，f[i][j - 1]，f[i - 1][j - 1] + 1)，s1[i] == s2[j]
 *                  max(f[i - 1][j]，f[i][j - 1])                       s1[i] != s2[j]
 *
 * @author Timber
 * @date 2021/10/25
 */
public class Solution1 {

	public int maxUncrossedLines(int[] nums1, int[] nums2) {
		int n = nums1.length, m = nums2.length;
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				if (nums1[i - 1] == nums2[j - 1]) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
				}
			}
		}
		return dp[n][m];
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/uncrossed-lines/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		System.out.println(solution1.maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4}));

		System.out.println("----- 2 -----");
		System.out.println(solution1.maxUncrossedLines(new int[]{2, 5, 1, 2, 5}, new int[]{10, 5, 2, 1, 5, 2}));

		System.out.println("----- 3 -----");
		System.out.println(solution1.maxUncrossedLines(new int[]{1, 3, 7, 1, 7, 5}, new int[]{1, 9, 2, 5, 1}));

	}

}
