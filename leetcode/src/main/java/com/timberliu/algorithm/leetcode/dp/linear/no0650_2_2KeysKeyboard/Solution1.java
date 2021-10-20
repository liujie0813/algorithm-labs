package com.timberliu.algorithm.leetcode.dp.linear.no0650_2_2KeysKeyboard;

/**
 * TODO
 *
 * 650. 只有两个键的键盘
 *
 *  状态定义：f[i][j] 考虑为当前记事本上有 i 个字符，剪切板上有 j 个字符时的最小操作次数
 *
 *  f[i][j] 如何转移：
 *    1. 最后一次操作是 Paste：f[i][j] = f[i-j][j] + 1
 *    2. 最后一次操作是 Copy All：f[i][j] = min(f[i][x] + 1), 0 <= x < i
 *
 *   最后一个合法的 f[i][j]（i = j）依赖于前面的 f[i][j]（i < j）
 *
 *   在实现上，可以使用一个变量 min 保存前面转移的最小值，用于更新最后的 f[i][j]
 *
 *   如果 f[i][j] 最后一次操作是 Paste，原来粘贴板的字符不会超过 i/2，因此在转移 f[i][j]（满足 j < i）时，只需要枚举 [0, i/2]
 *
 * @author Timber
 * @date 2021/10/19
 */
public class Solution1 {
	int INF = 0x3f3f3f3f;

	public int minSteps(int n) {
		int[][] dp = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j < n; j++) {
				dp[i][j] = INF;
			}
		}
		dp[1][0] = 0; dp[1][1] = 1;

		for (int i = 2; i <= n; i++) {
			int min = INF;
			for (int j = 0; j <= i / 2; j++) {
				dp[i][j] = dp[i - j][j] + 1;
				min = Math.min(min, dp[i][j]);
			}
			dp[i][i] = min + 1;
		}
		int res = INF;
		for (int i = 0; i <= n; i++) {
			res = Math.min(res, dp[n][i]);
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/2-keys-keyboard/ -----");
		System.out.println("----- 1 -----");

	}

}
