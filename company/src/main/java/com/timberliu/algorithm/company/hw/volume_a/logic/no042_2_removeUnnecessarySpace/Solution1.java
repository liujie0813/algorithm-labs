package com.timberliu.algorithm.company.hw.volume_a.logic.no042_2_removeUnnecessarySpace;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 42. 去除多余空格
 *
 * @author Timber
 * @date 2023/4/24
 */
public class Solution1 {

	public static String removeUnnecessarySpace(String str, int[][] keywords) {
		List<Integer> needDel = new ArrayList<>();
		boolean leftQuota = false;
		String[] strs = str.split("");
		for (int i = 0; i < strs.length; i++) {
			if (i > 0 && " ".equals(strs[i]) && " ".equals(strs[i - 1]) && !leftQuota) {
				needDel.add(i);
			}
			if ("'".equals(strs[i])) {
				leftQuota = !leftQuota;
			}
		}

		for (int i = needDel.size() - 1; i >= 0; i--) {
			int del = needDel.get(i);
			strs[del] = "";
			for (int j = 0; j < keywords.length; j++) {
				int start = keywords[j][0];
				if (del < start) {
					keywords[j][0]--;
					keywords[j][1]--;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (String val : strs) {
			sb.append(val);
		}
		sb.append("\n");
		for (int[] keyword : keywords) {
			sb.append("[").append(keyword[0]).append(",").append(keyword[1]).append("]");
		}
		return sb.toString();
	}

	/**
	 * Life is painting a  picture, not doing 'a sum'
	 * 8 15,20 26,43 45
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		String line = scanner.nextLine();
		String[] splits = line.split(",");
		int[][] keywords = new int[splits.length][2];
		for (int i = 0; i < splits.length; i++) {
			String[] startEnd = splits[i].split(" ");
			keywords[i][0] = Integer.parseInt(startEnd[0]);
			keywords[i][1] = Integer.parseInt(startEnd[1]);
		}

		String res = removeUnnecessarySpace(str, keywords);
		System.out.println(res);
	}

}
