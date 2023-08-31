package com.timberliu.algorithm.company.hw.volume_b.new_add.logic.no069_2_uprightFourChess;

import java.util.Scanner;

/**
 * 竖直四子棋
 *
 * @user liujie
 * @date 2023/8/31
 */
public class Solution1 {

    public static String fourChess(int row, int col, int[] arr) {
        int[] nextRow = new int[col];
        int[][] chessboard = new int[row][col];
        for (int i = 0; i < arr.length; i++) {
            // 1 表示红，2表示蓝
            int val = i % 2 + 1;
            int j = arr[i] - 1;
            if (j < 0 || j >= col || nextRow[j] == row) {
                return (i + 1) + ",error";
            }
            chessboard[nextRow[j]][j] = val;
            if (i >= 6 && check(chessboard, row, col, nextRow[j], j, val)) {
                return val == 1 ? (i + 1) + ",red" :  (i + 1) + ",blue";
            }
            nextRow[j]++;
        }
        return "0,draw";
    }

    private static boolean check(int[][] chessboard, int row, int col, int i, int j, int val) {
        int leftCnt = 0;
        while (j - leftCnt - 1 >= 0 && chessboard[i][j - leftCnt - 1] == val) {
            leftCnt++;
        }
        int rightCnt = 0;
        while (j + rightCnt + 1 < col && chessboard[i][j + rightCnt + 1] == val) {
            rightCnt++;
        }
        if (leftCnt + rightCnt + 1 >= 4) {
            return true;
        }

        int topCnt = 0;
        while (i - topCnt - 1 >= 0 && chessboard[i - topCnt - 1][j] == val) {
            topCnt++;
        }
        int bottomCnt = 0;
        while (i + bottomCnt + 1 < row && chessboard[i + bottomCnt + 1][j] == val) {
            bottomCnt++;
        }
        if (topCnt + bottomCnt + 1 >= 4) {
            return true;
        }

        int leftTopCnt = 0;
        while (i - leftTopCnt - 1 >= 0 && j - leftTopCnt - 1 >= 0 && chessboard[i - leftTopCnt - 1][j - leftTopCnt - 1] == val) {
            leftTopCnt++;
        }
        if (leftTopCnt + 1 >= 4) {
            return true;
        }

        int rightTopCnt = 0;
        while (i - rightTopCnt - 1 >= 0 && j + rightTopCnt + 1 < col && chessboard[i - rightTopCnt - 1][j + rightTopCnt + 1] == val) {
            rightTopCnt++;
        }
        if (rightTopCnt + 1 >= 4) {
            return true;
        }

        return false;
    }

    /*
     * 5 5
     * 1 1 2 2 3 3 4 4
     */
    /**
     * 6 5
     * 1 2 1 3 6 1 2 4 5 3 6 2 4 2 5 1 4
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width = scanner.nextInt();
        int height = scanner.nextInt();
        scanner.nextLine();
        String[] splits = scanner.nextLine().split(" ");
        int[] arr = new int[splits.length];
        for (int i = 0; i < splits.length; i++) {
            arr[i] = Integer.parseInt(splits[i]);
        }

        String res = fourChess(height, width, arr);
        System.out.println(res);
    }

}
