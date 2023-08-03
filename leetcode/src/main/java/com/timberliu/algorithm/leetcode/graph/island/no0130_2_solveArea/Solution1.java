package com.timberliu.algorithm.leetcode.graph.island.no0130_2_solveArea;

/**
 * 130. 被围绕的区域
 *
 * @user liujie
 * @date 2023/8/3
 */
public class Solution1 {

    private final int[][] direction = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };


    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && board[i][j] == 'O') {
                    dfs(board, i, j, m, n);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] grid, int x, int y, int m, int n) {
        grid[x][y] = 'A';
        for (int[] r : direction) {
            int newX = x + r[0];
            int newY = y + r[1];
            if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 'O') {
                dfs(grid, newX, newY, m, n);
            }
        }
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        char[][] chars = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        solution1.solve(chars);
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[0].length; j++) {
                System.out.print(chars[i][j] + ", ");
            }
            System.out.println();
        }
    }

}
