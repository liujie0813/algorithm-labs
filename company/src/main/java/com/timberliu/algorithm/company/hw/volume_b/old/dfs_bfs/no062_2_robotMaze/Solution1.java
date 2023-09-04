package com.timberliu.algorithm.company.hw.volume_b.old.dfs_bfs.no062_2_robotMaze;

import java.util.Scanner;

/**
 * @user liujie
 * @date 2023/9/4
 */
public class Solution1 {

    public static String robotMaze(int width, int height, int[][] walls) {

        int[][] matrix = new int[height][width];
        for (int[] wall : walls) {
            // 墙壁标为 1
            matrix[wall[1]][wall[0]] = 1;
        }

        if (dfs(matrix, height, width, 0, 0)) {
            matrix[0][0] = 2;
        }
        int trap = 0;
        int notArrive = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == 0) {
                    notArrive++;
                } else if (matrix[i][j] == 3) {
                    trap++;
                }
            }
        }
        return trap + " " + notArrive;
    }

    private static boolean dfs(int[][] matrix, int n, int m, int i, int j) {
        if (i == n || j == m) {
            return false;
        }
        if (i == n - 1 && j == m - 1) {
            matrix[i][j] = 2;
            return true;
        }
        boolean arrive = false;
        if (i + 1 < n && matrix[i + 1][j] != 1) {
            if (dfs(matrix, n, m, i + 1, j)) {
                matrix[i][j] = 2;
                arrive = true;
            }
        }
        if (j + 1 < m && matrix[i][j + 1] != 1) {
            if (dfs(matrix, n, m, i, j + 1)) {
                matrix[i][j] = 2;
                arrive = true;
            }
        }
        if (!arrive) {
            matrix[i][j] = 3;
        }
        return arrive;
    }

    /**
     * 6 4
     * 5
     * 0 2
     * 1 2
     * 2 2
     * 4 1
     * 5 1
     */
    /**
     * 6 4
     * 4
     * 2 0
     * 2 1
     * 3 0
     * 3 1
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }

        String res = robotMaze(x, y, arr);
        System.out.println(res);
    }

}
