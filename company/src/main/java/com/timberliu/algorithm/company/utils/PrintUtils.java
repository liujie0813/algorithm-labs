package com.timberliu.algorithm.company.utils;

import java.util.Deque;
import java.util.List;

/**
 * @author liujie
 * @date 2023/3/13
 */

public class PrintUtils {

	public static void printListInteger(List<Integer> list) {
		for (Integer val : list) {
			System.out.print(val + " ");
		}
		System.out.println();
	}

	public static void printListListInteger(List<List<Integer>> list) {
		for (List<Integer> list1 : list) {
			for (Integer val1 : list1) {
				System.out.print(val1 + ", ");
			}
			System.out.print("\t");
		}
		System.out.println();
	}

	public static void printListListIntegerV2(List<List<Integer>> list) {
		for (List<Integer> list1 : list) {
			for (Integer val1 : list1) {
				System.out.print(val1 + " ");
			}
			System.out.println();
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

	public static void printListString(List<String> list) {
		for (String str : list) {
			System.out.print(str + " ");
		}
		System.out.println();
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

	public static void printIntArray(int[] arr) {
		System.out.print("[");
		for (int val : arr) {
			System.out.print(val + ", ");
		}
		System.out.print("]\n");
	}

	public static void printBooleanArray(boolean[] arr) {
		System.out.print("[");
		for (boolean val : arr) {
			System.out.print(val + ", ");
		}
		System.out.print("]\n");
	}

	public static void printIntegerDeque(Deque<Integer> queue) {
		System.out.print("[");
		for (Integer val : queue) {
			System.out.print(val + ", ");
		}
		System.out.print("]\n");
	}

}
