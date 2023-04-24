package com.timberliu.algorithm.company.hw.sliding_window.no043_2_worstProduct;

import com.timberliu.algorithm.company.utils.PrintUtils;

import java.util.*;

/**
 * 43. 最差产品奖
 *
 * @author Timber
 * @date 2023/4/24
 */
public class Solution1 {

	public static List<Integer> worstProduct(int[] arr, int m) {
		List<Integer> res = new ArrayList<>();
		Deque<Integer> deque = new LinkedList<>();
		for (int i = 0; i < arr.length; i++) {
			while (!deque.isEmpty() && deque.peekLast() > arr[i]) {
				deque.pollLast();
			}
			deque.offerLast(arr[i]);
			if (i >= m - 1) {
				res.add(deque.peekFirst());
				if (deque.peekFirst() == arr[i - m + 1]) {
					deque.pollFirst();
				}
			}
		}
		return res;
	}

	/**
	 * 3
	 * 12,3,8,6,5
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = Integer.parseInt(scanner.nextLine());
		String[] strs = scanner.nextLine().split(",");
		int[] arr = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			arr[i] = Integer.parseInt(strs[i]);
		}

		List<Integer> res = worstProduct(arr, m);
		PrintUtils.printListInteger(res);
	}

}
