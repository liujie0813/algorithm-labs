package com.timberliu.algorithm.leetcode.graph.island.no0200_2_islandNum;

/**
 * 200. 岛屿数量
 *
 * @user liujie
 * @date 2023/8/3
 */
public class Solution1 {

    private final int[][] direction = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(grid, i, j, m, n, visited);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private void dfs(char[][] grid, int x, int y, int m, int n, boolean[][] visited) {
        visited[x][y] = true;
        for (int[] r : direction) {
            int newX = x + r[0];
            int newY = y + r[1];
            if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY] && grid[newX][newY] == '1') {
                dfs(grid, newX, newY, m, n, visited);
            }
        }
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int res = solution1.numIslands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '1', '1'}
        });
        System.out.println(res);
    }

}
