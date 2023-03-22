package com.timberliu.algorithm.leetcode.utils;

import java.util.List;

/**
 * @author liujie
 * @date 2023/3/13
 */

public class PrintUtils {

	public static void printListListInteger(List<List<Integer>> list) {
		for (List<Integer> list1 : list) {
			for (Integer val1 : list1) {
				System.out.print(val1 + ", ");
			}
			System.out.print("\t");
		}
		System.out.println();
	}

	public static void printListListString(List<List<String>> list) {
		for (List<String> sub : list) {
			for (String str : sub) {
				System.out.println(str);
			}
			System.out.println();
		}
	}

	public static void printIntArray(int[][] arr) {
		for (int[] a : arr) {
			System.out.print("[");
			for (int val : a) {
				System.out.print(val + ", ");
			}
			System.out.print("]\n");
		}
		System.out.println();
	}

}
