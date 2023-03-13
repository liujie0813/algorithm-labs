package com.timberliu.algorithm.leetcode.back_track.other.no0022_2_generateParentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 *
 * @author Timber
 * @date 2021/11/2
 */
public class Solution1 {

	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		dfs(n, n, new StringBuilder(), res);
		return res;
	}

	private void dfs(int left, int right, StringBuilder cur, List<String> res) {
		if (left == 0 && right == 0) {
			res.add(cur.toString());
			return;
		}
		// 剩余左括号个数 大于 剩余右括号个数，剪枝
		if (left > right) {
			return;
		}
		if (left > 0) {
			cur.append('(');
			dfs(left - 1, right, cur, res);
			cur.deleteCharAt(cur.length() - 1);
		}
		if (right > 0) {
			cur.append(')');
			dfs(left, right - 1, cur, res);
			cur.deleteCharAt(cur.length() - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/generate-parentheses/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		List<String> res1 = solution1.generateParenthesis(3);
		for (String s : res1) {
			System.out.print(s + ", ");
		}
		System.out.println();

		System.out.println("----- 2 -----");
		List<String> res2 = solution1.generateParenthesis(1);
		for (String s : res2) {
			System.out.print(s + ", ");
		}
		System.out.println();

	}

}
