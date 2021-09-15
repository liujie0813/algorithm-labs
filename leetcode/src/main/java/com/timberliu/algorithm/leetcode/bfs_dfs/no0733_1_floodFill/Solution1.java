package com.timberliu.algorithm.leetcode.bfs_dfs.no0733_1_floodFill;

import java.util.Arrays;

/**
 * 733. 图像渲染
 *
 * @author liujie
 * @date 2021/9/15
 */

public class Solution1 {

	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		floodFill(image, sr, sc, newColor, image[sr][sc]);
		return image;
	}

	public static void floodFill(int[][] image, int sr, int sc, int newColor, int originColor) {
		if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] == newColor || image[sr][sc] != originColor) {
			return;
		}
		image[sr][sc] = newColor;
		floodFill(image, sr - 1, sc, newColor, originColor);
		floodFill(image, sr + 1, sc, newColor, originColor);
		floodFill(image, sr, sc - 1, newColor, originColor);
		floodFill(image, sr, sc + 1, newColor, originColor);
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/flood-fill/ -----");
		int[][] images = {
				{1, 1, 1},
				{1, 1, 0},
				{1, 0, 1}
		};
		int[][] res = floodFill(images, 1, 1, 2);
		for (int[] re : res) {
			System.out.println(Arrays.toString(re));
		}

	}
}
