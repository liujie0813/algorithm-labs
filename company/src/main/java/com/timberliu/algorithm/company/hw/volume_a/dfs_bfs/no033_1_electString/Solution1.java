package com.timberliu.algorithm.company.hw.volume_a.dfs_bfs.no033_1_electString;

import java.util.Scanner;

/**
 * 33. 挑选字符串
 *
 *   同时挑选
 *
 * @author liujie
 * @date 2023/4/25
 */

public class Solution1 {

	public static int electString(String first, String second) {
		int res = 0;
		boolean[] used = new boolean[first.length()];
		for (int i = 0; i <= first.length() - second.length(); i++) {
			if (first.charAt(i) == second.charAt(0) && !used[i]) {
				if (dfs(first, i, new StringBuilder(), used, second)) {
					res++;
				}
			}
		}
		return res;
	}

	private static boolean dfs(String first, int index, StringBuilder path, boolean[] used, String second) {
		path.append(first.charAt(index));
		used[index] = true;
		if (path.toString().equals(second)) {
			return true;
		}
		char secondChar = second.charAt(path.length());
		for (int i = index + 1; i < first.length(); i++) {
			char firstChar = first.charAt(i);
			if (firstChar == secondChar && !used[i]) {
				if (dfs(first, i, path, used, second)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * bbadcac
	 * bac
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String first = scanner.nextLine();
		String second = scanner.nextLine();
		int res = electString(first, second);
		System.out.println(res);
	}

}
