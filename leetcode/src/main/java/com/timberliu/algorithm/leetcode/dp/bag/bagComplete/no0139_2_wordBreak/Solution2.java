package com.timberliu.algorithm.leetcode.dp.bag.bagComplete.no0139_2_wordBreak;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. 单词拆分
 *
 *  给定字符串、一个字符串列表作为字典。判断是否可以利用字典中出现的单词拼接出字符串
 *   不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用
 *
 *  eg: s = leetcode, words = [leet, code]
 *
 *  也可以理解为完全背包的排列问题
 *
 *
 */

public class Solution2 {

    public static boolean wordBreak(String s, List<String> wordDict) {
		Set<String> set = new HashSet<>(wordDict);
		int n = s.length();
		boolean[] dp = new boolean[n + 1];
		dp[0] = true;

		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				String substring = s.substring(j, i);
				if (set.contains(substring) && dp[j]) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[n];
    }

	public static boolean wordBreak1(String s, List<String> wordDict) {
		Set<String> set = new HashSet<>(wordDict);
		int n = s.length();
		boolean[] dp = new boolean[n];
		if (set.contains(s.substring(0, 1))) {
			dp[0] = true;
		}

		for (int i = 0; i < n; i++) {
			// 如果 dp[i] 为 true，表示可以拼出，后面不用再判断了
			for (int j = 0; j <= i && !dp[i]; j++) {
				String subStr = s.substring(j, i + 1);
				if (set.contains(subStr)) {
					if (j >= 1) {
						dp[i] = dp[j - 1];
					} else {
						dp[i] = true;
					}
				}
			}
		}
		return dp[n - 1];
	}

    public static void main(String[] args) {
		boolean res = wordBreak("applepenapple", Arrays.asList("apple", "pen"));
		System.out.println(res);
	}

}