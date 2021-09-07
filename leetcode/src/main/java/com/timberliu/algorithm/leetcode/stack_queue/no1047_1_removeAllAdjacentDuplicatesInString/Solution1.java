package com.timberliu.algorithm.leetcode.stack_queue.no1047_1_removeAllAdjacentDuplicatesInString;

/**
 * 1047. 删除字符串中的所有相邻重复项
 *
 * @author liujie
 * @date 2021/9/7
 */

public class Solution1 {

	public static String removeDuplicates(String s) {
		char[] chars = s.toCharArray();
		int top = -1;
		for (int i = 0; i < chars.length; i++) {
			if (top != -1 && chars[top] == chars[i]) {
				// 相等（出栈，索引减一）
				top--;
			} else {
				// 不相等，当前元素放到栈顶
				chars[++top] = chars[i];
			}
		}
		return String.valueOf(chars, 0, top + 1);
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/ -----");
		System.out.println("----- 1 -----");
		System.out.println(removeDuplicates("abbaca"));

	}
}
