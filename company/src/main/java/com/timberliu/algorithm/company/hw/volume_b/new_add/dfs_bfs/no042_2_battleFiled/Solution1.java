package com.timberliu.algorithm.company.hw.volume_b.new_add.dfs_bfs.no042_2_battleFiled;

import java.util.Scanner;

/**
 * 战场索敌
 *
 * @user liujie
 * @date 2023/9/4
 */
public class Solution1 {

    public static int battleFieldNum(char[][] arr, int n, int m, int k) {
        int res = 0;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && (arr[i][j] == 'E' || arr[i][j] == '.')) {
                    int cnt = dfs(arr, n, m, i, j, visited);
                    if (cnt >= k) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    private static final int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    private static int dfs(char[][] arr, int n, int m, int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        if (arr[i][j] != '.' && arr[i][j] != 'E') {
            return 0;
        }
        int res = 0;
        if (arr[i][j] == 'E') {
            res++;
        }
        for (int[] direction : directions) {
            int newI = i + direction[0];
            int newJ = j + direction[1];
            if (newI >= 0 && newI < n && newJ >= 0 && newJ < m && !visited[newI][newJ]) {
                res += dfs(arr, n, m, newI, newJ, visited);
            }
        }
        return res;
    }

    /**
     * 3 5 3
     * E.#.E
     * E.#E.
     * ###.E
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();
        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        int res = battleFieldNum(arr, n, m, k);
        System.out.println(res);
    }

}
