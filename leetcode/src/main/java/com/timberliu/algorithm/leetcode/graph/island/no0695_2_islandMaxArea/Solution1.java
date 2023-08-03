package com.timberliu.algorithm.leetcode.graph.island.no0695_2_islandMaxArea;

/**
 * @user liujie
 * @date 2023/8/3
 */
public class Solution1 {

    private final int[][] direction = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    int val = dfs(grid, i, j, m, n, visited);
                    res = Math.max(res, val);
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int x, int y, int m, int n, boolean[][] visited) {
        visited[x][y] = true;
        int cur = 1;
        for (int[] r : direction) {
            int newX = x + r[0];
            int newY = y + r[1];
            if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY] && grid[newX][newY] == 1) {
                cur += dfs(grid, newX, newY, m, n, visited);
            }
        }
        return cur;
    }


    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int res = solution1.maxAreaOfIsland(new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 1, 1}
        });
        System.out.println(res);
    }


}
