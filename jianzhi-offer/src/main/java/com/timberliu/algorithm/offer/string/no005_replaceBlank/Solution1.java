package com.timberliu.algorithm.offer.string.no005_replaceBlank;

/**
 * 剑指 Offer 05. 替换空格
 *
 *  统计空格数量
 *  从后往前遍历，遇到空格替换为 %20
 *
 * @author liujie
 * @date 2023/2/28
 */

public class Solution1 {

	public static String replaceSpace(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				count++;
			}
		}
		char[] newChars = new char[s.length() + count * 2];
		int index = s.length() - 1;
		for (int i = newChars.length - 1; i >= 0; i--) {
			if (s.charAt(index) == ' ') {
				newChars[i--] = '0';
				newChars[i--] = '2';
				newChars[i] = '%';
			} else {
				newChars[i] = s.charAt(index);
			}
			index--;
		}
		return new String(newChars);
	}

	public static void main(String[] args) {
		String res = replaceSpace("ab cd ef");
		System.out.println(res);
	}

}
