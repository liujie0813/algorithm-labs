package com.timberliu.algorithm.leetcode.graph.island.no0463_2_islandPerimeter;

/**
 * @user liujie
 * @date 2023/8/3
 */
public class Solution1 {

    private final int[][] direction = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    public int islandPerimeter(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j, m, n, visited);
                }
            }
        }
        return 0;
    }

    private int dfs(int[][] grid, int x, int y, int m, int n, boolean[][] visited) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return 1;
        }
        if (visited[x][y]) {
            return 0;
        }
        if (grid[x][y] == 0) {
            return 1;
        }
        visited[x][y] = true;
        int res = 0;
        for (int[] r : direction) {
            int newX = x + r[0];
            int newY = y + r[1];
            res += dfs(grid, newX, newY, m, n, visited);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int res = solution1.islandPerimeter(new int[][]{
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        });
        System.out.println(res);
    }


}
