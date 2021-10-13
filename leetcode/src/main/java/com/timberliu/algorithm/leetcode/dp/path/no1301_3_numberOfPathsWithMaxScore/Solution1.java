package com.timberliu.algorithm.leetcode.dp.path.no1301_3_numberOfPathsWithMaxScore;

import java.util.Arrays;
import java.util.List;

/**
 * 1301. 最大得分的路径数目
 *
 *   状态定义：f(i) 为从起点到 i 的最大得分
 *
 *   状态转义方程：f[(x, y)] = max(f[(x + 1, y)], f[(x, y + 1)], f[(x + 1, y + 1)]) + board[x][y]
 *
 *   使用 g[] 存储方案数
 *
 * @author liujie
 * @date 2021/10/13
 */

public class Solution1 {

	int mod = 1000000007;
	int n;
	int INF = -10;

	public int[] pathsWithMaxScore(List<String> boardList) {
		n = boardList.size();
		char[][] board = new char[n][n];
		for (int i = 0; i < n; i++) {
			board[i] = boardList.get(i).toCharArray();
		}
		int[][] dirs = new int[][]{{1, 0}, {0, 1}, {1, 1}};

		// 最大得分
		int[] f = new int[n * n];
		// 最大方案数
		int[] g = new int[n * n];
		for (int i = n - 1; i >= 0; --i) {
			for (int j = n - 1; j >= 0; --j) {
				int idx = getIndex(i, j);
				// 起点：方案数=1
				if (i == n - 1 && j == n - 1) {
					g[idx] = 1;
					continue;
				}

				// 障碍物跳过
				if (board[i][j] == 'X') {
					f[idx] = INF;
					continue;
				}

				// 当前位置的分数
				int val = (i == 0 && j == 0) ? 0 : board[i][j] - '0';

				// u 当前位置的最大得分，t 当前位置的最大得分的方案数
				int curMaxScore = INF, curMaxCnt = 0;
				// 计算得分和方案数
				for (int[] dir : dirs) {
					int nx = dir[0] + i, ny = dir[1] + j;
					if (nx < n && ny < n) {
						int curScore = f[getIndex(nx, ny)] + val;
						int curCnt = g[getIndex(nx, ny)];
						// 更新得分或方案数
						int[] res = update(curScore, curCnt, curMaxScore, curMaxCnt);
						curMaxScore = res[0]; curMaxCnt = res[1];
					}
				}

				f[idx] = curMaxScore < 0 ? INF : curMaxScore;
				g[idx] = curMaxCnt;
			}
		}

		int[] res = new int[2];
		res[0] = f[getIndex(0, 0)] == INF ? 0 :  f[getIndex(0, 0)];
		res[1] = g[getIndex(0, 0)] == INF ? 0 :  g[getIndex(0, 0)];
		return res;
	}

	private int[] update(int cur, int cnt, int u, int t) {
		int[] ans = new int[]{u, t};
		// 最大得分大了
		if (cur > u) {
			// 更新最大得分，及其方案数
			ans[0] = cur;
			ans[1] = cnt;
		} else if (cur == u && cur != INF) {
			// 如果最大得分相等，增加 方案数
			ans[1] += cnt;
		}
		ans[1] %= mod;
		return ans;
	}

	private int getIndex(int x, int y) {
		return x * n + y;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/number-of-paths-with-max-score/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		int[] res1 = solution1.pathsWithMaxScore(Arrays.asList("E23", "2X2", "12S"));
		System.out.println(Arrays.toString(res1));

		System.out.println("----- 2 -----");
		int[] res2 = solution1.pathsWithMaxScore(Arrays.asList("E12","1X1","21S"));
		System.out.println(Arrays.toString(res2));

		System.out.println("----- 3 -----");
		int[] res3 = solution1.pathsWithMaxScore(Arrays.asList("E11","XXX","11S"));
		System.out.println(Arrays.toString(res3));

		System.out.println("----- 4 -----");
		int[] res4 = solution1.pathsWithMaxScore(Arrays.asList("E99","XXX","11S"));
		System.out.println(Arrays.toString(res4));

	}

}
