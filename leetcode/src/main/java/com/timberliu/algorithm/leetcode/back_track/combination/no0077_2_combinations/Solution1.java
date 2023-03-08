package com.timberliu.algorithm.leetcode.back_track.combination.no0077_2_combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 *  [1, n] 中 k 个数的组合
 *
 *  剪枝：
 *    for 循环 [lastNum+1，n-k+1]
 *    还需要 k 个数（包括 i），所以 i 最大为 n-k+1
 *
*/

public class Solution1 {

    public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<>();
		backtrack(n, 0, k, new ArrayList<>(), res);
			return res;
    }

    private static void backtrack(int n, int lastNum, int k, List<Integer> curList, List<List<Integer>> res) {
    	if (k == 0) {
    		res.add(new ArrayList<>(curList));
    		return;
		}
		for (int i = lastNum + 1; i <= n - k + 1; i++) {
			curList.add(i);
			backtrack(n, i, k - 1, curList, res);
			curList.remove(curList.size() - 1);
		}
	}

    public static void main(String[] args) {
		List<List<Integer>> res1 = combine(4, 2);
		for (List<Integer> list1 : res1) {
			for (Integer val1 : list1) {
				System.out.print(val1 + ", ");
			}
			System.out.println();
		}
	}

}