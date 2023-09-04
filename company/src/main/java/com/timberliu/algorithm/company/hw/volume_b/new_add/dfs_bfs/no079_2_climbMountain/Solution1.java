package com.timberliu.algorithm.company.hw.volume_b.new_add.dfs_bfs.no079_2_climbMountain;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

/**
 * 周末爬山
 *
 * @user liujie
 * @date 2023/9/4
 */
public class Solution1 {

    private static final int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    public static String climeMountain(int[][] arr, int m, int n, int k) {

        boolean[][] visited = new boolean[m][n];
        Deque<int[]> deque = new LinkedList<>();
        deque.offer(new int[]{0, 0});
        int maxHeight = 0;
        int step = 0;

        int level = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int[] poll = deque.poll();
                int x = poll[0], y = poll[1];
                visited[x][y] = true;
                if (arr[x][y] > maxHeight) {
                    maxHeight = arr[x][y];
                    step = level;
                }
                for (int[] direction : directions) {
                    int newX = x + direction[0];
                    int newY = y + direction[1];
                    if (newX < 0 || newX >= m || newY < 0 || newY >= n ||
                            visited[newX][newY] || Math.abs(arr[newX][newY] - arr[x][y]) > k) {
                        continue;
                    }
                    deque.offer(new int[]{newX, newY});
                }
            }
            level++;
        }
        return maxHeight + " " + step;
    }

    /**
     * 5 4 1
     * 0 1 2 0
     * 1 0 0 0
     * 1 0 1 2
     * 1 3 1 0
     * 0 0 0 9
     */
    /**
     * 5 4 3
     * 0 0 0 0
     * 0 0 0 0
     * 0 9 0 0
     * 0 0 0 0
     * 0 0 0 9
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        String res = climeMountain(arr, m, n, k);
        System.out.println(res);
    }

}
