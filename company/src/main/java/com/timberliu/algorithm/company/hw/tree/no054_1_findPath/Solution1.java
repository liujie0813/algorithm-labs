package com.timberliu.algorithm.company.hw.tree.no054_1_findPath;

import com.timberliu.algorithm.company.utils.PrintUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 54. 寻找路径
 *
 * @author Timber
 * @date 2023/4/24
 */
public class Solution1 {

	public static List<Integer> findPath(int[] arr) {
		int[] min = {Integer.MAX_VALUE};
		List<Integer>[] res = new ArrayList[1];
		dfs(arr, 0, new ArrayList<>(), min, res);
		return res[0];
	}

	private static void dfs(int[] arr, int index, List<Integer> cur, int[] min, List<Integer>[] res) {
		boolean hasLeft = index * 2 + 1 < arr.length && arr[index * 2 + 1] != -1;
		boolean hasRight = index * 2 + 2 < arr.length && arr[index * 2 + 2] != -1;
		if (!hasLeft && !hasRight) {
			if (arr[index] < min[0]) {
				min[0] = arr[index];
				res[0] = new ArrayList<>(cur);
				res[0].add(arr[index]);
			}
			return;
		}

		if (hasLeft) {
			// 有左子节点
			cur.add(arr[index]);
			dfs(arr, index * 2 + 1, cur, min, res);
			cur.remove(cur.size() - 1);
		}
		if (hasRight) {
			// 有右子节点
			cur.add(arr[index]);
			dfs(arr, index * 2 + 2, cur, min, res);
			cur.remove(cur.size() - 1);
		}
	}

	/*
	 * 3 5 7 -1 -1 2 4
	 */
	/**
	 * 5 9 8 -1 -1 7 -1 -1 -1 -1 -1 6
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] strs = scanner.nextLine().split(" ");
		int[] arr = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			arr[i] = Integer.parseInt(strs[i]);
		}

		List<Integer> res = findPath(arr);
		PrintUtils.printListInteger(res);
	}

}
