package com.timberliu.algorithm.leetcode.utils;

import java.util.List;

/**
 * @author liujie
 * @date 2023/3/13
 */

public class PrintUtils {

	public static void printListList(List<List<Integer>> list) {
		for (List<Integer> list1 : list) {
			for (Integer val1 : list1) {
				System.out.print(val1 + ", ");
			}
			System.out.print("\t");
		}
		System.out.println();
	}

}
