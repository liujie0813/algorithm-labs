package com.timberliu.algorithm.leetcode.back_track.partition.no0093_2_restoreIpAddresses;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原 IP 地址
 *
 */

public class Solution1 {

    public static List<String> restoreIpAddresses(String s) {
    	List<String> res = new ArrayList<>();
    	dfs(s, 0, new ArrayList<>(), res);
    	return res;
    }

    private static void dfs(String s, int curIndex, List<String> curList, List<String> res) {

    	if (curIndex == s.length() && curList.size() == 4) {
    		res.add(transfer(curList));
    		return;
		}

    	if (curIndex == s.length() || curList.size() == 4) {
    		return;
		}

    	int num = 0;
		for (int i = curIndex; i < s.length(); i++) {
			char curCh = s.charAt(i);
			num = 10 * num + (curCh - '0');
			if (num > 255) {
				break;
			}
			curList.add(String.valueOf(num));
			dfs(s, i + 1, curList, res);
			curList.remove(curList.size() - 1);
			if (num == 0) {
				break;
			}
		}

	}

	private static String transfer(List<String> curList) {
    	StringBuilder sb = new StringBuilder();
		for (int i = 0; i < curList.size(); i++) {
			sb.append(curList.get(i));
			if (i != curList.size() - 1) {
				sb.append(".");
			}
		}
		return sb.toString();
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