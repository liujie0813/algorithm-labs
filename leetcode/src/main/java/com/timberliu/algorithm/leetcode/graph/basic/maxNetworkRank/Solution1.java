package com.timberliu.algorithm.leetcode.graph.basic.maxNetworkRank;

/**
 * 1615. 最大网络秩
 *
 * @user liujie
 * @date 2023/8/4
 */
public class Solution1 {

    public int maximalNetworkRank(int n, int[][] roads) {
        int[] inDegree = new int[n];
        boolean[][] connected = new boolean[n][n];
        for (int[] road : roads) {
            int x = road[0];
            int y = road[1];
            inDegree[x]++;
            inDegree[y]++;
            connected[x][y] = true;
            connected[y][x] = true;
        }

        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (connected[i][j]) {
                    max = Math.max(max, inDegree[i] + inDegree[j] - 1);
                } else {
                    max = Math.max(max, inDegree[i] + inDegree[j]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int res = solution1.maximalNetworkRank(5, new int[][]{
                {0, 1}, {0, 3}, {1, 2}, {1, 3}, {2, 3}, {2, 4}
        });
        System.out.println(res);
    }

}
