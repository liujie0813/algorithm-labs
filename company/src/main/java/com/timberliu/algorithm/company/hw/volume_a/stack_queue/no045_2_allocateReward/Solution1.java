package com.timberliu.algorithm.company.hw.volume_a.stack_queue.no045_2_allocateReward;

import com.timberliu.algorithm.company.utils.PrintUtils;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 45. 分奖金
 *
 * @author liujie
 * @date 2023/4/24
 */

public class Solution1 {

	public static int[] allocateReward(int[] arr) {
		int[] res = new int[arr.length];
		Deque<Integer> stack = new LinkedList<>();
		for (int i = arr.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				res[i] = arr[i];
			} else {
				res[i] = (stack.peek() - i) * (arr[stack.peek()] - arr[i]);
			}
			stack.push(i);
		}
		return res;
	}

	/**
	 * 3
	 * 2 10 3
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}
		int[] res = allocateReward(arr);
		PrintUtils.printIntArrayV2(res);
	}

}
