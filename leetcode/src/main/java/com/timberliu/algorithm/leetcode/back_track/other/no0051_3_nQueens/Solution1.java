package com.timberliu.algorithm.leetcode.back_track.other.no0051_3_nQueens;

import com.timberliu.algorithm.leetcode.utils.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 51. N 皇后问题
 *   规则：皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子
 *   如何将 N 个皇后放置在 n*n 的棋盘上，并且使皇后彼此之间不能相互攻击
 *
 *   回溯：棋盘的宽度就是 for 循环的长度，棋盘的高度就是递归的深度
 */

public class Solution1 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] chessboard = new char[n][n];
        for (char[] chars : chessboard) {
            Arrays.fill(chars, '.');
        }
        backtrack(n, 0, chessboard, res);
        return res;
    }

    private void backtrack(int n, int row, char[][] chessboard, List<List<String>> res) {
        if (row == n) {
            res.add(transfer(chessboard));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(chessboard, row, col, n)) {
                chessboard[row][col] = 'Q';
                backtrack(n, row + 1, chessboard, res);
                chessboard[row][col] = '.';
            }
        }
    }

    private List<String> transfer(char[][] chessboard) {
        List<String> res = new ArrayList<>();
        for (char[] chars : chessboard) {
            res.add(new String(chars));
        }
        return res;
    }

    private boolean isValid(char[][] chessboard, int row, int col, int n) {
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 & j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 & j < n; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        List<List<String>> res = solution1.solveNQueens(4);
        PrintUtils.printListListString(res);

    }

}