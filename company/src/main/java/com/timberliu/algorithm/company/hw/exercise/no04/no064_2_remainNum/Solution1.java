package com.timberliu.algorithm.company.hw.exercise.no04.no064_2_remainNum;

import java.util.*;

/**
 * @author Timber
 * @date 2023/6/18
 */
public class Solution1 {

	public static List<Integer> remainNum(int[] arr) {
		Deque<Integer> stack = new LinkedList<>();
		Deque<Integer> cache = new LinkedList<>();
		int index = 0;
		int cur = arr[0];
		while (true) {
			int sum = 0;
			while (!stack.isEmpty() && sum < cur) {
				Integer peek = stack.pop();
				sum += peek;
				cache.push(peek);
			}
			if (sum == cur) {
				cur = sum * 2;
				cache.clear();
			} else {
				while (!cache.isEmpty()) {
					stack.push(cache.pop());
				}
				stack.push(cur);
				if (++index == arr.length) {
					break;
				}
				cur = arr[index];
			}
		}
		return new ArrayList<>(stack);
	}

	/**
	 * 5 10 20 50 85 1
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] splits = scanner.nextLine().split(" ");
		int[] arr = new int[splits.length];
		for (int i = 0; i < splits.length; i++) {
			arr[i] = Integer.parseInt(splits[i]);
		}

		List<Integer> res = remainNum(arr);
		for (Integer val : res) {
			System.out.print(val + " ");
		}
	}

}
