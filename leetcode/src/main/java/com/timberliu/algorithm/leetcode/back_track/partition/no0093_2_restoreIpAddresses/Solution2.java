package com.timberliu.algorithm.leetcode.back_track.partition.no0093_2_restoreIpAddresses;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原 IP 地址
 *
 */

public class Solution2 {

    public static List<String> restoreIpAddresses(String s) {
    	List<String> res = new ArrayList<>();
    	dfs(s, 0, 0, new StringBuilder(), res);
    	return res;
    }

    private static void dfs(String s, int curIndex, int num, StringBuilder sb, List<String> res) {
    	if (curIndex == s.length() && num == 4) {
    		res.add(sb.substring(0, sb.length() - 1));
    		return;
		}
    	if (num == 4) {
    		return;
		}

    	int val = 0;
		for (int i = curIndex; i < s.length(); i++) {
			char curCh = s.charAt(i);
			val = 10 * val + (curCh - '0');
			if (val > 255) {
				break;
			}
			String str = String.valueOf(val);
			int startIndex = sb.length(), endIndex = sb.length() + str.length() + 1;
			sb.append(str).append(".");
			dfs(s, i + 1, num + 1, sb, res);
			sb.delete(startIndex, endIndex);
			if (val == 0) {
				break;
			}
		}

	}

    public static void main(String[] args) {
		List<String> res1 = restoreIpAddresses("25525511135");
		printList(res1);

		List<String> res2 = restoreIpAddresses("0000");
		printList(res2);

	}

	private static void printList(List<String> list) {
		for (String list1 : list) {
			System.out.print(list1 + ", ");
		}
		System.out.println();
	}

}