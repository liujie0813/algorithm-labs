package com.timberliu.algorithm.cracking.module16.no04_2_tictactoe;

/**
 * 面试题 16.04. 井字游戏
 *
 *
 *
 * @author liujie
 * @date 2021/8/22
 */

public class Solution1 {

    public String tictactoe(String[] board) {
        int diagonalSum = 0;
        int backDiagonalSum = 0;
        boolean hasSpace = false;

        for (int i = 0; i < board.length; i++) {
            int rowSum = 0;
            int colSum = 0;
            for (int j = 0; j < board.length; j++) {
                // 行 之和
                rowSum += board[i].charAt(j);
                // 列 之和
                colSum += board[j].charAt(i);
                if (board[i].charAt(j) == ' ') {
                    hasSpace = true;
                }
            }
            if (rowSum == 'X' * board.length || colSum == 'X' * board.length) {
                return "X";
            }
            if (rowSum == 'O' * board.length || colSum == 'O' * board.length) {
                return "O";
            }
            // 对角线 之和
            diagonalSum += board[i].charAt(i);
            backDiagonalSum += board[i].charAt(board.length - i - 1);
        }
        if (diagonalSum == 'X' * board.length || backDiagonalSum == 'X' * board.length) {
            return "X";
        }
        if (diagonalSum == 'O' * board.length || backDiagonalSum == 'O' * board.length) {
            return "O";
        }
        if (hasSpace) {
            return "Pending";
        } else {
            return "Draw";
        }
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/tic-tac-toe-lcci/ -----");
        Solution1 solution1 = new Solution1();
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
