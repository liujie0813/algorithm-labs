package com.timberliu.algorithm.company.hw.volume_a.logic.no042_2_removeUnnecessarySpace;

import java.util.Scanner;

/**
 * 42. 去除多余空格
 *
 * @author Timber
 * @date 2023/4/24
 */
public class Solution2 {

	public static String removeUnnecessarySpace(String str, String[] keywords) {
		int index = 0;
		boolean lastSpace = false;
		boolean leftQuota = false;
		StringBuilder outputStr = new StringBuilder();
		while (index < str.length()) {
			if (str.charAt(index) == ' ') {
				if (lastSpace && !leftQuota) {
					index++;
					continue;
				}
				lastSpace = true;
			} else {
				lastSpace = false;
			}
			if (str.charAt(index) == '\'') {
				leftQuota = !leftQuota;
			}
			outputStr.append(str.charAt(index));
			index++;
		}

		StringBuilder indexStr = new StringBuilder();
		for (int i = 0; i < keywords.length; i++) {
			int pos = outputStr.indexOf(keywords[i]);
			if (pos == -1) {
				break;
			}
			indexStr.append("[").append(pos).append(", ").append(pos + keywords[i].length() - 1).append("]");
			if (i < keywords.length - 1) {
				indexStr.append(",");
			}
		}
		return outputStr + "\n" + indexStr;
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
		String[] keywords = new String[splits.length];
		for (int i = 0; i < splits.length; i++) {
			String[] index = splits[i].split(" ");
			int startIndex = Integer.parseInt(index[0]);
			int endIndex = Integer.parseInt(index[1]);
			keywords[i] = str.substring(startIndex, endIndex + 1);
		}

		String res = removeUnnecessarySpace(str, keywords);
		System.out.println(res);
	}

}
