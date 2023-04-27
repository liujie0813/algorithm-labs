package com.timberliu.algorithm.company.hw.back_track.no017_1_processor;

import com.timberliu.algorithm.company.utils.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 17. 处理器问题
 *
 * @author liujie
 * @date 2023/4/27
 */

public class Solution1 {

	public static List<List<Integer>> processor(int[] arr, int num) {
		Arrays.sort(arr);
		List<Integer> link1 = new ArrayList<>();
		List<Integer> link2 = new ArrayList<>();
		for (int val : arr) {
			if (val < 4) {
				link1.add(val);
			} else {
				link2.add(val);
			}
		}

		int size1 = link1.size();
		int size2 = link2.size();
		List<List<Integer>> res = new ArrayList<>();
		switch (num) {
			case 1:
				List<Integer> oneOrders = Arrays.asList(1, 3, 2, 4);
				for (Integer order : oneOrders) {
					if (size1 == order || size2 == order) {
						if (size1 == order) {
							dfs(link1, 0, 1, new ArrayList<>(), res);
						}
						if (size2 == order) {
							dfs(link2, 0, 1, new ArrayList<>(), res);
						}
						break;
					}
				}
				break;
			case 2:
				List<Integer> twoOrders = Arrays.asList(2, 4, 3);
				for (Integer order : twoOrders) {
					if (size1 == order || size2 == order) {
						if (size1 == order) {
							dfs(link1, 0, 2, new ArrayList<>(), res);
						}
						if (size2 == order) {
							dfs(link2, 0, 2, new ArrayList<>(), res);
						}
						break;
					}
				}
			case 4:
				if (size1 == 4) {
					res.add(link1);
				}
				if (size2 == 4) {
					res.add(link2);
				}
				break;
			case 8:
				if (size1 == 4 && size2 == 4) {
					link1.addAll(link2);
					res.add(link1);
				}
				break;
			default: break;
		}
		return res;
	}

	private static void dfs(List<Integer> links, int index, int num, List<Integer> path, List<List<Integer>> res) {
		if (path.size() == num) {
			res.add(new ArrayList<>(path));
			return;
		}
		for (int i = index; i < links.size(); i++) {
			path.add(links.get(i));
			dfs(links, i + 1, num, path, res);
			path.remove(path.size() - 1);
		}
	}

	/**
	 * [0, 1, 4, 5, 6, 7]
	 * 1
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String firstLine = scanner.nextLine();
		String[] splits = firstLine.substring(1, firstLine.length() - 1).split(", ");
		int[] arr = new int[splits.length];
		for (int i = 0; i < splits.length; i++) {
			arr[i] = Integer.parseInt(splits[i]);
		}
		int num = Integer.parseInt(scanner.nextLine());
		List<List<Integer>> res = processor(arr, num);
		PrintUtils.printListListIntegerV3(res);
	}

}
