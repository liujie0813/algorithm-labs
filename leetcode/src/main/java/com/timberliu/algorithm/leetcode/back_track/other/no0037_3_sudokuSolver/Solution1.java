package com.timberliu.algorithm.leetcode.back_track.other.no0037_3_sudokuSolver;

import java.util.Arrays;

/**
 * 37. 解数独
 *
 *   如何快速判断是否应该使用 DFS + 回溯？
 *     1. 求所有方案，而不是方案数
 *     2. 通常数据范围不会太大，只有几十。
 *
 * @author Timber
 * @date 2021/10/31
 */
public class Solution1 {

	// 记录行是否有某个值
	boolean[][] row;
	// 记录列是否有某个值
	boolean[][] col;
	// 记录 3*3 宫内是否有某个值
	boolean[][][] cell;

	public void solveSudoku(char[][] board) {
		// 记录行是否有某个值
		row = new boolean[9][9];
		// 记录列是否有某个值
		col = new boolean[9][9];
		// 记录 3*3 宫内是否有某个值
		 cell = new boolean[3][3][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					int tmp = board[i][j] - '1';
					row[i][tmp] = col[j][tmp] = cell[i / 3][j / 3][tmp] = true;
				}
			}
		}
		dfs(board, 0, 0);
	}

	private boolean dfs(char[][] board, int x, int y) {
		if (y == 9) {
			return dfs(board, x + 1, 0);
		}
		if (x == 9) {
			return true;
		}
		// 已经有数字，判断下一个
		if (board[x][y] != '.') {
			return dfs(board, x, y + 1);
		}
		// 从 1-9 挨个试
		for (int i = 0; i < 9; i++) {
			if (!row[x][i] && !col[y][i] && !cell[x / 3][y / 3][i]) {
				board[x][y] = (char)(i + '1');
				row[x][i] = col[y][i] = cell[x / 3][y / 3][i] = true;
				if (dfs(board, x, y + 1)) {
					return true;
				} else {
					board[x][y] = '.';
					row[x][i] = col[y][i] = cell[x / 3][y / 3][i] = false;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/sudoku-solver/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		char[][] char1 = {
				{'5', '3', '.',   '.', '7', '.',  '.', '.', '.'},
				{'6', '.', '.',   '1', '9', '5',  '.', '.', '.'},
				{'.', '9', '8',   '.', '.', '.',  '.', '6', '.'},

				{'8', '.', '.',   '.', '6', '.',  '.', '.', '3'},
				{'4', '.', '.',   '8', '.', '3',  '.', '.', '1'},
				{'7', '.', '.',   '.', '2', '.',  '.', '.', '6'},

				{'.', '6', '.',   '.', '.', '.',  '2', '8', '.'},
				{'.', '.', '.',   '4', '1', '9',  '.', '.', '5'},
				{'.', '.', '.',   '.', '8', '.',  '.', '7', '9'}
		};
		solution1.solveSudoku(char1);
		for (char[] chars : char1) {
			System.out.println(Arrays.toString(chars));
		}

		System.out.println("----- 1 -----");
		char[][] char2 = {
				{'.', '.', '.',   '3', '.', '.',  '.', '.', '8'},
				{'5', '3', '.',   '7', '.', '.',  '.', '.', '4'},
				{'.', '.', '4',   '.', '.', '8',  '2', '.', '9'},

				{'.', '5', '1',   '.', '.', '.',  '.', '.', '.'},
				{'.', '9', '.',   '.', '.', '.',  '.', '8', '.'},
				{'.', '.', '.',   '.', '.', '.',  '3', '5', '.'},

				{'4', '.', '7',   '8', '.', '.',  '6', '.', '.'},
				{'6', '.', '.',   '.', '.', '2',  '.', '1', '7'},
				{'3', '.', '.',   '.', '.', '4',  '.', '.', '.'}
		};
		solution1.solveSudoku(char2);
		for (char[] chars : char2) {
			System.out.println(Arrays.toString(chars));
		}

	}

}
