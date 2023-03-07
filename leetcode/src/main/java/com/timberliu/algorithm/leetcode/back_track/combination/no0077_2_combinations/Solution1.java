package com.timberliu.algorithm.leetcode.back_track.combination.no0077_2_combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 *
<p>给定两个整数 <code>n</code> 和 <code>k</code>，返回范围 <code>[1, n]</code> 中所有可能的 <code>k</code> 个数的组合。</p>

<p>你可以按 <strong>任何顺序</strong> 返回答案。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>n = 4, k = 2
<strong>输出：</strong>
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>n = 1, k = 1
<strong>输出：</strong>[[1]]</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= n <= 20</code></li>
	<li><code>1 <= k <= n</code></li>
</ul>
<div><div>Related Topics</div><div><li>回溯</li></div></div><br><div><li>👍 1300</li><li>👎 0</li></div>
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
		for (int i = lastNum + 1; i <= n; i++) {
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