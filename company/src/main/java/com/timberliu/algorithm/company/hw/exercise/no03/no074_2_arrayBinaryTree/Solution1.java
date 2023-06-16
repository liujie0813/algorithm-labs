package com.timberliu.algorithm.company.hw.exercise.no03.no074_2_arrayBinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 74. 数组二叉树
 *
 * @author liujie
 * @date 2023/6/16
 */

public class Solution1 {

	public static List<Integer> arrayBinaryTree(int[] arr) {
		List<Integer>[] res = new ArrayList[1];
		dfs(arr, 1, new ArrayList<>(), res);
		return res[0];
	}

	private static void dfs(int[] arr, int root, List<Integer> curPath, List<Integer>[] res) {
		curPath.add(arr[root]);
		int m = root * 2;
		if (m >= arr.length || (m + 1 < arr.length && arr[m] == -1 && arr[m + 1] == -1) ) {
			if (res[0] == null || curPath.get(curPath.size() - 1) < res[0].get(res[0].size() - 1)) {
				res[0] = new ArrayList<>(curPath);
			}
			return;
		}
		if (arr[m] != -1) {
			dfs(arr, m, curPath, res);
			curPath.remove(curPath.size() - 1);
		}
		if (m + 1 < arr.length && arr[m + 1] != -1) {
			dfs(arr, m + 1, curPath, res);
			curPath.remove(curPath.size() - 1);
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
		String[] splits = scanner.nextLine().split(" ");
		int[] arr = new int[splits.length + 1];
		for (int i = 1; i <= splits.length; i++) {
			arr[i] = Integer.parseInt(splits[i - 1]);
		}

		List<Integer> res = arrayBinaryTree(arr);
		for (Integer a : res) {
			System.out.print(a + " ");
		}
	}

}
