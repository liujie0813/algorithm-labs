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

	public static void printListIntegerV2(List<Integer> list) {
		System.out.print("[");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
			if (i != list.size() - 1) {
				System.out.print(",");
			}
		}
		System.out.println("]");
	}

	public static void printListIntegerV3(List<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
			if (i != list.size() - 1) {
				System.out.print(",");
			}
		}
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

	public static void printListListIntegerV3(List<List<Integer>> list) {
		System.out.print("[");
		for (int i = 0; i < list.size(); i++) {
			System.out.print("[");
			for (int j = 0; j < list.get(i).size(); j++) {
				System.out.print(list.get(i).get(j));
				if (j != list.get(i).size() - 1) {
					System.out.print(", ");
				}
			}
			System.out.print("]");
			if (i != list.size() - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
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

	public static void printIntArrayV2(int[][] arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			System.out.print("[");
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]);
				if (j != arr[i].length - 1) {
					System.out.print(", ");
				}
			}
			System.out.print("]");
			if (i != arr.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}

	public static void printIntArray(int[] arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i < arr.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.print("]\n");
	}

	public static void printIntArrayV2(int[] arr) {
		for (int j : arr) {
			System.out.print(j + " ");
		}
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
