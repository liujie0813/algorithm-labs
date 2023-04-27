package com.timberliu.algorithm.company.hw.greedy.no022_2_minLineNum;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 22. 区间交叠问题
 *
 * @author liujie
 * @date 2023/4/27
 */

public class Solution1 {

	public static int minLineNum(int[][] arr) {
		Arrays.sort(arr, (a, b) -> {
			if (a[0] == b[0]) {
				return b[1] - a[1];
			}
			return a[1] - b[1];
		});

		Deque<int[]> stack = new LinkedList<>();
		stack.push(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			int[] interval = arr[i];
			int curLeft = interval[0];
			int curRight = interval[1];

			while (true) {
				if (stack.isEmpty()) {
					stack.push(interval);
					break;
				}
				int[] peek = stack.peek();
				int lastLeft = peek[0];
				int lastRight = peek[1];

				if (curLeft <= lastLeft) {
					if (curRight <= lastRight) {
						break;
					} else {
						stack.pop();
					}
				} else if (curLeft < lastRight) {
					if (curRight <= lastRight) {
						break;
					} else {
						stack.push(new int[]{lastRight, curRight});
						break;
					}
				} else {
					stack.push(interval);
					break;
				}
			}
		}
		return stack.size();
	}

	/*
	 * 3
	 * 1,4
	 * 2,5
	 * 3,6
	 */
	/**
	 * 3
	 * 1,10
	 * 5,12
	 * 8,11
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			String[] splits = scanner.nextLine().split(",");
			arr[i][0] = Integer.parseInt(splits[0]);
			arr[i][1] = Integer.parseInt(splits[1]);
		}

		int res = minLineNum(arr);
		System.out.println(res);
	}

}
