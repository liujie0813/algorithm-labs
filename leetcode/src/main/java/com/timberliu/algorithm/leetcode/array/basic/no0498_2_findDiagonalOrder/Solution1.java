package com.timberliu.algorithm.leetcode.array.basic.no0498_2_findDiagonalOrder;

import java.util.Arrays;

/**
 * 498. 对角线遍历
 *
 * @author liujie
 * @date 2024/9/19
 */

public class Solution1 {

	public int[] findDiagonalOrder(int[][] mat) {
		 int m = mat.length, n = mat[0].length;
		 int[] val = new int[m * n];

		 int index = 0;
		 int level = 0;
		 while (level < m + n - 1) {
		 	 int i = (level < m) ? level : m - 1;
		 	 int j = (level < m) ? 0 : level - (m - 1);
		 	 while (i >= 0 && j < n) {
		 	 	val[index++] = mat[i][j];
		 	 	i--;
		 	 	j++;
			 }
			 level++;

		 	 if (level >= m + n - 1) {
		 	 	break;
			 }
		 	 int j2 = (level < n) ? level : n - 1;
		 	 int i2 = (level < n) ? 0 : level - (n - 1);
		 	 while (i2 < m && j2 >= 0) {
		 	 	val[index++] = mat[i2][j2];
		 	 	i2++;
		 	 	j2--;
			 }
		 	 level++;
		 }
		 return val;
	}

	public static void main(String[] args) {
		Solution1 solution1 = new Solution1();
		int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int[] res = solution1.findDiagonalOrder(arr);
		System.out.println(Arrays.toString(res));

	}

}
