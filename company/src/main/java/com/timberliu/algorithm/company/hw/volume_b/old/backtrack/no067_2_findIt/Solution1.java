package com.timberliu.algorithm.company.hw.volume_b.old.backtrack.no067_2_findIt;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 找到它 单词搜索
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

    public static String findIt(char[][] arr, String word) {
        int n = arr.length, m = arr[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (backtrack(arr, i, j, word, 0, new boolean[n][m])) {
                    return (i + 1) + " " + (j + 1);
                }
            }
        }
        return "NO";
    }

    private static boolean backtrack(char[][] arr, int i, int j, String word, int index, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (arr[i][j] != word.charAt(index)) {
            return false;
        }
        for (int[] direction : directions) {
            int newI = i + direction[0];
            int newJ = j + direction[1];
            if (newI < 0 || newI >= arr.length || newJ < 0 || newJ >= arr[0].length) {
                continue;
            }
            visited[i][j] = true;
            if (backtrack(arr, newI, newJ, word, index + 1, visited)) {
                return true;
            }
            visited[i][j] = false;
        }
        return false;
    }

    /**
     * 5 5
     * helloworld
     * cpucy
     * eklqh
     * chell
     * lrowo
     * dgrbc
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        String word = scanner.nextLine();
        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            String str = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        String res = findIt(arr, word);
        System.out.println(res);
    }

}
