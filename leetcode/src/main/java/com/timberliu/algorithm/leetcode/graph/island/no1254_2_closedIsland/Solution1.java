package com.timberliu.algorithm.leetcode.graph.island.no1254_2_closedIsland;

/**
 * @user liujie
 * @date 2023/8/3
 */
public class Solution1 {

    private final int[][] direction = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    public int closedIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 0) {
                     if (dfs(grid, i, j, m, n, visited)) {
                         res++;
                     }
                }
            }
        }
        return res;
    }

    private boolean dfs(int[][] grid, int x, int y, int m, int n, boolean[][] visited) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return false;
        }
        if (visited[x][y] || grid[x][y] == 1) {
            return true;
        }
        visited[x][y] = true;
        for (int[] r : direction) {
            int newX = x + r[0];
            int newY = y + r[1];
            if (!dfs(grid, newX, newY, m, n, visited)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int res = solution1.closedIsland(new int[][]{
                {0, 1, 0, 1, 1},
                {1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0},
                {0, 1, 1, 1, 0}
        });
        System.out.println(res);
    }


}
