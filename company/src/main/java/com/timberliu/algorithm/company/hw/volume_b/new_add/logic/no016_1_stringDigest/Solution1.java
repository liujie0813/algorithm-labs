package com.timberliu.algorithm.company.hw.volume_b.new_add.logic.no016_1_stringDigest;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 16. 字符串摘要
 *
 * @author liujie
 * @date 2023/5/31
 */

public class Solution1 {

	public static String stringDigest(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (Character.isLetter(str.charAt(i))) {
				sb.append(str.charAt(i));
			}
		}

		char[] chars = sb.toString().toCharArray();
		int[] cnt = new int[26];
		List<Node> list = new LinkedList<>();
		int index = chars.length - 1;
		while (index >= 0) {
			int tmp = index;
			while (tmp > 0) {
				char cur = Character.toLowerCase(chars[tmp]);
				cnt[cur - 'a']++;
				char last = Character.toLowerCase(chars[tmp - 1]);
				if (cur != last) {
					break;
				}
				tmp--;
			}
			if (tmp == 0) {
				cnt[Character.toLowerCase(chars[tmp]) - 'a']++;
			}
			char ch = Character.toLowerCase(chars[tmp]);
			if (tmp < index) {
				list.add(0, new Node(ch, index - tmp + 1));
			} else {
				list.add(0, new Node(ch, cnt[ch - 'a'] - 1));
			}
			index = --tmp;
		}

		list.sort((a, b) -> {
			if (a.cnt == b.cnt) {
				return a.ch - b.ch;
			}
			return b.cnt - a.cnt;
		});
		StringBuilder res = new StringBuilder();
		for (Node sub : list) {
			res.append(sub.ch).append(sub.cnt);
		}
		return res.toString();
	}

	static class Node {
		public char ch;
		public int cnt;
		public Node(char ch, int cnt) {
			this.ch = ch;
			this.cnt = cnt;
		}
	}

	/*
	 * aabbcc
	 */
	/**
	 * bAaAcBb
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();

		String res = stringDigest(line);
		System.out.println(res);
	}

}
