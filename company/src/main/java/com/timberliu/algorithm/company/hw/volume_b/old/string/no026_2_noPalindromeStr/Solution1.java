package com.timberliu.algorithm.company.hw.volume_b.old.string.no026_2_noPalindromeStr;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 26. 没有回文串
 *
 *  下一个字典序、不包含回文串、字符都是前 N 个字母、且长度相同的字符串
 *
 * @author Timber
 * @date 2023/6/4
 */
public class Solution1 {

	public static String noPalindromeStr(String str, int n) {
		int[] arr = new int[str.length()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = str.charAt(i);
		}

		String res = dfs(arr, 0, true, 97 + n - 1, new ArrayList<>());
		if (res == null) {
			return "NO";
		}
		return res;
	}

	private static String dfs(int[] arr, int index, boolean limit, int max, List<Integer> path) {
		if (index == arr.length) {
			StringBuilder sb = new StringBuilder();
			for (Integer val : path) {
				sb.append((char) ((int) val));
			}
			return sb.toString();
		}

		int min = limit ? arr[index] : 97;
		for (int i = min; i <= max; i++) {
			// 跳过原始字符串
			if (index == arr.length - 1 && limit && i == min) {
				continue;
			}
			if (index > 0 && i == path.get(index - 1)) {
				continue;
			}
			if (index > 1 && i == path.get(index - 2)) {
				continue;
			}
			path.add(i);
			String res = dfs(arr, index + 1, limit && i == min, max, path);
			if (res != null) {
				return res;
			}
			path.remove(path.size() - 1);
		}
		return null;
	}

	/**
	 * 4
	 * bacd
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		String str = scanner.nextLine();

		String res = noPalindromeStr(str, n);
		System.out.println(res);
	}

}
