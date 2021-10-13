package com.timberliu.algorithm.leetcode.dp.path.no0576_2_outOfBoundaryPaths;

/**
 * 576. 出界的路径数
 *
 *   将 (x, y) 映射成一个独立的 index
 *     index = (x * n) + y
 *     (x, y) = (index / n, index % n)
 *
 *   状态定义：f[i][j] 表示从 位置 i 出发，可用步数不超过 j 时的路径数量
 *
 *   状态转移方程：f[(x,y)][step] = f[(x-1,y)][step-1] +
 *                               f[(x+1,y)][step-1] +
 *                               f[(x,y-1)][step-1] +
 *                               f[(x,y+1)][step-1]
 *
 *      由于 f[i][j] 依赖于 f[][j - 1]，因此需要将最大移动步数 从小到大枚举
 *
 * @author liujie
 * @date 2021/10/13
 */

public class Solution1 {

	int mod = 1000000007;
	int col, maxStep;

	public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
		col = n; maxStep = maxMove;
		int[][] dp = new int[m * n][maxMove + 1];

		for (int j = 0; j < n; j++) {
			add(0, j, dp);
			add(m - 1, j, dp);
		}
		for (int i = 0; i < m; i++) {
			add(i, 0, dp);
			add(i, n - 1, dp);
		}

		int[][] dirs = new int[][]{
				{-1, 0}, {1, 0}, {0, -1}, {0, 1}
		};
		for (int step = 1; step <= maxMove; step++) {
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					int idx = getIndex(i, j);
					for (int[] dir : dirs) {
						int nextI = i + dir[0], nextJ = j + dir[1];
						if (nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n) {
							dp[idx][step] += dp[getIndex(nextI, nextJ)][step - 1];
							dp[idx][step] %= mod;
						}
					}
				}
			}
		}
		return dp[getIndex(startRow, startColumn)][maxMove];
	}

	private void add(int i, int j, int[][] dp) {
		int idx = getIndex(i, j);
		for (int step = 1; step <= maxStep; step++) {
			dp[idx][step]++;
		}
	}

	private int getIndex(int x, int y) {
		return x * col + y;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/out-of-boundary-paths/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		System.out.println(solution1.findPaths(2, 2, 2, 0, 0));

		System.out.println("----- 2 -----");
		System.out.println(solution1.findPaths(1, 3, 3, 0, 1));

	}

}
