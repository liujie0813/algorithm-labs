package com.timberliu.algorithm.company.hw.volume_a.stack_queue.no130_2_mostProductNum;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 130. 天然货仓
 *
 * @author liujie
 * @date 2023/5/5
 */

public class Solution1 {

	public static int mostProductNum(int[] arr, int product) {
		int[] newArr = new int[arr.length + 2];
		// 不同于接雨水，这里边界可能为负数，也可以放货物
		// 左右边界加 0
		System.arraycopy(arr, 0, newArr, 1, arr.length);

		// 单调递减栈（存下标）
		Deque<Integer> stack = new LinkedList<>();
		int res = 0;
		for (int i = 0; i < newArr.length; i++) {
			// 栈顶为负数，且当前元素大于栈顶，要出栈
			// 货物堆积高度不能大于 0
			while (!stack.isEmpty() && newArr[stack.peek()] < 0 && newArr[i] > newArr[stack.peek()]) {
				int midIndex = stack.pop();
				if (stack.isEmpty()) {
					break;
				}
				int midDepth = newArr[midIndex];
				int leftIndex = stack.peek();
				int leftDepth = newArr[leftIndex];
				// 深度，装几层（货品高度为 1）
				int depth = Math.min(leftDepth, newArr[i]) - midDepth;
				// 宽度，装几列
				res += (i - leftIndex - 1) / product * depth;
			}
			stack.push(i);
		}
		return res;
	}

	/*
	 * 2
	 * 4
	 * 0,-1,-2,0
	 */
	/**
	 * 	2
	 * 	8
	 * 	0,-1,-2,-2,-1,1,-1,-1
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int product = scanner.nextInt();
		int n = scanner.nextInt();
		scanner.nextLine();
		int[] arr = new int[n];
		String[] strs = scanner.nextLine().split(",");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(strs[i]);
		}

		int res = mostProductNum(arr, product);
		System.out.println(res);
	}

}
