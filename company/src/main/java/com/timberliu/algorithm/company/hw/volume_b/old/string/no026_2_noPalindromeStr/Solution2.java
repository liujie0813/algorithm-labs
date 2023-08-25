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
public class Solution2 {

	public static String noPalindromeStr(String str, int n) {
		char[] chars = str.toCharArray();
		// 每一位上的最大限制
		char limit = (char) ('a' + n - 1);

		boolean back = false;
		// 从最低位开始检查
		int i = chars.length - 1;
		while (i >= 0) {
			if (chars[i] < limit) {
				// 如果当前位还有新增空间
				if (!back) {
					chars[i]++;
				} else {
					back = false;
				}
				// abb
				if (i > 0 && chars[i] == chars[i - 1]) {
					continue;
				}
				// aba
				if (i > 1 && chars[i] == chars[i - 2]) {
					continue;
				}
				// 当前位是最低位，可以直接返回
				if (i == chars.length - 1) {
					return new String(chars);
				}
				// 否则只能说明低位没有回文串，还要到高位进行检查
				i++;
				back = true;
			} else {
				// 当前没有新增空间了，当前位变为 'a'，i-1 位加一
				chars[i] = 'a';
				i--;
			}
		}
		return "NO";
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
