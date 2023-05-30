package com.timberliu.algorithm.company.hw.volume_b.new_add.stack_queue.no022_2_goldBoxIV;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 22. 阿里巴巴找黄金宝箱 IV
 *
 *  维护单调栈递减
 *    栈顶元素小于当前元素时，弹出栈顶元素
 *    此时栈顶元素的下一个更大的元素就是当前元素
 *
 *  环：再遍历一遍，或者数组延伸为两倍
 *
 * @author liujie
 * @date 2023/5/30
 */

public class Solution1 {

	public static int[] goldBoxIV(int[] arr) {
		int[] res = new int[arr.length];
		Arrays.fill(res, -1);
		// 栈底到栈顶 单调递减
		Deque<Integer> stack = new LinkedList<>();
		nextGreaterEle(arr, stack, res);
		if (!stack.isEmpty()) {
			nextGreaterEle(arr, stack, res);
		}
		return res;
	}

	private static void nextGreaterEle(int[] arr, Deque<Integer> stack, int[] res) {
		for (int i = 0; i < arr.length; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				Integer poll = stack.pop();
				res[poll] = arr[i];
			}
			stack.push(i);
		}
	}

	/**
	 * 3,4,5,6,3
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] splits = scanner.nextLine().split(",");
		int[] arr = new int[splits.length];
		for (int i = 0; i < splits.length; i++) {
			arr[i] = Integer.parseInt(splits[i]);
		}
		int[] res = goldBoxIV(arr);
		System.out.println(Arrays.toString(res));
	}

}
