package com.timberliu.algorithm.leetcode.stack_queue.no0020_1_validParentheses.related.no0678_2_validParenthesisString;

/**
 * 678. 有效的括号字符串
 *
 *  使用贪心，记录 ( 的上限和下限
 *
 * @author Timber
 * @date 2021/9/12
 */
public class Solution2 {

	public static boolean checkValidString(String s) {
		int minCount = 0, maxCount = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				// 左括号，min 和 max 都 ++
				minCount++;
				maxCount++;
			} else if (c == '*') {
				// * 当做 (，max++
				// * 当做 )，min--
				minCount = Math.max(0, minCount - 1);
				maxCount++;
				if (maxCount < 0) {
					return false;
				}
			} else {
				// 右括号，min 和 max 都 --
				minCount = Math.max(0, minCount - 1);
				maxCount--;
			}
		}
		return minCount <= 0;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/valid-parenthesis-string/ -----");
		System.out.println("----- 1 -----");
		System.out.println(checkValidString("()"));

		System.out.println("----- 2 -----");
		System.out.println(checkValidString("(*)"));

		System.out.println("----- 3 -----");
		System.out.println(checkValidString("(*))"));

		System.out.println("----- 4 -----");
		System.out.println(checkValidString("(((**)"));

		System.out.println("----- 5 -----");
		System.out.println(checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));


	}
}
