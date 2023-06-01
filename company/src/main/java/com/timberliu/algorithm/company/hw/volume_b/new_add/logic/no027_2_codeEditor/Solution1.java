package com.timberliu.algorithm.company.hw.volume_b.new_add.logic.no027_2_codeEditor;

import java.util.Scanner;

/**
 * 27. 代码编辑器
 *
 * @author liujie
 * @date 2023/6/1
 */

public class Solution1 {

	public static String codeEditor(String str, String[] cmds) {
		int index = 0;
		StringBuilder sb = new StringBuilder(str);
		for (int i = 0; i < cmds.length; i++) {
			String cmd = cmds[i];
			int spaceIndex = cmd.indexOf(" ");
			String command = cmd.substring(0, spaceIndex);
			String word = cmd.substring(spaceIndex + 1);
			switch (command) {
				case "FORWARD":
					int x = Integer.parseInt(word);
					index += x;
					if (index >= sb.length()) {
						index = sb.length();
					}
					break;
				case "BACKWARD":
					int x1 = Integer.parseInt(word);
					index -= x1;
					if (index <= 0) {
						index = 0;
					}
					break;
				case "SEARCH-FORWARD":
					String target = word;
					int j = index;
					while (j < sb.length()) {
						int k = 0;
						while (k < target.length() && j + k < sb.length() && sb.charAt(j + k) == target.charAt(k)) {
							k++;
						}
						if (k == target.length()) {
							index = 0;
							break;
						}
						j++;
					}
					break;
				case "SEARCH-BACKWARD":
					String target1 = word;
					int l = index;
					while (l >= 0) {
						int m = 0;
						while (m >= 0 && l - target1.length() + m >= 0 && sb.charAt(l - target1.length() + m) == target1.charAt(m)) {
							m++;
						}
						if (m == target1.length()) {
							index = 0;
							break;
						}
						l++;
					}
					break;
				case "INSERT":
					sb.insert(index, word);
					index = sb.length();
					break;
				case "REPLACE":
					String target2 = word;
					for (int k = 0; k < target2.length(); k++) {
						if (index + k < sb.length()) {
							sb.setCharAt(index + k, target2.charAt(k));
						} else {
							sb.append(target2.charAt(k));
						}
					}
					break;
				case "DELETE":
					int n = Integer.parseInt(word);
					sb.delete(index, index + n);
					break;
			}
		}
		return sb.toString();
	}

	/*
	 * 2
	 * hllo
	 * FORWARD 1
	 * INSERT e
	 */
	/*
	 * 2
	 * hllo
	 * FORWARD 1000
	 * INSERT e
	 */
	/*
	 * 1
	 * hello
	 * REPLACE HELLO WORLD
	 */
	/**
	 * 2
	 * hell
	 * FORWARD 1000
	 * REPLACE o
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int k = Integer.parseInt(scanner.nextLine());
		String str = scanner.nextLine();
		String[] cmds = new String[k];
		for (int i = 0; i < k; i++) {
			cmds[i] = scanner.nextLine();
		}

		String res = codeEditor(str, cmds);
		System.out.println(res);
	}

}
