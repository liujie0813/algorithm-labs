package com.timberliu.algorithm.cracking.module16.no04_2_tictactoe;

/**
 * 面试题 16.04. 井字游戏
 *
 *
 *
 * @author liujie
 * @date 2021/8/22
 */

public class Solution2 {

    public String tictactoe(String[] board) {
        int n = board.length;
        boolean determined = false;
        // 检查行
        for (int i = 0; i < n; i++) {
            if (board[i].charAt(0) == ' ') {
                continue;
            }
            determined = true;
            for (int j = 0; j < n; j++) {
                if (board[i].charAt(j) != board[i].charAt(0)) {
                    determined = false;
                    break;
                }
            }
            if (determined) {
                return "" + board[i].charAt(0);
            }
        }
        // 检查列
        for (int j = 0; j < n; j++) {
            if (board[0].charAt(j) == ' ') {
                continue;
            }
            determined = true;
            for (int i = 0; i < n; i++) {
                if (board[i].charAt(j) != board[0].charAt(j)) {
                    determined = false;
                    break;
                }
            }
            if (determined) {
                return "" + board[0].charAt(j);
            }
        }
        // 检查对角线；左上-右下
        if (board[0].charAt(0) != ' ') {
            determined = true;
            for (int i = 1, j = 1; i < n && j < n; i++, j++) {
                if (board[i].charAt(j) != board[0].charAt(0)) {
                    determined = false;
                    break;
                }
            }
            if (determined) {
                return "" + board[0].charAt(0);
            }
        }
        // 检查对角线；左下-右上
        if (board[n - 1].charAt(0) != ' ') {
            determined = true;
            for (int i = n - 2, j = 1; i >= 0 && j < n; i--, j++) {
                if (board[i].charAt(j) != board[n - 1].charAt(0)) {
                    determined = false;
                    break;
                }
            }
            if (determined) {
                return "" + board[n - 1].charAt(0);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i].charAt(j) == ' ') {
                    return "Pending";
                }
            }
        }
        return "Draw";
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/tic-tac-toe-lcci/ -----");
        Solution2 solution1 = new Solution2();
        System.out.println("----- 1 -----");
        /*
         *  O X
         *   XO
         *  X O
         */
        System.out.println(solution1.tictactoe(new String[]{"O X"," XO","X O"}));

        System.out.println("----- 2 -----");
        /*
         *  OOX
         *  XXO
         *  OXO
         */
        System.out.println(solution1.tictactoe(new String[]{"OOX","XXO","OXO"}));

        System.out.println("----- 3 -----");
        /*
         *  OOX
         *  XXO
         *  OX
         */
        System.out.println(solution1.tictactoe(new String[]{"OOX","XXO","OX "}));

    }

}
