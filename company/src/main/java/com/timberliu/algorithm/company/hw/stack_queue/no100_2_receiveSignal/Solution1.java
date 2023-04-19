package com.timberliu.algorithm.company.hw.stack_queue.no100_2_receiveSignal;

import com.timberliu.algorithm.company.utils.PrintUtils;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 100. 信号发射与接收
 *
 *  分别计算东向-南向信号接收
 *
 *  使用单调递减栈（维护栈顶元素最小）
 *   1. 当前元素大于栈顶，res[i][j]++，弹出栈顶元素，继续判断栈顶元素
 *   2. 当前元素等于栈顶，res[i][j]++，弹出栈顶元素，跳出
 *   3. 当前元素小于栈顶，res[i][j]++，跳出
 *
 * @author liujie
 * @date 2023/4/17
 */

public class Solution1 {

	public static int[][] receiveSignal(int[][] arr) {
		int m = arr.length, n = arr[0].length;

		int[][] res = new int[m][n];
		for (int i = 0; i < m; i++) {
			Deque<Integer> queue = new LinkedList<>();
			queue.addLast(arr[i][0]);
			for (int j = 1; j < n; j++) {
				while (!queue.isEmpty()) {
					if (arr[i][j] > queue.getLast()) {
						res[i][j]++;
						queue.removeLast();
						continue;
					}

					if (arr[i][j] == queue.getLast()) {
						res[i][j]++;
						queue.removeLast();
					} else {
						res[i][j]++;
					}
					break;
				}
				queue.addLast(arr[i][j]);
			}
		}

		for (int j = 0; j < n; j++) {
			Deque<Integer> queue = new LinkedList<>();
			queue.addLast(arr[0][j]);
			for (int i = 1; i < m; i++) {
				while (!queue.isEmpty()) {
					if (arr[i][j] > queue.getLast()) {
						res[i][j]++;
						queue.removeLast();
						continue;
					}

					if (arr[i][j] == queue.getLast()) {
						res[i][j]++;
						queue.removeLast();
					} else {
						res[i][j]++;
					}
					break;
				}
				queue.addLast(arr[i][j]);
			}
		}

		return res;
	}

	/*
	 * 1 6
	 * 2 4 1 5 3 3
	 */
	/**
	 * 2 6
	 * 2 5 4 3 2 8 9 7 5 10 10 3
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		int[][] arr = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = scanner.nextInt();
			}
		}

		int[][] res = receiveSignal(arr);
		System.out.println(m + " " + n);
		PrintUtils.printIntArray(res);
	}

}
